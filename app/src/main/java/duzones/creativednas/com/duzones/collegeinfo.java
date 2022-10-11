package duzones.creativednas.com.duzones;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.support.annotation.DrawableRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class collegeinfo extends AppCompatActivity {
    String colname,collink;
    TextView cName;
    String corname;
    String colbro;
    TextView crName;
    String colmapname = null;
    Button l_button, b_button, o_button;
    Intent mintent = null, mchooser = null;


    int img = 0;
    ImageView imv;
    String coursedetail = null;
    TextView c_detail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b_button = findViewById(R.id.brochurebutton);
        Firebase.setAndroidContext(this);


        setContentView(R.layout.activity_collegeinfo);
        l_button = findViewById(R.id.b_location);
        b_button = findViewById(R.id.brochurebutton);
        o_button = findViewById(R.id.officialbutton);


        imv = findViewById(R.id.college_image);
        c_detail = findViewById(R.id.detailedcourses);


        colname = getIntent().getExtras().getString("collegenametopass");
        corname = getIntent().getExtras().getString("coursesnametopass");
        colmapname = getIntent().getExtras().getString("colmapnametopass");
        img = getIntent().getExtras().getInt("colimagetopass");
        coursedetail = getIntent().getExtras().getString("coursedetailtopass");
        collink = getIntent().getExtras().getString("collinktopass");
        colbro = getIntent().getExtras().getString("borlinktopass");

        cName = findViewById(R.id.collegename);
        cName.setText(colname);
        crName = findViewById(R.id.coursesname);
        crName.setText(corname);
        imv.setImageResource(img);
        c_detail.setText(coursedetail);


        l_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mintent = new Intent(android.content.Intent.ACTION_VIEW);
                mintent.setData(Uri.parse("geo:0,0?q=" + colmapname));
                mchooser = Intent.createChooser(mintent, "choose map application");
                startActivity(mchooser);
                Toast.makeText(collegeinfo.this, "Loading...", Toast.LENGTH_SHORT).show();
            }
        });

        b_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               // Snackbar snackbar = Snackbar.make(findViewById(R.id.rootlayoutoo), "working", Snackbar.LENGTH_LONG);
                //snackbar.show();
                //Toast.makeText(collegeinfo.this, "opening...", Toast.LENGTH_SHORT).show();
                Intent a= new Intent(collegeinfo.this,tryfirebase.class);
                a.putExtra("link_to_pass",colbro);
                startActivity(a);
            }
        });

        o_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(collegeinfo.this, "opening...", Toast.LENGTH_SHORT).show();
                Intent a= new Intent(collegeinfo.this,tryfirebase.class);
                a.putExtra("link_to_pass",collink);
                startActivity(a);




            }
        });









    }

}
