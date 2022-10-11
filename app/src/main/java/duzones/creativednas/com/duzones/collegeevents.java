package duzones.creativednas.com.duzones;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

public class collegeevents extends AppCompatActivity {



    public class FirebaseHelper {

        DatabaseReference db;
        ArrayList<events> events = new ArrayList<>();
        ListView mListView;
        Context c;
        Query query;



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
        public ArrayList<events> retrieve() {
            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    events.clear();
                    if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            //Now get events Objects and populate our arraylist.
                            events events = ds.getValue(events.class);
                            FirebaseHelper.this.events.add(events);
                        }
                        adapter = new CustomAdapter(c, events);
                        mListView.setAdapter(adapter);

                        new Handler().post(new Runnable() {
                            @Override
                            public void run() {
                                mListView.smoothScrollToPosition(events.size());
                            }
                        });
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.d("mTAG", databaseError.getMessage());
                    Toast.makeText(c, "DATABASE ERROR " + databaseError.getMessage(), Toast.LENGTH_LONG).show();

                }
            });

            return events;
        }

    }

    /**********************************CUSTOM ADAPTER START************************/
    class CustomAdapter extends BaseAdapter {
        Context c;
        ArrayList<events> events;

        public CustomAdapter(Context c, ArrayList<events> events) {
            this.c = c;
            this.events = events;
        }

        @Override
        public int getCount() {

            return events.size();
        }

        @Override
        public Object getItem(int position) {
            return events.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(c).inflate(R.layout.model, parent, false);
            }

            TextView nameTextView = convertView.findViewById(R.id.nameTextView);
            TextView placeTextView = convertView.findViewById(R.id.placeTextView);
            TextView venueTextView = convertView.findViewById(R.id.venueTextView);
            TextView dateTextView = convertView.findViewById(R.id.dateTextView);
            TextView timeTextView = convertView.findViewById(R.id.timeTextView);
            TextView linkTextView = convertView.findViewById(R.id.linkTextView);
            ImageView imv = convertView.findViewById(R.id.iml);

            final events s = (events) this.getItem(position);

            nameTextView.setText(s.getName());
            placeTextView.setText(s.getPlace());
            venueTextView.setText(s.getVenue());
            dateTextView.setText(s.getDate());
            timeTextView.setText(s.getTime());
            linkTextView.setText(s.getLink());
            reslink = linkTextView.getText().toString();
            Picasso.get().load(reslink).into(imv);


            //ONITECLICK
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(c, s.geteventLink(), Toast.LENGTH_SHORT).show();
                    todownload = new Intent(collegeevents.this,tryfirebase.class);
                    todownload.putExtra("link_to_pass",s.geteventLink());
                    startActivity(todownload);
                    //Intent i = new Intent(Intent.ACTION_VIEW); i.setData(Uri.parse(s.geteventLink())); startActivity(i);
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
    String reslink;
    String event_name = "All";
    RadioGroup radioGroup;
    RadioButton r_all, r_music, r_dance, r_art, r_tech, r_fun,r_photo, r_others, r_seminars;
    RadioButton temp;
    Button apply;
    LinearLayout radio_layout;
    Intent todownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collegeevents);
        mListView = findViewById(R.id.myListView);
        r_all = findViewById(R.id.call);
        r_music = findViewById(R.id.cmusic);
        r_dance = findViewById(R.id.cdance);
        r_tech = findViewById(R.id.ctech);
        r_fun = findViewById(R.id.cfun);
        r_photo = findViewById(R.id.cphoto);
        r_art = findViewById(R.id.cart);
        r_seminars = findViewById(R.id.cseminars);
        r_others = findViewById(R.id.cothers);
        radioGroup = findViewById(R.id.radiogroup);
        apply = findViewById(R.id.applybutton);
        radio_layout = findViewById(R.id.radiolayout);
        radio_layout.setVisibility(View.VISIBLE);

        db = FirebaseDatabase.getInstance().getReference("events");
        helper = new FirebaseHelper(db, this, mListView, db);





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
    }

    public void check_checkbox(int checkedId) {

        temp = findViewById(checkedId);
       // Toast.makeText(this, "Loading events: "+temp.getText().toString(), Toast.LENGTH_SHORT).show();
        event_name = temp.getText().toString();

        mListView = findViewById(R.id.myListView);
        //initialize firebase database
        if (Objects.equals(event_name, "All")) {
            Query query = FirebaseDatabase.getInstance().getReference("events");
            helper = new FirebaseHelper(db, this, mListView, query);
        } else {
            Query query = FirebaseDatabase.getInstance().getReference("events")
                    .orderByChild("type")
                    .equalTo(event_name);
            helper = new FirebaseHelper(db, this, mListView, query);
        }


    }
}