package duzones.creativednas.com.duzones;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


public class Courselistforsyll extends AppCompatActivity {

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
        adapter.AddFragment(new fragment_bscforsyll(),"Bsc");
        adapter.AddFragment(new fragment_bcomforsyll(),"Bcom");
        adapter.AddFragment(new fragment_baforsyll(),"Ba");
      //  adapter.AddFragment(new fragment_bed(),"B-ed");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);



    }
}
