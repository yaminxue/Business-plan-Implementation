package findyourguide.com.findyourguideapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by yamin on 15/3/10.
 */
public class SearchActivity extends Activity{

    private ImageButton searchButton;
    private EditText searchText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        searchText=(EditText)findViewById(R.id.searchText);
        searchButton=(ImageButton)findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SearchActivity.this,GuideListActivity.class);
                intent.putExtra("city",searchText.getText().toString());
                startActivity(intent);
            }
        });
    }
}
