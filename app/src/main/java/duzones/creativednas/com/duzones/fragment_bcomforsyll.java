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

public class fragment_bcomforsyll extends Fragment {
    View v;
    String[] courselink = {"https://drive.google.com/open?id=1jhrfnHSrIp-0FpRi2ojh8yWzMyWaXIwu",
            "https://drive.google.com/open?id=1dbA2Vsw2S1j03C3YXJMbt647NKfR92-B"};


    String[] secondsemcs = {"B.Com",
            "B.Com(Hons.)"};

    public fragment_bcomforsyll() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.bsc_fragment,container,false);

        ListView listView = v.findViewById(R.id.list1);
        ArrayAdapter<String> listviewAdapter2 = new ArrayAdapter<String>(
                getActivity(),
                R.layout.rowlist,R.id.txtitem, secondsemcs
        );
        listView.setAdapter(listviewAdapter2);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(getActivity(), secondsemcs[position], Toast.LENGTH_SHORT).show();
                Intent a= new Intent(".tryfirebase");
                a.putExtra("link_to_pass",courselink[position]);
                startActivity(a);
            }
        });
        return v;
    }
}

