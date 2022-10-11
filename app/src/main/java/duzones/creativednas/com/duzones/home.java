package duzones.creativednas.com.duzones;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Objects;
import java.util.Random;

public class home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,UpdateHelper.onUpdateCheckListner {
    private DrawerLayout drawer;
    private int STORAGE_PERMISSION_CODE=1;
    Dialog faq,callbox;
    Button sendemailb,Nothanks,updatenow;
    ImageView closecallbox,settingicon;
    EditText subbox,textbox;
    int fragmentseeker =0;
    Dialog update;
    TextView txtdismiss;
    Toolbar toolbar;
    Snackbar snackbar,snackbar2;


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==STORAGE_PERMISSION_CODE){
            if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){

            }else{
                ActivityCompat.requestPermissions(home.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},STORAGE_PERMISSION_CODE);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        update=new Dialog(this);
        txtdismiss=(TextView)findViewById(R.id.txtclose);
        Nothanks=(Button)findViewById(R.id.nothanks);
        updatenow=(Button)findViewById(R.id.update_now);
        UpdateHelper.with(this)
                .onUpdateCheck(this)
                .check();

        if(!checknetwork(home.this))
        {
            snackbar2 = Snackbar.make(findViewById(R.id.llout), "You are offline!", Snackbar.LENGTH_LONG);
            snackbar2.show();

        }
        if (ContextCompat.checkSelfPermission(home.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
        }else{
            //requeststoragepermission();
            ActivityCompat.requestPermissions(home.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},STORAGE_PERMISSION_CODE);

        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Study Portal");
        toolbar.setElevation(0);
        getSupportActionBar().setElevation(0);


        FirebaseMessaging.getInstance().subscribeToTopic("fall");
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new fragment_home()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

        callbox = new Dialog(this);
        snackbar = Snackbar.make(findViewById(R.id.llout), "Press back Again to exit", Snackbar.LENGTH_LONG);




    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem Item) {

        switch (Item.getItemId()) {
            case R.id.nav_home:
                toolbar.setTitle("DU Zones");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_home()).commit();

                break;

            case R.id.nav_share:
            //    Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                send();
                break;
            case R.id.nav_rate:
             //   Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                rateMe();

                break;
            case R.id.nav_aboutapp:
                Intent iz=new Intent(home.this,about_app.class);
                startActivity(iz);
                break;

            case R.id.nav_aboutdevelopers:
               Intent i=new Intent(home.this,about_developer.class);
               startActivity(i);
               // Toast.makeText(this, "aboutdevelopers", Toast.LENGTH_LONG).show();

                break;

            case R.id.nav_email:
                opendailogemail();
                break;


            case R.id.nav_privacypolicy:
                Intent izz=new Intent(home.this,privacypolicy.class);
                startActivity(izz);
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }


else  if(snackbar.isShown())
        {
            super.onBackPressed();
            fragmentseeker = 0;
        }

        else
            snackbar.show();

    }

    public void opendailogemail() {
       // Toast.makeText(this, "loading", Toast.LENGTH_LONG).show();
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "creativednas@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, " DUZONES ");
        startActivity(Intent.createChooser(emailIntent, null));

    }

    public void send(){
        Intent send =new Intent(Intent.ACTION_SEND);
        String appPackageName =getApplicationContext().getPackageName();
        String strAppLink="";
        try {
            strAppLink="https://play.google.com/store/apps/details?id="+appPackageName;
        }
        catch (android.content.ActivityNotFoundException anfe)
        {
            strAppLink="https://play.google.com/store/apps/details?id="+appPackageName;
        }
        send.setType("text/Link");
        String shareBody="Hey!"+
                "\n"+""+strAppLink;
        String shareSub="APP NAME";
        send.putExtra(Intent.EXTRA_SUBJECT,shareSub);
        send.putExtra(Intent.EXTRA_TEXT,shareBody);
        startActivity(Intent.createChooser(send,"Share using"));

    }

    public void rateMe() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + getPackageName())));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }


    public void opendailogcall()
    {
       // Toast.makeText(this, "contact", Toast.LENGTH_LONG).show();
        callbox.setContentView(R.layout.faq);
        closecallbox = callbox.findViewById(R.id.closecallbox);
        callbox.setCancelable(false);
        callbox.setCanceledOnTouchOutside(false);
        closecallbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        callbox.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        callbox.show();
    }

    public boolean checknetwork(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if((networkInfo != null) && networkInfo.isConnectedOrConnecting())
        {
            android.net.NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobiledata = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobiledata!=null && mobiledata.isConnectedOrConnecting())||(wifi!=null && wifi.isConnectedOrConnecting()))
                return true;
            else return false;
        }
        else return  false;
    }

    @Override
    public void onUpdateCheckListner(final String AppUrl) {


        AlertDialog alertDialog =new AlertDialog.Builder(this)
                .setTitle("New version available")
                .setMessage("Please Update to new version")
                .setIcon(R.mipmap.ic_launcherslast)
                .setPositiveButton("UPDATE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(
                                AppUrl)));
                    }
                }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        alertDialog.show();
        Button update = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        update.setTextColor(Color.parseColor("#12b3f1"));
        Button nothanks = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        nothanks.setTextColor(Color.parseColor("#7c7c7c"));



 /*       update.setContentView(R.layout.updatebox);

        Nothanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update.dismiss();
            }
        });

        updatenow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(
                        "https://play.google.com/store/apps/details?id=duzones.creativednas.com.duzones")));
            }
        });

        update.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        update.show();
*/
    }
}
