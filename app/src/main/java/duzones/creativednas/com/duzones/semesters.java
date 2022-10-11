package duzones.creativednas.com.duzones;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class semesters extends AppCompatActivity {
    /**********************************FIREBASE HELPER START************************/
    public class FirebaseHelper {

        DatabaseReference db;
        ArrayList<semesterclass> semesterclass = new ArrayList<>();
        ListView mListView;
        Context c;
        Query query;


        /*
       let's receive a reference to our FirebaseDatabase
       */
        public FirebaseHelper(DatabaseReference db, Context context, ListView mListView, Query query) {
            this.db = db;
            this.c = context;
            this.mListView = mListView;
            this.query = query;
            this.retrieve();
        }


        /*
        Retrieve and Return them clean data in an arraylist so that they just bind it to ListView.
         */
        public ArrayList<semesterclass> retrieve() {


            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    semesterclass.clear();
                   // if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            //Now get semesterclass Objects and populate our arraylist.
                            semesterclass semesterclass = ds.getValue(semesterclass.class);
                            FirebaseHelper.this.semesterclass.add(semesterclass);
                        }


                        adapter = new CustomAdapter(c, semesterclass);
                        mListView.setAdapter(adapter);

                        new Handler().post(new Runnable() {
                            @Override
                            public void run() {
                                mListView.smoothScrollToPosition(semesterclass.size());
                            }
                        });
                   // }



                    }


                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.d("mTAG", databaseError.getMessage());
                    Toast.makeText(c, "ERROR " + databaseError.getMessage(), Toast.LENGTH_LONG).show();

                }
            });

            return semesterclass;
        }

    }

    /**********************************CUSTOM ADAPTER START************************/
    class CustomAdapter extends BaseAdapter {
        Context c;
        ArrayList<semesterclass> semesterclass;

        public CustomAdapter(Context c, ArrayList<semesterclass> semesterclass) {
            this.c = c;
            this.semesterclass = semesterclass;
        }

        @Override
        public int getCount() {
            return semesterclass.size();
        }

        @Override
        public Object getItem(int position) {
            return semesterclass.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(c).inflate(R.layout.cutofflmodel, parent, false);
            }

            TextView cutoffTextView = convertView.findViewById(R.id.cutoffTextView);


            final semesterclass s = (semesterclass) this.getItem(position);

            cutoffTextView.setText(s.getName());
            s.getpaperLink();
            s.getsemester();


            //ONITECLICK
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(c, s.getpaperLink(), Toast.LENGTH_SHORT).show();
                    todownload = new Intent(semesters.this,tryfirebase.class);
                    todownload.putExtra("link_to_pass",s.getpaperLink());
                    startActivity(todownload);
                }
            });
            return convertView;
        }
    }

    /**********************************MAIN ACTIVITY CONTINUATION************************/
    //instance fields
    DatabaseReference db;
    FirebaseHelper helper;
    CustomAdapter adapter;
    ListView mListView;
    String coursename,coursenamelast=null;
    String semester;
    RadioGroup radioGroup;
    RadioButton r_one, r_two, r_three, r_four, r_five, r_six;
    RadioButton temp;
    Button apply;
    LinearLayout radio_layout;
    Intent todownload;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semesters);






        semester = "All";
        coursename = getIntent().getExtras().getString("pass");
        mListView = findViewById(R.id.myListView);
        r_one = findViewById(R.id.call);
        r_two = findViewById(R.id.cmusic);
        r_three = findViewById(R.id.cdance);
        r_four = findViewById(R.id.ctech);
        r_five = findViewById(R.id.cfun);
        r_six = findViewById(R.id.cart);
        radioGroup = findViewById(R.id.radiogroup);
        apply = findViewById(R.id.applybutton);
        radio_layout = findViewById(R.id.radiolayout);
        radio_layout.setVisibility(View.VISIBLE);





        db = FirebaseDatabase.getInstance().getReference("Papers").child(coursename);
        Query quer = FirebaseDatabase.getInstance().getReference("Papers").child(coursename)
                .orderByChild("name");
        helper = new FirebaseHelper(db, this, mListView, quer);


        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_layout.getVisibility() == View.VISIBLE) {
                    radio_layout.setVisibility(View.GONE);
                } else {
                    radio_layout.setVisibility(View.VISIBLE);
                }

            }
        });



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {



                check_checkbox(checkedId);
            }
        });


        //initialize firebase database






    }


    public void check_checkbox(int checkedId) {

        temp = findViewById(checkedId);
       // Toast.makeText(this, "Loading events: "+temp.getText().toString(), Toast.LENGTH_SHORT).show();
        semester = temp.getText().toString();

        mListView = findViewById(R.id.myListView);
        //initialize firebase database
        if (Objects.equals(semester, "All")) {
            Query query = FirebaseDatabase.getInstance().getReference("Papers").child(coursename);
            helper = new FirebaseHelper(db, this, mListView, query);
        } else {
            Query query = FirebaseDatabase.getInstance().getReference("Papers").child(coursename)
                    .orderByChild("semester").equalTo(semester);
            helper = new FirebaseHelper(db, this, mListView, query);
        }


    }





}



