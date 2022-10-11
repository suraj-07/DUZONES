package duzones.creativednas.com.duzones;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class fragment_webhome extends Fragment {
    CardView c_w1,c_w2,c_w3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_webhome, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        c_w1 = view.findViewById(R.id.w1);
        c_w2 = view.findViewById(R.id.w2);
        c_w3 = view.findViewById(R.id.w3);

        c_w3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent(".tryfirebase");
               // Toast.makeText(getActivity(), "kkk", Toast.LENGTH_SHORT).show();
                a.putExtra("link_to_pass","http://du.ac.in/du/");
                startActivity(a);
               // Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();

            }
        });


        c_w2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent(".tryfirebase");
               // Toast.makeText(getActivity(), "kkk", Toast.LENGTH_SHORT).show();
                a.putExtra("link_to_pass","http://admission.du.ac.in/");
                startActivity(a);
                //Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();

            }
        });


        c_w1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a= new Intent(".tryfirebase");
                //Toast.makeText(getActivity(), "kkk", Toast.LENGTH_SHORT).show();
                a.putExtra("link_to_pass","http://exam.du.ac.in/");
                startActivity(a);
                //Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();

            }
        });


    }





}





