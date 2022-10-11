package duzones.creativednas.com.duzones;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class fragment_bcom extends Fragment {


    public class FirebaseHelper {

        DatabaseReference db;
        ArrayList<fragment_bsc_class> fragment_bsc_class = new ArrayList<>();
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

        public ArrayList<fragment_bsc_class> retrieve() {
            db.child("Courses_Bcom").orderByChild("name").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    fragment_bsc_class.clear();
                    if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            //Now get fragment_bsc_class Objects and populate our arraylist.
                            fragment_bsc_class fragment_bsc_class = ds.getValue(fragment_bsc_class.class);
                            FirebaseHelper.this.fragment_bsc_class.add(fragment_bsc_class);
                        }
                        adapter = new CustomAdapter(c, fragment_bsc_class);
                        mListView.setAdapter(adapter);

                        new Handler().post(new Runnable() {
                            @Override
                            public void run() {
                                mListView.smoothScrollToPosition(fragment_bsc_class.size());
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

            return fragment_bsc_class;
        }

    }

    /**********************************CUSTOM ADAPTER START************************/
    class CustomAdapter extends BaseAdapter {
        Context c;
        ArrayList<fragment_bsc_class> fragment_bsc_class;

        public CustomAdapter(Context c, ArrayList<fragment_bsc_class> fragment_bsc_class) {
            this.c = c;
            this.fragment_bsc_class = fragment_bsc_class;
        }

        @Override
        public int getCount() {
            return fragment_bsc_class.size();
        }

        @Override
        public Object getItem(int position) {
            return fragment_bsc_class.get(position);
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



            final fragment_bsc_class s = (fragment_bsc_class) this.getItem(position);

            cutoffTextView.setText(s.getName());



            //ONITECLICK
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(c, s.getName(), Toast.LENGTH_SHORT).show();
                    Intent a= new Intent(getActivity(),semesters.class);
                    a.putExtra("pass",s.getName());
                    startActivity(a);
                }
            });
            return convertView;
        }
    }


    DatabaseReference db;
    FirebaseHelper helper;
    CustomAdapter adapter;
    ListView mListView;
    View v;
    public fragment_bcom() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.bsc_fragment,container,false);






/*
        final String[] secondsemcs = {"B.Sc(Hons)Statistics" ,
                "B.Sc (Hons)Anthropology" ,
                "B.Sc (Hons)Bio-Chemistry" ,
                "B.Sc(Hons)Biological Sciences" ,
                "B.Sc(Hons)Biomedical Science" ,
                "B.Sc(Hons)Botany" ,
                "B.Sc(Hons)Chemistry" ,
                "B.Sc(Hons)Computer Science" ,
                "B.Sc(Hons)Electronics" ,
                "B.Sc(Hons)Food Technology" ,
                "B.Sc(Hons)Geology" ,
                "B.Sc(Hons.)Home Science" ,
                "B.Sc (Hons)Instrumentation" ,
                "B.Sc (Hons)Mathematics" ,
                "B.Sc (Hons)Microbiology" ,
                "B.Sc(Hons)Physics" ,
                "B.Sc(Hons)Polymer Science" ,
                "B.Sc(Hons)Zoology"
                };
        final ListView listView = v.findViewById(R.id.list1);
        ArrayAdapter<String> listviewAdapter2 = new ArrayAdapter<>(
                Objects.requireNonNull(getActivity()),
                R.layout.rowlist, R.id.txtitem, secondsemcs
        );
        listView.setAdapter(listviewAdapter2);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(getActivity(),"long click working", Toast.LENGTH_SHORT).show();
                return false;
            }
        });



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), secondsemcs[position], Toast.LENGTH_SHORT).show();

                    Intent a = new Intent(".Bsc_semesterlist");
                    a.putExtra("coursenametopass",secondsemcs[position]);
                    startActivity(a);

            }
        });
         */
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mListView = view.findViewById(R.id.list1);
        //initialize firebase database
        db = FirebaseDatabase.getInstance().getReference();
        helper = new FirebaseHelper(db, getContext(), mListView);
 }

    }
