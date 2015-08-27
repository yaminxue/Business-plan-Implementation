package findyourguide.com.findyourguideapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by yamin on 15/3/10.
 */
public class ServiceActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus);

        Button btn1 =(Button)findViewById(R.id.guideTel);
        final String tel1 = getResources().getString(R.string.tel1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri =Uri.parse("tel:"+tel1);
                Intent intent1 = new Intent(Intent.ACTION_CALL,uri);
                startActivity(intent1);
            }
        });

        Button btn2 =(Button)findViewById(R.id.guide1Tel);
        final String tel2 = getResources().getString(R.string.tel2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri1 =Uri.parse("tel:"+tel2);
                Intent intent2 = new Intent(Intent.ACTION_CALL,uri1);
                startActivity(intent2);
            }
        });

        Button btn3 =(Button)findViewById(R.id.guide2Tel);
        final String tel3 = getResources().getString(R.string.tel3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri2 =Uri.parse("tel:"+tel3);
                Intent intent3 = new Intent(Intent.ACTION_CALL,uri2);
                startActivity(intent3);
            }
        });

        Button btn4 =(Button)findViewById(R.id.guide3Tel);
        final String tel4 = getResources().getString(R.string.tel4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri3 =Uri.parse("tel:"+tel4);
                Intent intent4 = new Intent(Intent.ACTION_CALL,uri3);
                startActivity(intent4);
            }
        });


    }
}
