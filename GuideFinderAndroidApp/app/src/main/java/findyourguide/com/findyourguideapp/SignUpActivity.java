package findyourguide.com.findyourguideapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jocar_000 on 3/14/2015.
 */
public class SignUpActivity extends Activity {
    private EditText email;
    private EditText pwd;
    private EditText first_name;
    private EditText last_name;
    private EditText confirmedpwd;
    private Button signup;

    private static String SIGNUP_URL="http://10.0.0.7:8080/GuideFinder/androidSignup";
    private static boolean status=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()   // or .detectAll() for all detectable problems
                .penaltyLog()
                .build());
        //设置虚拟机的策略
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                        //.detectLeakedClosableObjects()
                .penaltyLog()
                .penaltyDeath()
                .build());
        setContentView(R.layout.signup);
        initView();
    }

    private void initView(){
        email=(EditText)findViewById(R.id.signup_email);
        first_name=(EditText)findViewById(R.id.signup_firstname);
        last_name=(EditText)findViewById(R.id.signup_lastname);
        pwd=(EditText)findViewById(R.id.signup_password);
        confirmedpwd=(EditText)findViewById(R.id.signup_confirmPwd);
        signup=(Button)findViewById(R.id.signup_submit);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pwd.getText().toString().equals(confirmedpwd.getText().toString())) {
                    signup(email.getText().toString(), first_name.getText().toString(),
                            last_name.getText().toString(), pwd.getText().toString());
                }else{
                    AlertDialog.Builder builder=new AlertDialog.Builder(SignUpActivity.this);
                    builder.setTitle("Remind").setPositiveButton("OK",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    }).setMessage("Password is not consistent").create().show();
                }

            }
        });

    }

    private void signup(String email,String first_name,String last_name,String pwd){
        String message="";

        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(this.SIGNUP_URL);

            List<NameValuePair> paramList = new ArrayList<NameValuePair>();
            BasicNameValuePair param = new BasicNameValuePair("email", email);
            paramList.add(param);
            param = new BasicNameValuePair("first_name", first_name);
            paramList.add(param);
            param = new BasicNameValuePair("last_name", last_name);
            paramList.add(param);
            param = new BasicNameValuePair("pwd", pwd);
            paramList.add(param);

            httpPost.setEntity(new UrlEncodedFormEntity(paramList, HTTP.UTF_8));

            HttpResponse httpResponse=httpClient.execute(httpPost);
            if(httpResponse.getStatusLine().getStatusCode()==200) {
                HttpEntity httpEntity = httpResponse.getEntity();

                String json = EntityUtils.toString(httpEntity, "UTF-8");
                if(json!=null){
                    JSONObject jsonObject=new JSONObject(json);
                    boolean signup_status=(boolean)jsonObject.get("signup");
                    status=signup_status;
                    if(signup_status==true){
                        Context context=SignUpActivity.this;
                        SharedPreferences SP=context.getSharedPreferences("SP",MODE_PRIVATE);
                        SharedPreferences.Editor editor=SP.edit();
                        editor.putString("email",email);
                        editor.putString("first_name",first_name);
                        editor.putString("last_name",last_name);
                        editor.commit();
                        message="SignUp Success!";
                    }
                    else {
                        message="SignUp Fail!";
                    }
                }
            }

        }
        catch(UnsupportedEncodingException e){
            message="SignUp Fail!";
        }catch(IOException e){
            message="SignUp Fail!";

        }catch(JSONException e){
            message="SignUp Fail!";

        }
        AlertDialog.Builder builder=new AlertDialog.Builder(SignUpActivity.this);
        builder.setTitle("Remind").setPositiveButton("OK",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if(status==true) {
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{

                }
            }
        }).setMessage(message).create().show();


    }
}
