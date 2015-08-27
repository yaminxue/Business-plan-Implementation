package findyourguide.com.findyourguideapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yamin on 15/3/10.
 */
public class OrderActivity extends ListActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.order);

        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.order,
                new String[]{"guideName","startDate","endDate","city"},
                new int[]{R.id.guideNameText,R.id.startDateText,R.id.endDateText,R.id.ordercityText});
        setListAdapter(adapter);
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("guideName", "Yamin Xue");
        map.put("startDate", "09/03/2015");
        map.put("endDate", "09/04/2015");
        map.put("city","Dublin");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("guideName", "Yunyi Zhu");
        map.put("startDate", "09/03/2015");
        map.put("endDate", "09/04/2015");
        map.put("city","Galway");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("guideName", "Huahua Li");
        map.put("startDate", "09/03/2015");
        map.put("endDate", "09/04/2015");
        map.put("city","Cork");
        list.add(map);

        return list;

    }
}
