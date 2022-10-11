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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class timetables extends AppCompatActivity {
    /**********************************FIREBASE HELPER START************************/
    public class FirebaseHelper {

        DatabaseReference db;
        ArrayList<cutoffclass> cutoffclass = new ArrayList<>();
        ListView mListView;
        Context c;

        /*
       let's receive a reference to our FirebaseDatabase
       */
        public FirebaseHelper(DatabaseReference db, Context context, ListView mListView) {
            this.db = db;
            this.c = context;
            this.mListView = mListView;
            this.retrieve();
        }




        /*
        Retrieve and Return them clean data in an arraylist so that they just bind it to ListView.
         */
        public ArrayList<cutoffclass> retrieve() {
            db.child("timetable").orderByChild("name").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    cutoffclass.clear();
                    if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            //Now get cutoffclass Objects and populate our arraylist.
                            cutoffclass cutoffclass = ds.getValue(cutoffclass.class);
                            FirebaseHelper.this.cutoffclass.add(cutoffclass);
                        }
                        adapter = new CustomAdapter(c, cutoffclass);
                        mListView.setAdapter(adapter);

                        new Handler().post(new Runnable() {
                            @Override
                            public void run() {
                                mListView.smoothScrollToPosition(cutoffclass.size());
                            }
                        });
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.d("mTAG", databaseError.getMessage());
                    Toast.makeText(c, "ERROR " + databaseError.getMessage(), Toast.LENGTH_LONG).show();

                }
            });

            return cutoffclass;
        }

    }

    /**********************************CUSTOM ADAPTER START************************/
    class CustomAdapter extends BaseAdapter {
        Context c;
        ArrayList<cutoffclass> cutoffclass;

        public CustomAdapter(Context c, ArrayList<cutoffclass> cutoffclass) {
            this.c = c;
            this.cutoffclass = cutoffclass;
        }

        @Override
        public int getCount() {
            return cutoffclass.size();
        }

        @Override
        public Object getItem(int position) {
            return cutoffclass.get(position);
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



            final cutoffclass s = (cutoffclass) this.getItem(position);

           cutoffTextView.setText(s.getName());

            final String r = s.getLink();


            //ONITECLICK
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(c, s.getName(), Toast.LENGTH_SHORT).show();
                    Intent a= new Intent(timetables.this,tryfirebase.class);
                            a.putExtra("link_to_pass",r);
                            startActivity(a);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutoffs);

        mListView = findViewById(R.id.cv);
        //initialize firebase database
        db = FirebaseDatabase.getInstance().getReference();
        helper = new FirebaseHelper(db, this, mListView);
    }

}



