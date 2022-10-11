package duzones.creativednas.com.duzones;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;


public class Courselist extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courselist);
        tabLayout=(TabLayout)findViewById(R.id.courselayout);
        viewPager=(ViewPager)findViewById(R.id.coursepage);
        adapter=new ViewPagerAdapter(getSupportFragmentManager());

        // Add Fragment Here
        adapter.AddFragment(new fragment_bsc(),"Bsc");
        adapter.AddFragment(new fragment_bcom(),"Bcom");
        adapter.AddFragment(new fragment_ba(),"Ba");
      //  adapter.AddFragment(new fragment_bed(),"B-ed");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);



    }
}
