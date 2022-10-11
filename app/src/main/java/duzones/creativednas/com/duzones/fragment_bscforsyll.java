package duzones.creativednas.com.duzones;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Objects;

public class fragment_bscforsyll extends Fragment {
    View v;
    public fragment_bscforsyll() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.bsc_fragment,container,false);
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
                "B.Sc(Hons)Zoology" ,
                "B.Sc.(Pass)Home Science" ,
               };


        final String[] courselink = {"https://drive.google.com/open?id=1xEAakvk3MifOMqyDDcoheJ5uOPgBzyaU" ,
                "https://drive.google.com/open?id=17CkQFfbWNXKzbolCZNImz8cgb-jrGP5v" ,
                "https://drive.google.com/open?id=1e5OQPezlKlyDBMp2TAnFDDRw34Im5mrO" ,
                "https://drive.google.com/open?id=1j45dstJ1IS-r6iJyK8V8KYgPpz3LVp2Z" ,
                "https://drive.google.com/open?id=1IGYIs-GHMa3Tgx3r6119a9XbPNOuXs9R" ,
                "https://drive.google.com/open?id=1YE1_4FVUcWjuhVv17mPVIbi-Io-uCjmS" ,
                "https://drive.google.com/open?id=1kZnWWZR_QcdhmZZX9dtYQcgLzIiYJ55O" ,
                "https://drive.google.com/open?id=19011uPcEuX8JTof623IJaCfqIQJys0GU" ,
                "https://drive.google.com/open?id=1CDw93QW-5MF_muIvINU71SbHaBYBMVW8" ,
                "https://drive.google.com/open?id=1meReDTKc5ca5L5MNfMQ-ZxMewq0wUoYE" ,
                "https://drive.google.com/open?id=16FRb2WfvH0X-xw1kmjRknP94xOO7MANS" ,
                "https://drive.google.com/open?id=1nRr75E4VJ7W3vn35_Jz_TkcvZ5epo7ot" ,
                "https://drive.google.com/open?id=1SVBzEKPAtj_jv8-ztK03FpsfZuispdj2" ,
                "https://drive.google.com/open?id=1ITVGiPGRYKkDVv9Zn8VOgzIXm7mGTYvj" ,
                "https://drive.google.com/open?id=1G6u2CVb-Glc3kJUxa5n6uTt7dY7SnNI5" ,
                "https://drive.google.com/open?id=1j-xbwFLAcDi-Ki_d5wgfyzNs7gBItbGl" ,
                "https://drive.google.com/open?id=1mX9-uPaMbeA07pXckz5JqTopNTii0Ve9" ,
                "https://drive.google.com/open?id=1or33tnkZBqf_8ofFR75TguYAu6_vMGGJ" ,
                "https://drive.google.com/open?id=1nRr75E4VJ7W3vn35_Jz_TkcvZ5epo7ot" ,
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
                Toast.makeText(getActivity(),"long click working", Toast.LENGTH_SHORT).show();
                return false;
            }
        });



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), secondsemcs[position], Toast.LENGTH_SHORT).show();

               // Toast.makeText(getActivity(), secondsemcs[position], Toast.LENGTH_SHORT).show();
                Intent a= new Intent(".tryfirebase");
                a.putExtra("link_to_pass",courselink[position]);
                startActivity(a);
            }
        });
        return v;
    }
}
