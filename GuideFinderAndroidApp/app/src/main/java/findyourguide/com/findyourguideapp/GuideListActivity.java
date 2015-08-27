package findyourguide.com.findyourguideapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yamin on 15/3/10.
 */
public class GuideListActivity extends ListActivity {
    private static String SEARCH_URL="http://10.0.0.7:8080/GuideFinder/androidGuideSearch.action?city=";
    private static String status="fail";
    private List<Map<String, Object>> mData;
    private MyTask myTask;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                .detectDiskReads()
//                .detectDiskWrites()
//                .detectNetwork()   // or .detectAll() for all detectable problems
//                .penaltyLog()
//                .build());
//        //设置虚拟机的策略
//        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
//                .detectLeakedSqlLiteObjects()
//                        //.detectLeakedClosableObjects()
//                .penaltyLog()
//                .penaltyDeath()
//                .build());
        mData=new ArrayList<Map<String,Object>>();
        myTask=new MyTask();
        myTask.execute(SEARCH_URL+getIntent().getStringExtra("city"));


    }

//    private List<Map<String, Object>> getData() {
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("guideImage", R.drawable.haonian);
//        map.put("name", "Haonian Li");
//        map.put("chatImage",R.drawable.conversation);
//        map.put("city", "Dublin");
//        map.put("job","Student");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("guideImage", R.drawable.chenhao);
//        map.put("name", "Chenhao Yu");
//        map.put("chatImage",R.drawable.conversation);
//        map.put("city", "Dublin");
//        map.put("job","Student");
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("guideImage", R.drawable.yamin);
//        map.put("name", "Yamin Xue");
//        map.put("chatImage",R.drawable.conversation);
//        map.put("city", "Dublin");
//        map.put("job","Student");
//        list.add(map);
//
//        return list;
//    }

    // ListView 中某项被选中后的逻辑
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        Log.v("GuideListActivity-click", (String) mData.get(position).get("name"));
    }


    public final class ViewHolder{
        public ImageButton guideImage;
        public TextView name;
        public ImageButton chatImage;
        public TextView city;
        public TextView job;
    }


    public class MyAdapter extends BaseAdapter {

        private LayoutInflater mInflater;


        public MyAdapter(Context context){
            this.mInflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mData.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            if (convertView == null) {

                holder=new ViewHolder();

                convertView = mInflater.inflate(R.layout.guidelist, null);
                holder.guideImage = (ImageButton)convertView.findViewById(R.id.guideImage);
                holder.name = (TextView)convertView.findViewById(R.id.nameText);
                holder.chatImage = (ImageButton)convertView.findViewById(R.id.chatGuideImage);
                holder.city = (TextView)convertView.findViewById(R.id.cityText);
                holder.job = (TextView)convertView.findViewById(R.id.jobText);
                convertView.setTag(holder);

            }else {

                holder = (ViewHolder)convertView.getTag();
            }



            holder.guideImage.setBackground((Drawable)mData.get(position).get("guideImage"));
            holder.name.setText((String)mData.get(position).get("name"));
            holder.chatImage.setBackgroundResource((Integer)mData.get(position).get("chatImage"));
            holder.city.setText((String) mData.get(position).get("city"));
            holder.job.setText((String) mData.get(position).get("job"));

            holder.chatImage.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(GuideListActivity.this, ChatActivity.class);
                    startActivity(intent);
                }
            });

            holder.guideImage.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent(GuideListActivity.this, GuideInfoActivity.class);
                    startActivity(intent1);
                }
            });


            return convertView;
        }

    }
    private class MyTask extends AsyncTask{
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();


        @Override
        protected void onPreExecute() {
            Toast.makeText(GuideListActivity.this,"loading...",Toast.LENGTH_LONG).show();
        }

        @Override
        protected List<Map<String, Object>> doInBackground(Object[] params) {
           // Log.i("mytask",getIntent().getStringExtra("city"));


            try{

                HttpClient httpClient=new DefaultHttpClient();
               // Log.i("url",(String)params[0]);
                HttpGet request=new HttpGet((String)params[0]);

                HttpResponse httpResponse=httpClient.execute(request);
               // Log.i("url",(String)params[0]);
                if(httpResponse.getStatusLine().getStatusCode()== 200){

                    HttpEntity httpEntity=httpResponse.getEntity();
                    String json= EntityUtils.toString(httpEntity,"UTF-8");
                    JSONObject jsonObject=new JSONObject(json);
                    boolean isEmpty=(boolean)jsonObject.get("isEmpty");
                    if(isEmpty==false){
                        JSONArray guideList=jsonObject.getJSONArray("guidelist");
                       // Log.i("length",String.valueOf(guideList.length()));

                        for(int i=0;i<guideList.length();i++){
                            JSONObject obj=guideList.getJSONObject(i);
                            Log.i("name",(String)obj.get("name"));
                            Map<String, Object> map = new HashMap<String, Object>();

                            map.put("guideImage", loadImageFromNetwork((String)obj.get("headicon")) );
                            map.put("name", (String)obj.get("name"));
                            map.put("chatImage",R.drawable.conversation);
                            map.put("city", "Dublin");
                            map.put("job","Student");
                            list.add(map);
                        }
                        status="success";
                    }
                    else{
                        status="fail";
                    }
                }
            }catch(IOException e){

            }catch (JSONException e){

            }

            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            if(status.equals("fail")){
                AlertDialog.Builder builder=new AlertDialog.Builder(GuideListActivity.this);
                builder.setTitle("Remind").setPositiveButton("OK",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                        Intent intent = new Intent(GuideListActivity.this, SearchActivity.class);
                        startActivity(intent);

                    }
                }).setMessage("Search Fail!:(").create().show();
            }
            else {

                mData = list;
                MyAdapter adapter = new MyAdapter(GuideListActivity.this);
                setListAdapter(adapter);
            }
        }
    }
    private Drawable loadImageFromNetwork(String url){
        Drawable drawable = null;
        try{
            //judge if has picture locate or not according to filename
            drawable = Drawable.createFromStream(new URL(url).openStream(), "headicon.jpg");
        }catch(IOException e){
            Log.d("test",e.getMessage());
        }
        if(drawable == null){
            Log.d("test","null drawable");
        }else{
            Log.d("test","not null drawable");
        }
        return drawable;

    }


}
