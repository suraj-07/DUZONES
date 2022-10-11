package duzones.creativednas.com.duzones;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class fragment_collegehome extends Fragment implements View.OnClickListener {

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mref = database.getReference("result_url");
    public String result_url;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_collegehome, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Toast.makeText(getActivity(), "opened", Toast.LENGTH_SHORT).show();

        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                result_url = dataSnapshot.getValue().toString();
                 // Toast.makeText(getActivity(), result_url, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Database Error", Toast.LENGTH_SHORT).show();
            }
        });



        CardView collegecard = view.findViewById(R.id.card_college);
        collegecard.setOnClickListener(this);

        CardView cutoffcard = view.findViewById(R.id.card_cutoff);
        cutoffcard.setOnClickListener(this);

        CardView eventscard = view.findViewById(R.id.card_events);
        eventscard.setOnClickListener(this);

        CardView resultcard = view.findViewById(R.id.card_result);
        resultcard.setOnClickListener(this);

        CardView admissioncard = view.findViewById(R.id.card_admission);
        admissioncard.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.card_college) {
            Intent a1 = new Intent(".collegelist");
           // Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
            startActivity(a1);

        }

        if (v.getId() == R.id.card_cutoff) {
            Intent a2 = new Intent(".Cutoffs");
           // Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
            startActivity(a2);
        }

        if (v.getId() == R.id.card_result) {
            Intent a22 = new Intent(".grade_card");
            a22.putExtra("link_to_pass",result_url);
         //   Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
            startActivity(a22);
        }


        if (v.getId() == R.id.card_events) {
            Intent a3 = new Intent(".collegeevents");
          //  Toast.makeText(getActivity(), "Loading...", Toast.LENGTH_SHORT).show();
            startActivity(a3);
        }

        if (v.getId() == R.id.card_admission) {
            Intent a3 = new Intent(".Admission");
          //  Toast.makeText(getActivity(), "Loading...", Toast.LENGTH_SHORT).show();
            startActivity(a3);
        }

    }
}

