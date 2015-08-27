package findyourguide.com.findyourguideapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by yamin on 15/3/9.
 */
public class TailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tail, container, false);


        ImageButton homeButton = (ImageButton) view.findViewById(R.id.homeImage);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        ImageButton orderButton = (ImageButton) view.findViewById(R.id.orderImage);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), OrderActivity.class);
                startActivity(intent1);
            }
        });

        ImageButton messageButton = (ImageButton) view.findViewById(R.id.chatImage);
        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(), MessageActivity.class);
                startActivity(intent2);
            }
        });

        ImageButton locationButton = (ImageButton) view.findViewById(R.id.locationImage);
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getActivity(), LocationActivity.class);
                startActivity(intent3);
            }
        });

        ImageButton serviceButton = (ImageButton) view.findViewById(R.id.contactImage);
        serviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getActivity(), ServiceActivity.class);
                startActivity(intent4);
            }
        });

        return view;
    }
}
