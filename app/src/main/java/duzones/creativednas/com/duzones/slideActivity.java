package duzones.creativednas.com.duzones;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class slideActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private Button mPrev,mNext;
    private TextView[] mDots;
    private int currentpage;

    private SliderAdapter sliderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(!isFirstTimeStartApp()){
            startMainActivity();
            finish();
        }

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);
        mNext=(Button)findViewById(R.id.next);
        mPrev=(Button)findViewById(R.id.prev);

        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addmDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListner);

        //on clicklistner


        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current=mSlideViewPager.getCurrentItem()+1;

                if(current<mDots.length) {
                    mSlideViewPager.setCurrentItem(currentpage + 1);
                }
                else {
                    startMainActivity();
                }

            }
        });
        mPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(currentpage-1);
            }
        });

    }
    private void startMainActivity(){
       setFirstTimeStartStatus(false);
        startActivity(new Intent(slideActivity.this,home.class));
        finish();
    }
    private void setStatusBarTransparent(){
        if(Build.VERSION.SDK_INT>=21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_FULLSCREEN);
            Window window=getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);


        }
    }

    public void addmDotsIndicator(int position){
        mDots=new TextView[3];
        mDotLayout.removeAllViews();

        for(int i=0; i<mDots.length;i++){
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            mDotLayout.addView(mDots[i]);

        }
        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.grey_));
        }
    }

    ViewPager.OnPageChangeListener viewListner =new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addmDotsIndicator(i);
            currentpage=i;
       /*     if(i==mDots.length-1){
                mNext.setText("START");
                mPrev.setVisibility(View.GONE);
            }
            else{
                mNext.setText("NEXT");
                mPrev.setVisibility(View.VISIBLE);
            }*/
            if(i==0){
                mNext.setEnabled(true);
                mPrev.setEnabled(false);
                mPrev.setVisibility(View.INVISIBLE);

                mNext.setText("Next");
             //   mPrev.setText("");
            }else if(i==mDots.length-1){
                mNext.setEnabled(true);
                mPrev.setEnabled(true);
                mPrev.setVisibility(View.VISIBLE);

                mNext.setText("Finish");
                mPrev.setText("Back");
            }else{
                mNext.setEnabled(true);
                mPrev.setEnabled(true);
                mPrev.setVisibility(View.VISIBLE);

                mNext.setText("Next");
                mPrev.setText("Back");
            }


        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
    private boolean isFirstTimeStartApp(){
        SharedPreferences ref =getApplicationContext().getSharedPreferences("IntroSlideApp",Context.MODE_PRIVATE);
        return ref.getBoolean("FirstTimeStartFlag",true);
    }
    private void setFirstTimeStartStatus(boolean stt) {
        SharedPreferences ref =getApplicationContext().getSharedPreferences("IntroSlideApp",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=ref.edit();
        editor.putBoolean("FirstTimeStartFlag",stt);
        editor.commit();
    }
}
