package duzones.creativednas.com.duzones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admission extends AppCompatActivity {

    Button b_admission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission);
        b_admission = findViewById(R.id.button_admission);
        b_admission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(".tryfirebase");
                // Toast.makeText(getActivity(), "kkk", Toast.LENGTH_SHORT).show();
                a.putExtra("link_to_pass", "http://admission.du.ac.in/");
                startActivity(a);
                //Toast.makeText(getActivity(), "done", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
