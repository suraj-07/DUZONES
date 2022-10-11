package duzones.creativednas.com.duzones;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class timetablelist extends AppCompatActivity {

    String  tempcrname;

    String[] collnames = {
            "Acharya Narendra Dev College\n" +
                    "Not Available",
            "Aditi Mahavidyalaya",
            "Aryabhatta College",
            "Atma Ram Sanatan Dharma College",
            "Bhagini Nivedita College",
            "Bharati College",
            "Bhaskaracharya College Of Applied Sciences",
            "College Of Arts\n" +
                    "Not Available",
            "College of Vocational Studies\n" +
                    "Not Available",
            "Daulat Ram College",
            "Dayal Singh College",
            "Dayal Singh College(evening)",
            "Deen Dayal Upadhyaya College",
            "Delhi College Of Arts & Commerce",
            "Deshbandhu College",
            "Dr. Bhim Rao Ambedkar College",
            "Gargi College",
            "Hansraj College",
            "Hindu College",
            "Indira Gandhi Institute of Physical Education and Sports Sciences",
            "Indraprastha College for women",
            "Insitute Of Home Economics",
            "Janki Devi Memorial College",
            "Jesus and Mary College",
            "Kalindi College\n" +
                    "Not Available",
            "Kamala Nehru College",
            "Keshav Mahavidyalaya College",
            "Kirori Mal College",
            "Lady Irwin College",
            "Lady Shri Ram College for women",
            "Lakshimbai College",
            "Maharaja Agrasena College",
            "Maharishi Valmiki College of Education",
            "Maitreyi College",
            "Mata Sundri College for Women",
            "Miranda House",
            "Motilal Nehru College\n" +
                    "Not Available",
            "Motilal Nehru College(evening)\n" +
                    "Not Available",
            "P.G.D.A.V\n" +
                    "Not Available",
            "P.G.D.A.V College(evening)\n" +
                    "Not Available",
            "Rajdhani College",
            "Ram Lal Ananda College",
            "Ramanujan College",
            "Ramjas College",
            "Satyawati College",
            "Satyawati College(evening)",
            "Shaheed Bhagat Singh College\n" +
                    "Not Available",
            "Shahhed Bhagat Singh College(evening)",
            "Shaheed Rajguru College Of Applied Sciences",
            "Shaheed Sukhdev College Of Business Studies",
            "Shivaji College",
            "Shri Ram College Of Commerce",
            "Shyama Lal College\n" +
                    "Not Available",
            "Shyama Lal College(evening)\n" +
                    "Not Available",
            "Sri Aurobindo College",
            "Sri Aurobindo College(evening)",
            "Sri Guru Gobind Singh College Of Commerce",
            "Sri Guru Nanak Dev Khalsa College",
            "Sri Guru Teg Bahadur Khasa College",
            "Sri Venkateswara College",
            "St. Stephen's College",
            "Swami Shraddhanada College",
            "Vivekananda College",
            "Zakir Hussain Delhi College",
            "Zakir Hussain Delhi College(evening)"};


    String[] collink = {
           "https://drive.google.com/open?id=1uHHGtsyN6rzWyjQWDQPd-vgsoKhDYQjH",
            "http://aditi.du.ac.in/faculty/getcoursetimetable",
            "http://aryabhattacollege.ac.in/pages/timetable2017.php",
            "http://www.arsdcollege.in/Internet/Index.aspx",
        "http://www.bhagininiveditacollege.in/",
            "https://www.bharaticollege.org/time-table/",
         "https://docs.google.com/spreadsheets/d/e/2PACX-1vRItqARWI14f0Ft7HevBUqdEFpRkgJp50WY1pSjPJfUKHMM1ltBaN32PGdGHoChe0TSfxsdPF3uHQWP/pubhtml",
        "https://drive.google.com/open?id=1uHHGtsyN6rzWyjQWDQPd-vgsoKhDYQjH",
            "https://drive.google.com/open?id=1uHHGtsyN6rzWyjQWDQPd-vgsoKhDYQjH",
            "http://dr.du.ac.in/timetable.php",
            "http://dsc.collegetimetable.in/",
            "http://dsce.du.ac.in/index.php/timetable/",
            "https://dducollegedu.ac.in/ViewpagePAnel.aspx?MenuId=bldVsWPLXo1ZvXqf15Rwog==",
            "http://dcac.du.ac.in/Pages/Academics/timetable.php",
            "https://www.deshbandhucollege.ac.in/time-table.php",
            "http://www.drbrambedkarcollege.ac.in/time-table",
            "https://gargicollege.in/timetable/",
            "https://www.hansrajcollege.ac.in/time-table.php",
            "http://hinducollegetimetable.in/",
            "http://igipess1.du.ac.in:8080/web/t_table.jsp",
            "http://www.ipcollege.ac.in/Viewtopics.aspx?MenuId=Time_Table_389",
            "http://www.ihe-du.com/index.php?option=com_content&view=article&id=117&Itemid=101",
            "http://jdm.du.ac.in/time_table.html",
            "http://www.jmc.ac.in/academics/time-table/",
          "https://drive.google.com/open?id=1uHHGtsyN6rzWyjQWDQPd-vgsoKhDYQjH",
            "https://www.knc.edu.in/economicssem.php",
            "http://keshav.du.ac.in/College?PageID=6&SubID=37",
            "http://www.kmcollege.ac.in/timetable.jsp",
            "http://www.ladyirwin.edu.in/time_table.aspx",
            "http://lsr.edu.in/timetable.asp",
            "https://timetable.lakshmibaicollege.in/",
            "http://mac.du.ac.in/time_table.php",
            "http://www.mvce.ac.in/timetable-2018-19.php",
            "http://maitreyi.ac.in/topics.aspx?mid=Coursewise%20Time%20Table",
           "http://www.ms.du.ac.in/Department_TT.aspx",
            "http://mirandahouse.ac.in/course-wise.phpf",
         "https://drive.google.com/open?id=1uHHGtsyN6rzWyjQWDQPd-vgsoKhDYQjH",
         "https://drive.google.com/open?id=1uHHGtsyN6rzWyjQWDQPd-vgsoKhDYQjH",
          "https://drive.google.com/open?id=1uHHGtsyN6rzWyjQWDQPd-vgsoKhDYQjH",
            "https://drive.google.com/open?id=1uHHGtsyN6rzWyjQWDQPd-vgsoKhDYQjH",
            "http://rajdhanicollege.ac.in/",
            "https://rlacollege.edu.in/time-table.php",
            "http://rcdu.in/",
            "http://ramjas.du.ac.in/info_in_detail.php?id=137",
            "http://satyawati.du.ac.in/INDEX/TIMETABLE/MASTER.pdf",
            "http://satyawatievedu.ac.in/DataFile/OptionMenu/497.pdf",
           "https://drive.google.com/open?id=1uHHGtsyN6rzWyjQWDQPd-vgsoKhDYQjH",
            "http://sbsec.org/pdf/19a39ad124e87a8487555db718bd2432.pdf",
            "http://www.rajgurucollege.com/time-table-2.aspx",
            "http://sscbsdu.ac.in/index.php/90-news/656-timetable-jan-april-2019",
            "http://shivajicollegetimetable.in/",
            "http://www.srcc.edu/academics/time-table/room-wise-time-table",
            "https://drive.google.com/open?id=1uHHGtsyN6rzWyjQWDQPd-vgsoKhDYQjH",
            "https://drive.google.com/open?id=1uHHGtsyN6rzWyjQWDQPd-vgsoKhDYQjH",
            "http://www.aurobindo.du.ac.in/time-table.php",
            "https://www.saceve.in/time-table1819.pdf",
            "http://www.sggscc.ac.in/stt.jsp",
            "https://www.sgndkc.org/sk/page.php?action=studentwise&page=time%20table",
            "http://www.sgtbkhalsadu.ac.in/tt.jsp",
            "http://www.svc.ac.in/ttable/ttable.asp ",
            "https://www.ststephens.edu/timetable/",
            "http://ss.du.ac.in/timetable.php",
            "http://vivekanandacollege.edu.in/time-tablesof-all-departments/",
            "http://zhdcstudent.in/Internet/Index.aspx",
            "http://www.zakirhusainpgeve.in/ttable/blank.php?"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetablelist);


        final ListView listView = findViewById(R.id.lv);
        customadapter2 cs = new customadapter2();
        listView.setAdapter(cs);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                positionsetter(position);
            }
        });
    }


    class customadapter2 extends BaseAdapter {

        @Override
        public int getCount() {
            return collnames.length;
        }


        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.listviewtimetable, null);
            TextView t1 = convertView.findViewById(R.id.colname);
            t1.setText(collnames[position]);
            return convertView;


        }
    }


    public void positionsetter(int position) {
        tempcrname = collink[position];
        Intent a= new Intent(timetablelist.this,tryfirebase.class);
        a.putExtra("link_to_pass",tempcrname);
        startActivity(a);
        //Toast.makeText(timetablelist.this, tempcrname, Toast.LENGTH_SHORT).show();

    }

}
