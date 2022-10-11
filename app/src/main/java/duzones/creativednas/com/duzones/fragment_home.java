package duzones.creativednas.com.duzones;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
import com.nex3z.notificationbadge.NotificationBadge;

import java.util.Objects;
import java.util.Random;

public class fragment_home extends Fragment implements View.OnClickListener {

    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mref = database.getReference("result_url");
    public String result_url;
    AdRequest adRequest;
    private static final String APP_ID = "ca-app-pub-7180287377976427~2306652579";
    private InterstitialAd interstitialAd;
    int zrandom;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(getActivity(), "Welcome", Toast.LENGTH_SHORT).show();
        MobileAds.initialize(getContext(), APP_ID);

        AdView adview = view.findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        adview.loadAd(adRequest);


        interstitialAd = new InterstitialAd(Objects.requireNonNull(getContext()));
        interstitialAd.setAdUnitId("ca-app-pub-7180287377976427/8354499258");
        interstitialAd.loadAd(adRequest);


        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int i) {
                adRequest = new AdRequest.Builder().build();
                interstitialAd.loadAd(adRequest);
            }

            @Override
            public void onAdLeftApplication() {
                adRequest = new AdRequest.Builder().build();
                interstitialAd.loadAd(adRequest);
            }

            @Override
            public void onAdOpened() {
                adRequest = new AdRequest.Builder().build();
                interstitialAd.loadAd(adRequest);
            }

            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                adRequest = new AdRequest.Builder().build();
                interstitialAd.loadAd(adRequest);
                // Toast.makeText(getActivity(), "working", Toast.LENGTH_SHORT).show();
            }

        });


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


        CardView syllabuscard = view.findViewById(R.id.card_syllabus);
        syllabuscard.setOnClickListener(this);
        CardView paperscard = view.findViewById(R.id.card_papers);
        paperscard.setOnClickListener(this);
        CardView attendancecard = view.findViewById(R.id.card_attendance);
        attendancecard.setOnClickListener(this);
        CardView timetablecard = view.findViewById(R.id.card_timetable);
        timetablecard.setOnClickListener(this);
        CardView datesheetcard = view.findViewById(R.id.card_datesheet);
        datesheetcard.setOnClickListener(this);
        CardView collegecard = view.findViewById(R.id.card_colleges);
        collegecard.setOnClickListener(this);
        CardView cutoffcard = view.findViewById(R.id.card_cutoffs);
        cutoffcard.setOnClickListener(this);
        CardView eventscard = view.findViewById(R.id.card_events);
        eventscard.setOnClickListener(this);
        CardView resultcard = view.findViewById(R.id.card_results);
        resultcard.setOnClickListener(this);
        CardView admissioncard = view.findViewById(R.id.card_admissions);
        admissioncard.setOnClickListener(this);
        CardView noticecard = view.findViewById(R.id.card_notices);
        noticecard.setOnClickListener(this);
        CardView internshipcard = view.findViewById(R.id.card_internships);
        internshipcard.setOnClickListener(this);
        CardView internals = view.findViewById(R.id.card_internals);
        internals.setOnClickListener(this);

        CardView whome = view.findViewById(R.id.card_whome);
        whome.setOnClickListener(this);
        CardView wadmission = view.findViewById(R.id.card_wadmissions);
        wadmission.setOnClickListener(this);
        CardView wexam = view.findViewById(R.id.card_wexam);
        wexam.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.card_syllabus) {
            Intent ic = new Intent(getActivity(), Courselistforsyll.class);
            // Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
            startActivity(ic);
            if (showad() == 1)
                interstitialAd.show();
        }

        if (v.getId() == R.id.card_internships) {
            Intent ic = new Intent(getActivity(), internships.class);



            // Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
            startActivity(ic);
           if (showad() == 1)
            {
                interstitialAd.show();
            }
        }


        if (v.getId() == R.id.card_notices) {

            Intent ic = new Intent(getActivity(), notices.class);
            // Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
            startActivity(ic);

            if (showad() == 1) {
                interstitialAd.show();
            }
        }

        if (v.getId() == R.id.card_attendance) {
                Intent a1 = new Intent(".attendances");
                //Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
                startActivity(a1);
            if (showad() == 1) {
                interstitialAd.show();
            }
        }


        if (v.getId() == R.id.card_timetable) {

            Intent a1 = new Intent(".timetables");
            // Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
            startActivity(a1);

            if (showad() == 1) {
                interstitialAd.show();
            }
        }


        if (v.getId() == R.id.card_datesheet) {

            showPopUp();
        }


        if (v.getId() == R.id.card_papers) {

            Intent ic = new Intent(".Courselist");
            // Toast.makeText(getActivity(), "Will be available on next update!", Toast.LENGTH_LONG).show();
            startActivity(ic);
            if (showad() == 1) {
                interstitialAd.show();
            }
        }

        if (v.getId() == R.id.card_colleges) {

            Intent a1 = new Intent(".collegelist");
            // Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
            startActivity(a1);
            if (showad() == 1) {
                interstitialAd.show();
            }
        }

        if (v.getId() == R.id.card_cutoffs) {

            Intent a2 = new Intent(".Cutoffs");
            // Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
            startActivity(a2);
            if (showad() == 1) {
                interstitialAd.show();
            }
        }

        if (v.getId() == R.id.card_results) {

            Intent a22 = new Intent(".grade_card");
            a22.putExtra("link_to_pass", result_url);
            //   Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
            startActivity(a22);
            if (showad() == 1) {
                interstitialAd.show();
            }
        }


        if (v.getId() == R.id.card_events) {
            Intent a3 = new Intent(".collegeevents");
            //  Toast.makeText(getActivity(), "Loading...", Toast.LENGTH_SHORT).show();
            startActivity(a3);
            if (showad() == 1) {
                interstitialAd.show();
            }
        }

        if (v.getId() == R.id.card_internals) {

            Intent a3 = new Intent(".internals");
            //  Toast.makeText(getActivity(), "Loading...", Toast.LENGTH_SHORT).show();
            startActivity(a3);
            if (showad() == 1) {
                interstitialAd.show();
            }
        }

        if (v.getId() == R.id.card_admissions) {

            Intent a3 = new Intent(".Admission");
            //  Toast.makeText(getActivity(), "Loading...", Toast.LENGTH_SHORT).show();
            startActivity(a3);
            if (showad() == 1) {
                interstitialAd.show();
            }
        }


        if (v.getId() == R.id.card_whome) {




            Intent a = new Intent(".tryfirebase");
            // Toast.makeText(getActivity(), "kkk", Toast.LENGTH_SHORT).show();
            a.putExtra("link_to_pass", "http://du.ac.in/du/");
            startActivity(a);
            interstitialAd.show();
            // Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();

        }


        if (v.getId() == R.id.card_wadmissions) {

            Intent a = new Intent(".tryfirebase");
            // Toast.makeText(getActivity(), "kkk", Toast.LENGTH_SHORT).show();
            a.putExtra("link_to_pass", "http://admission.du.ac.in/");
            startActivity(a);
            //Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
            interstitialAd.show();
        }


        if (v.getId() == R.id.card_wexam) {

            Intent a = new Intent(".tryfirebase");
            //Toast.makeText(getActivity(), "kkk", Toast.LENGTH_SHORT).show();
            a.putExtra("link_to_pass", "http://exam.du.ac.in/");
            startActivity(a);
            //Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
            interstitialAd.show();

        }
    }

    public void showPopUp() {
        View inflate = ((LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.custompopup, null);
        final AlertDialog create = new AlertDialog.Builder(getContext()).create();
        create.setView(inflate);
        TextView textView = (TextView) inflate.findViewById(R.id.close);
        CardView cardView = (CardView) inflate.findViewById(R.id.datesheet1);
        CardView cardView2 = (CardView) inflate.findViewById(R.id.datesheet2);
        create.show();
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create.dismiss();
            }
        });
        cardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent a = new Intent(getActivity(), Datesheets1.class);
                startActivity(a);

                create.dismiss();
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent a = new Intent(getActivity(), Datesheets2.class);
                startActivity(a);

                create.dismiss();
            }
        });
    }

    public int showad() {
        zrandom = new Random().nextInt(10) + 2;
        if (zrandom == 1 || zrandom == 10) {
            return 1;
        } else if (zrandom > 4 && zrandom % 2 == 0)
            return 1;

        else return 0;
    }

}
