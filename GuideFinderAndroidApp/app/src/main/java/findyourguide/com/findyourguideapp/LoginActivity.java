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
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOError;
import java.io.IOException;



/**
 * Created by jocar_000 on 2/25/2015.
 */
public class LoginActivity extends Activity {

    private EditText email;
    private EditText pwd;
    private Button login;
    private Button SignUp;

    private static String LOGIN_URL="http://10.0.0.7:8080/GuideFinder/androidLogin.action?";
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
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView(){
        email=(EditText)findViewById(R.id.email);
        pwd=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.email_sign_in_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(email.getText().toString(),pwd.getText().toString());

            }
        });
        SignUp=(Button)findViewById(R.id.email_sign_up_button);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void login(String email,String pwd){
        String message="";
        HttpClient httpClient=new DefaultHttpClient();
        String changedURL=this.LOGIN_URL+"email="+email+"&pwd="+pwd;
        HttpGet request=new HttpGet(changedURL);
        request.addHeader("Accept","text/json");
        try {
            HttpResponse response = httpClient.execute(request);
            HttpEntity httpEntity=response.getEntity();
            String json= EntityUtils.toString(httpEntity,"UTF-8");
            if(json!=null){
                JSONObject jsonObject=new JSONObject(json);
                boolean result=(boolean)jsonObject.get("success");
                status=result;
                if(result==true){
                    message="Login Success!";
                    Context context=LoginActivity.this;
                    SharedPreferences sharedPreferences=context.getSharedPreferences("SP",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    JSONObject user=jsonObject.getJSONObject("user");

                    editor.putString("email",(String)user.get("email"));
                    editor.putString("first_name",(String)user.get("first_name"));
                    editor.putString("last_name",(String)user.get("last_name"));
                    editor.commit();

                }else{
                    message="Login Fail!";
                }

            }
        }
        catch(IOException E){
            message="Login Fail!";
        }
        catch (JSONException e){
            message="Login Fail!";
        }
        AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle("Remind").setPositiveButton("OK",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if(status==true) {
                    Intent intent = new Intent(LoginActivity.this, OrderActivity.class);
                    startActivity(intent);
                }
            }
        }).setMessage(message).create().show();

    }
}
