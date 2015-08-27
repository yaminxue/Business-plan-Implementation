package findyourguide.com.findyourguideapp;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Window;
//import android.view.Window;


public class MainActivity extends ActionBarActivity {

    ViewPager viewPager1 =null;
    ViewPager viewPager2 =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
      //  this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        viewPager1 =(ViewPager)findViewById(R.id.viewPager1);
        FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager1.setAdapter(new MyAdapter1(fragmentManager));

        viewPager2=(ViewPager)findViewById(R.id.viewPager2);
        viewPager2.setAdapter(new MyAdapter2(fragmentManager));

    }
    class MyAdapter1 extends FragmentPagerAdapter{
        public MyAdapter1(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment=null;
            if(i==0){
                fragment=new Fragment_Dublin();
            }
            if(i==1){
                fragment=new Fragment_Galway();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
    class MyAdapter2 extends FragmentPagerAdapter{

        public MyAdapter2(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment=null;
            if(i==0){
                fragment=new Fragment_Limerick();
            }
            if(i==1){
                fragment=new Fragment_Cork();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }



}
