package duzones.creativednas.com.duzones;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class splash_screen extends AppCompatActivity {
    private static int TIME_OUT =3000;

    Animation animation,animation2,animation3;
    TextView textView;
    ImageView im1,im2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        im1 = findViewById(R.id.mainlogo);
        im2 = findViewById(R.id.mainlogotext);

        animation = AnimationUtils.loadAnimation(this,R.anim.rotate);
        animation2 = AnimationUtils.loadAnimation(this,R.anim.slideup);


        im1.setAnimation(animation);
        im2.setAnimation(animation2);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splash_screen.this,slideActivity.class));
                finish();
            }
        },(long)TIME_OUT);
    }
}
