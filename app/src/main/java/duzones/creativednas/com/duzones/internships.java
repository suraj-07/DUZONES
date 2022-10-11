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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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

public class internships extends AppCompatActivity {
    public class FirebaseHelper {

        DatabaseReference db;
        ArrayList<interns> interns = new ArrayList<>();
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
        public ArrayList<interns> retrieve() {
            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    interns.clear();
                    if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            //Now get interns Objects and populate our arraylist.
                            interns interns = ds.getValue(interns.class);
                            FirebaseHelper.this.interns.add(interns);
                        }
                        adapter = new CustomAdapter(c, interns);
                        mListView.setAdapter(adapter);

                        new Handler().post(new Runnable() {
                            @Override
                            public void run() {
                                mListView.smoothScrollToPosition(interns.size());
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

            return interns;
        }

    }

    /**********************************CUSTOM ADAPTER START************************/
    class CustomAdapter extends BaseAdapter {
        Context c;
        ArrayList<interns> interns;

        public CustomAdapter(Context c, ArrayList<interns> interns) {
            this.c = c;
            this.interns = interns;
        }

        @Override
        public int getCount() {
            return interns.size();
        }

        @Override
        public Object getItem(int position) {
            return interns.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(c).inflate(R.layout.modelintern, parent, false);
            }

            TextView nameTextView = convertView.findViewById(R.id.nameTextView);
            TextView placeTextView = convertView.findViewById(R.id.placeTextView);
            TextView linkTextView = convertView.findViewById(R.id.linkTextView);
           // TextView joblinkTextView = convertView.findViewById(R.id.linkTextView);
            ImageView imv = convertView.findViewById(R.id.iml);

            final interns s = (interns) this.getItem(position);

            nameTextView.setText(s.getName());
            placeTextView.setText(s.getPlace());
           // linkTextView.setText(s.getLink());
           // reslink = linkTextView.getText().toString();
            Picasso.get().load(s.getLink()).into(imv);


            //ONITECLICK
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(c, s.getName(), Toast.LENGTH_SHORT).show();
                    todownload = new Intent(internships.this,tryfirebase.class);
                    todownload.putExtra("link_to_pass",s.getjobLink());
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
    String reslink;
    Intent todownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internships);
        mListView = findViewById(R.id.myListView);


        db = FirebaseDatabase.getInstance().getReference("interns");
        helper = new FirebaseHelper(db, this, mListView, db);




    }


}