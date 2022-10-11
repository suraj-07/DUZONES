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

public class fragment_baforsyll extends Fragment {
    View v;
    String[] secondsemcs = {"B.A (Hons)Applied Psychology",
            "B.A(Hons)Arabic" ,
            "B.A(Hons)Bengali" ,
            "B.A (Hons)Economics" ,
            "B.A(Hons)English" ,
            "B.A(Hons)French" ,
            "B.A (Hons)Geography" ,
            "B.A(Hons)German" ,
            "B.A(Hons)Hindi" ,
            //"B.A(Hons)Hindi Patrikarita" ,
            "B.A(Hons)History",
            "B.A(Hons)Italian" ,
            "B.A(Hons)Journalism",
            "B.A(Hons)Persian" ,
            "B.A (Hons)Philosophy",
            "B.A(Hons)Political Science" ,
            "B.A (Hons)Psychology" ,
            "B.A(Hons)Punjabi",
            "B.A(Hons)Sanskrit" ,
            "B.A(Hons)Social Work" ,
            "B.A (Hons)Sociology",
            "B.A (Hons)Spanish" ,
            "B.A(Hons)Urdu" ,
            };


    String[] courselink = {"https://drive.google.com/open?id=1jONduQeRFOzMKFPLE-x0_DKknE_1hy6p",
            "https://drive.google.com/open?id=1T3gzcLdHsQQnsPkOAcvwzpvyzs1DCkef" ,
            "https://drive.google.com/open?id=1ASrJbOzzfw92sNQyfYwKpzMwwzIG4nZz" ,
            "https://drive.google.com/open?id=1SnLuEmQnAIJdlX3Mqcz-k4n_1HYtntoC" ,
            "https://drive.google.com/open?id=1-xTQ_Ht3EvxUnL1hIJ5aqvi0dlvqKNkI" ,
            "https://drive.google.com/open?id=1axAgDGZx6deNSXTOJXJtqGfr65-LcLNQ" ,
            "https://drive.google.com/open?id=1rIUIMpTgmYWhroUpk-4l1asPrR5qlUGU" ,
            "https://drive.google.com/open?id=1-NYtZtDP7kr0-33WAo58_mV13NoItuv7" ,
            "https://drive.google.com/open?id=14Xh3Q1PS7tN6s31igmQD7ala73vlUMG_" ,
            //"B.A(Hons)Hindi Patrikarita" ,
            "https://drive.google.com/open?id=1Ar_IRUoRq4lBReTwrt6d-nrcDPQueWiY",
            "https://drive.google.com/open?id=1GI0hn9bYc3fxJyijHmsnLVcHLHgyH5R_" ,
            "https://drive.google.com/open?id=1mCfqfNwNvENkdIvo_HNqEJso1VPyL-FY",
            "https://drive.google.com/open?id=11ZT4_pU3ZXLeoEOMi06FrWr_1TrXpCiQ" ,
            "https://drive.google.com/open?id=1kxqyE8g9asD-O0oPs1JY2VQNfLfxyEgJ",
            "https://drive.google.com/open?id=1LRwGaOfyAlRpzOa9xe7eJx55QQD7qmyK" ,
            "https://drive.google.com/open?id=1GmebPJE6qlDsAEf7_NuOzuzlZpOFmC0-" ,
            "https://drive.google.com/open?id=16HY9so8zY3WCzXrvoOb-pQq-mI4KBqAN",
            "https://drive.google.com/open?id=1Wp_DsFqm_OjWhlbwYGaFjsvxOExcZ9hv" ,
            "https://drive.google.com/open?id=1YSGBUSO2FqIy-pwrkk2vsVccvMlexTgt" ,
            "https://drive.google.com/open?id=12GFFPFCL9gpSoME_r9n_v-3sTAVMS_ws",
            "https://drive.google.com/open?id=191WjNju-0-IS5A4BUScJ3OHBMK2d2Hyz" ,
            "https://drive.google.com/open?id=1wZoWc55gYe1wIHbQTf1LdIBJzWbW1E-h" ,
            };


    public fragment_baforsyll() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.bsc_fragment,container,false);

        ListView listView = (ListView) v.findViewById(R.id.list1);
        ArrayAdapter<String> listviewAdapter2 = new ArrayAdapter<String>(
                getActivity(),
                R.layout.rowlist,R.id.txtitem, secondsemcs
        );
        listView.setAdapter(listviewAdapter2);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(getActivity(), secondsemcs[position], Toast.LENGTH_SHORT).show();
                Intent a= new Intent(".tryfirebase");
                a.putExtra("link_to_pass",courselink[position]);
                startActivity(a);

             }
        });
        return v;
    }
}