package duzones.creativednas.com.duzones;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class about_developer extends AppCompatActivity {
    Dialog profileamzi,profilesuraj;
    Button b_amziproflie,suraj_profile;
    ImageView closeprofileamzi,closeprofilesuraj;
    CardView amzadfb,amzadinsta,surajfb,surajinsta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_developer);

        profileamzi = new Dialog(this);
        profilesuraj=new Dialog(this);

        b_amziproflie = findViewById(R.id.p_amzi);
        suraj_profile=findViewById(R.id.suraj_button);

        b_amziproflie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendailogamziprofile();
            }
        });

        suraj_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    opendailogsurajprofile();

              }
        });
    }


    public void opendailogamziprofile() {
//        Toast.makeText(getActivity(), "loading", Toast.LENGTH_LONG).show();
        profileamzi.setContentView(R.layout.amziprofilebox);
        amzadfb = profileamzi.findViewById(R.id.card_amzifb);
        amzadinsta = profileamzi.findViewById(R.id.card_amziinsta);

        closeprofileamzi = profileamzi.findViewById(R.id.closeprofileamzix);
        closeprofileamzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profileamzi.dismiss();
            }
        });

        amzadfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "https://www.facebook.com/amziey")));

                profileamzi.dismiss();
            }
        });

        amzadinsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "https://www.instagram.com/amzieey/")));

                profileamzi.dismiss();
            }
        });


        profileamzi.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        profileamzi.show();
    }

    public void opendailogsurajprofile() {
//        Toast.makeText(getActivity(), "loading", Toast.LENGTH_LONG).show();
        profilesuraj.setContentView(R.layout.surajprofilebox);
        surajfb = profilesuraj.findViewById(R.id.card_surajfb);
        surajinsta = profilesuraj.findViewById(R.id.card_surajinsta);

        closeprofilesuraj = profilesuraj.findViewById(R.id.closeprofilesurajx);
        closeprofilesuraj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profilesuraj.dismiss();
            }
        });

        surajfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "https://www.facebook.com/profile.php?id=100005626260143")));

                profilesuraj.dismiss();
            }
        });

        surajinsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "https://www.instagram.com/officialsuraj_/")));

                profilesuraj.dismiss();
            }
        });


        profilesuraj.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        profilesuraj.show();
    }

}
