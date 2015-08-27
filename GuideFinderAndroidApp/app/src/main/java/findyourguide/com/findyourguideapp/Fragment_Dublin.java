package findyourguide.com.findyourguideapp;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by jocar_000 on 2/25/2015.
 */
public class Fragment_Dublin extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dublin, container, false);

        ImageButton dublinButton = (ImageButton) view.findViewById(R.id.dublinImage);
        dublinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), GuideListActivity.class);
                intent1.putExtra("city","dublin");
                startActivity(intent1);
            }
        });
        return view;
    }
}
