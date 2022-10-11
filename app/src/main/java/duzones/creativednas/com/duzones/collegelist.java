package duzones.creativednas.com.duzones;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class collegelist extends AppCompatActivity {

    String tempcname, tempcrname, tempcolmapname, tempcoursedetailed, tempcollink, tempbroname;
    int tempcolimage;
    Intent i;

    String[] collnames = {
            "Acharya Narendra Dev College",
            "Aditi Mahavidyalaya",
            "Aryabhatta College",
            "Atma Ram Sanatan Dharma College",
            "Bhagini Nivedita College",
            "Bharati College",
            "Bhaskaracharya College Of Applied Sciences",
            "College Of Arts",
            "College of Vocational Studies",
            "Daulat Ram College",
            "Dyal Singh College",
            "Dyal Singh College(evening)",
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
            "Kalindi College",
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
            "Motilal Nehru College",
            "Motilal Nehru College(evening)",
            "P.G.D.A.V",
            "P.G.D.A.V College(evening)",
            "Rajdhani College",
            "Ram Lal Ananda College",
            "Ramanujan College",
            "Ramjas College",
            "Satyawati College",
            "Satyawati College(evening)",
            "Shaheed Bhagat Singh College",
            "Shahhed Bhagat Singh College(evening)",
            "Shaheed Rajguru College Of Applied Sciences",
            "Shaheed Sukhdev College Of Business Studies",
            "Shivaji College",
            "Shri Ram College Of Commerce",
            "Shyama Lal College",
            "Shyama Lal College(evening)",
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






    String[] broch = {
            "https://drive.google.com/open?id=11NU1p3DobT1JwAHYpA6BgFrZNnvxVs-z",
            "https://drive.google.com/open?id=1JsLEwmnJUrj4OraoEwv3vom_tV-gyJnX",
            "https://drive.google.com/open?id=1CFCkaahm-gcI6m5kMJKyuPRx82fFfqZ0",
            "https://drive.google.com/open?id=1wBq2HgLrTPOiSiEwkH-n2w564ZljtLU1",
            "https://drive.google.com/open?id=1Ng2R9v3bAhE4lyrFH8aYjV9-BEc0-gGa",
            "https://drive.google.com/open?id=15CjoDgK2Pz4BcKW8z7EKKYJAC-D4CSQv",
            "https://drive.google.com/open?id=1EQeHUAbHHV__EejbfBPmhwC9rG_QkzRp",
            "https://drive.google.com/open?id=1qLSYfmxPExW5d3-i1HsAHLEmixJSztsW",
            "https://drive.google.com/open?id=16DfIo5nS2F8G3KEUtsXxImruln9TLYGN",
            "https://drive.google.com/open?id=1m-t6u-Lv-mSQd4cCkatboT-0FKgJ7nB_",
            "https://drive.google.com/open?id=1opW4bmqVH1nQFFMnBZRrJoXOnumMNXjo",
            "https://drive.google.com/open?id=1NvptydgQhzuBnqRxM59hwd1eni1KCZih",
            "https://drive.google.com/open?id=1uI4TQK2jgw-tlc86U2Hb2IWl9OMtNz10",
            "https://drive.google.com/open?id=1n7fqGL5D3-tXW8Ar5bNpsKJEiGCLgf9b",
            "https://drive.google.com/open?id=1iVvP7mbiwRmNkuimyFp3mTLxQnxAgm9i",
            "https://drive.google.com/open?id=1lYAYymKXfpe5izmw2mXch4ih8m28kXxR",
            "https://drive.google.com/open?id=106RFvx0i99siznzvc-Cvf7aY0TSd-5FM",
            "https://drive.google.com/open?id=1sBLW1ezVZaTbFWaw_oBhAFg4v3MgUoBj",
            "https://drive.google.com/open?id=1GS_gDvd3j9Av87yllDAPmCOxJ-iYiwCe",
            "https://drive.google.com/open?id=1F7HrwJY6MpNVgiFgCBIN91xarS4VX2sM",
            "https://drive.google.com/open?id=1z7dZVW1F0VoZn6mm8iBirc9TuMdR1Ved",
            "https://drive.google.com/open?id=1qKI8ZiouYYay1ThU1WN-4GvrzZZuXX06",
            "https://drive.google.com/open?id=1AlKrIwnDYWyEHRuhyc24mfGav1ehP6UL",
            "https://drive.google.com/open?id=1TaciXe3TF10JWuJOrt-U89IVmh2gUfyc",
            "https://drive.google.com/open?id=1evu1n5JnLvM0MHqntaK_WbaIS3U52Sgs",
            "https://drive.google.com/open?id=1YDiSItrWRImW7tkFEbwFmPA7IpRDMjLm",
            "https://drive.google.com/open?id=1yQX4QdDHS46xS3nxoABxAQj4uRbqhJ-M",
            "https://drive.google.com/open?id=1O4DTEUh8g8_BGQNO-3VII1TxdQoF7n2S",
            "https://drive.google.com/open?id=16pl4dAh_zZkxw1kMKyzMSPcmQcY-kxpS",
            "https://drive.google.com/open?id=1ELSjh18bSv90dULND2If0C3PD9xEXRM7",
            "https://drive.google.com/open?id=1vBXGQHZG-2TcqDcFIu3ejzhPGuQ-ddfQ",
            "https://drive.google.com/open?id=1F0qW4irH2St1Z7_UjJpqyXWm9ACOM0HB",
            "https://drive.google.com/open?id=1qSFBpjSE4ApSXZUOZbq_31Wxxgvyqxsw",
            "https://drive.google.com/open?id=1MdqojvF9bM7TbA4CMHDU38jzbV_6AqhP",
            "https://drive.google.com/open?id=1zIatYDFxaiEIZaYjKxFHAt1OqsPVRqad",
            "https://drive.google.com/open?id=1rjZ86vxEXBcWGnJ5W1iTesbRJUFEOtfl",
            "https://drive.google.com/open?id=1wpfnBJYCnxlt2zrMXyIrBoesV3qlQLLS",
            "https://drive.google.com/open?id=1EsheJtNBNDPhbtNAMTPpu5qZDIMpeTb8",
            "https://drive.google.com/open?id=1GE1qVrXzuAJHmlTYN7tJwKJVMGMZ6VX_",
            "https://drive.google.com/open?id=1kvwuXIeBpb_yN_J26PEkq1BTqEZjigcL",
            "https://drive.google.com/open?id=19hzPvrB5u6EW-EYV7x9cVIkYyFPOuPmp",
            "https://drive.google.com/open?id=1y85klTAabE_FYQ82Thf070iJe9qzGiXy",
            "https://drive.google.com/open?id=1Stmpp9GudkZrgxYHNi98k4H_syFDXQoy",
            "https://drive.google.com/open?id=1oZHzFir_nKO2Mj613Vq594jMg8BAfmB9",
            "https://drive.google.com/open?id=1jl4lKsXuX9luUigmxSzm-vYeaAUEYAIy",
            "https://drive.google.com/open?id=1DUmvdvrT-Tn0o-h-2NOKOs-2erH6w0KY",
            "https://drive.google.com/open?id=1bw3XLCzEW1rAvvbAgK1mOn1STrghYW3d",
            "https://drive.google.com/open?id=13jWhrQAIeKUaJAWA5Z_F02_-6J1DU_dU",
            "https://drive.google.com/open?id=1a4eAiPOoIucDd0crPExc3oiHuWz33LI1",
            "https://drive.google.com/open?id=1WnGenTs28IW5xdMcrlXmr6O2K6ttIQMA",
            "https://drive.google.com/open?id=1UIdnTart_x008hh002DPRxqku5K0d9gj",
            "https://drive.google.com/open?id=1VmdP-WiNvGF5q3BqLAWBFotQoERu0HwL",
            /*na*/"https://drive.google.com/open?id=1dqQ30lB7Vf9BBLTl07a7ElWc5L3CD_IQ",
            "https://drive.google.com/open?id=13KVxU173MG0j3qXU1p0S3LmzKn457LP0",
            "https://drive.google.com/open?id=171tWE_RTlTZz1YmgtaoctxMdwMI17LMx",
            "https://drive.google.com/open?id=1KQErrZRVrXUf6eOPHykRn123Hj_fLqAd",
            "https://drive.google.com/open?id=1fGdO3Ky0Eh3z4JGBbpUhbdYZah0jwUK-",
            "https://drive.google.com/open?id=1qsQArE3-ptAIpJrinUZgzVYuC5VQLjR1",
            "https://drive.google.com/open?id=1FnxodP9l3o2sLGP0yJaRgfdOp1QEiO0t",
            "https://drive.google.com/open?id=1kKfsEPoI5GfGBCcvSikuyLtEnjJD5fcB",
            "https://drive.google.com/open?id=1v2ZW3gYkSkAfnDvkupAIFPEXPXGnUNx1",
            "https://drive.google.com/open?id=1KltMp0bF5sbkGd6Udc-kgXq3IeN7M4e-",
            "https://drive.google.com/open?id=13HG6E0angbXSPXbo4KWbbVp9dYYgnb4h",
            "https://drive.google.com/open?id=1E1wKHrPbKCkqw_bc-onxnkxyhNxyoC_U",
            "https://drive.google.com/open?id=1Lcq3MI7vbIiEXY6BFZH7PYE4rlcPjf2P"};


    String[] colldesc = {
            "B.Com | B.Sc",
            "B.A | B.Com",
            "B.A | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.E | B.Com",
            "B.Sc",
            "B.F.A",
            "B.A | B.Sc | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Sc",
            "B.A | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Sc | B.Com",
            "B.P.Ed | B.Sc",
            "B.A | B.Sc | B.Com",
            "B.Sc",
            "B.A | B.Sc | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Sc",
            "B.Sc",
            "B.A | B.Sc | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Sc | B.Com",
            "B.Ed",
            "B.A | B.Sc | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Sc",
            "B.A | B.Sc | B.Com",
            "B.A | B.Sc",
            "B.A",
            "B.A | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Com",
            "B.A | B.Com",
            "B.A | B.Com",
            "B.A | B.Com",
            "B.Sc",
            "B.Sc",
            "B.A | B.Sc | B.Com",
            "B.A | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Sc",
            "B.A | B.Sc | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Sc | B.Com",
            "B.A | B.Com",


    };


    String colcoursedetailed[] =
            {          //Acharya narendre college
                            "B.Sc.(H)Biomedical Sciences\n" +
                            "B.Sc.(H)Botany\n" +
                            "B.Sc.(H)Chemistry\n" +
                            "B.Sc.(H)Computer Science\n" +
                            "B.Sc.(H)Electronics\n" +
                            "B.Sc.(H)Physics\n" +
                            "B.Sc.(H)Zoology\n" +
                            "B.Sc.(H)Mathematics\n\n" +
                            "B.Sc.Physical Science(Computers)\n" +
                            "B.Sc.Physical Science(Electronics)\n" +
                            "B.Sc.Physical Science(Chemistry)\n" +
                            "B.Sc.Life science\n\n" +
                            "B.Com(H)\n",

                    // aditi mahavidhalaya
                    "B.A.(Programme) \n" +
                            "B.A.(H)Geography \n" +
                            "B.A.(H)Social Work \n" +
                            "B.A.(H)Hindi Patrakarita\n\n" +
                            " B.Com.(Hons.)\n" +
                            " B.Com. \n\n" +
                            "B.El.Ed.\n",

                    //aryabhata college
                    "B.Com\t\n" +
                            "B.Com (H)\n" +
                            "B.A.(H)Economics\n" +
                            "B.A.(H)Business Economics\n" +
                            "B.A.(H)English\n" +
                            "B.A.(H)Political Science\n" +
                            "B.A.(H)Hindi\n\n" +
                            "B.Sc(H)Mathematics\n" +
                            "B.Sc(H)Computer Science\n\n" +
                            "B.A.Programme(Political Science)\n" +
                            "B.A.Programme(History)\n" +
                            "Bachelor in Management Studies\n" +
                            "B.A.(H)Psychology\n" +
                            "B.A.(H)History",

                    //atma ram sanatan dhararm
                    "B.A (Hons) Economics\n" +
                            "B.A(Hons)History\n" +
                            "B.A(Hons)Hindi\n" +
                            "B.A(Hons)Political Science\n" +
                            "B.A(Programme)\n" +
                            "B.A.(Hons.)English\n\n" +
                            "B.Com(Hons.)\n" +
                            "B.Com.(Course)\n\n" +
                            "B.Sc.(Applied Phy. Sc.) Industrial Chemistry\n" +
                            "B.Sc.(H)Chemistry\n" +
                            "B.Sc.(H)Computer Science\n" +
                            "B.Sc.(H)Electronics\n" +
                            "B.Sc.(H)Mathematics\n" +
                            "B.Sc.(H)Physics\n" +
                            "B.Sc.(Phy. Sc.)Chemistry\n" +
                            "B.Sc.(Phy. Sc.)Computer Science\n" +
                            "B.Sc.(Phy. Sc.)Electronics\n" +
                            "B.Sc.(Prog.)Physical Science",


                    //bhagini nivedita
                    "B.A.(Hons.)Hindi\n" +
                            "B.A(Programme)\n\n" +
                            "B.Com\n\n" +
                            "B.Sc Physical Science\n" +
                            "B.Sc.(H)History\n" +
                            "B.Sc.(H)Home Science\n" +
                            "B.Sc.(H)Physics\n",


                    // bharti college
                    "B.A. Honours English\n" +
                            "B.A. Honours Hindi \n" +
                            "B.A. Honours History \n" +
                            "B.A. Honours Psychology  \n" +
                            "B.A. Honours Sociology \n" +
                            "B.A. Honours Political Science \n" +
                            "B.A. Honours Sanskrit,B.Com Honours \n" +
                            "B.Com Programme, B.A. Programme \n" +
                            "B.A. Honours Journalism \n" +
                            "B.Sc Honours Mathematics\n",

                    //bhaskaracharya
                    "B.Sc.(H)Biomedical Science\n" +
                            "B.Sc.(H)Computer Science\n" +
                            "B.Sc.(H)Electronics\n" +
                            "B.Sc.(H)Food Technology\n" +
                            "B.Sc.(H)Instrumentation\n" +
                            "B.Sc.(H)Microbiology\n" +
                            "B.Sc.(H)Physics\n" +
                            "B.Sc.(H)Polymer Science\n" +
                            "B.Sc(H)Botany\n" +
                            "B.Sc.(H)Chemistry\n" +
                            "B.Sc.(H)Zoology",

                    //College Of arts
                    "BFA Specialization\n\n " +
                            "   -Applied Art\n" +
                            "   -Painting\n" +
                            "   -Sculpture\n" +
                            "   -Art History\n" +
                            "   -Printmaking\n " +
                            "   -Visual Communication",

                    //College Of Vocational Studies
                    "B.Com (Hons.)\n" +
                            "B.A.(H)History\n" +
                            "B.A.(H)Economics\n" +
                            "B.A.(H)Hindi\n" +
                            "B.A.(H)English\n" +
                            "B.A.(H)Business Economics\n\n" +
                            "Bachelor in Management Studies\n\n" +
                            "B.Sc.(H)Computer Science\n",

//daulat ram
                    "B.Com (Hons.)\n" +
                            "B.A.(H)History\n" +
                            "B.A.(H)Economics\n" +
                            "B.A.(H)Hindi\n" +
                            "B.A.(H)English\n" +
                            "B.A.(H)Phylosophy\n" +
                            "B.A.(H)Psychology\n" +
                            "B.A.(H)Physical Education\n" +
                            "B.A.(H)Sanskrit\n\n" +

                            "B.Com(Hons.)\n\n" +

                            "B.Sc.(H)Botany\n" +
                            "B.Sc.(H)Biochemistry\n" +
                            "B.Sc.(H)Mathematics\n" +
                            "B.Sc.(H)Physics\n" +
                            "B.Sc.(H)Zoology\n" +
                            "B.Sc.(H)Nutrition and Health Managemetn\n" +
                            "B.Sc.(H)Chemistry\n",


//dayal singh
                    "B.A. Programme\n" +
                            "B.A.(H)Hindi\n" +
                            "B.A.(H)Economics\n" +
                            "B.A.(H)History\n" +
                            "B.A.(H)Political Science\n" +
                            "B.A.(H)Geography\n" +
                            "B.A.(H)Urdu\n" +
                            "B.A.(H)Punjabi\n" +
                            "B.A.(H)Sanskrit\n" +
                            "B.A.(H)Philosophy\n" +
                            "B.A.(H)English\n\n" +
                            "B.Com\n" +
                            "B.Com (Hons.)\n\n" +

                            "B.Sc Physical Science\n" +
                            "B.Sc Physical Science with Computer Sciences\n" +
                            "B.Sc Life Science\n" +
                            "B.Sc(H)Mathematics\n" +
                            "B.Sc(H)Botany\n" +
                            "B.Sc(H)Chemistry\n" +
                            "B.Sc(H)Physics\n" +
                            "B.Sc(H)Zoology\n" +
                            "B.Sc(H)Computer Sciences\n",


                    //dayal singh evening
                    "B.Com (Hons.)\n" +
                            "B.Com Programme\n\n" +
                            "B.A.(H)English\n" +
                            "B.A.(H)Political Science\n" +
                            "B.A.Programme with Computer Application\n",

                    //deen dayal
                    "B.A.(H)English\n" +
                            "B.A.Programme\n" +
                            "B.Com.(H)\n" +
                            "B.Sc.Life Sciences\n" +
                            "B.Sc.Physical Sciences(Chemistry)\n" +
                            "B.Sc.Physical Sciences(Computer Science)\n" +
                            "B.Sc.Mathematical Science\n" +
                            "B.Sc.(H)Botany\n" +
                            "B.Sc.(H)Chemistry\n" +
                            "B.Sc.(H)Computer Science\n" +
                            "B.Sc.(H)Electronics\n" +
                            "B.Sc.(H)Mathematics\n" +
                            "B.Sc.(H)Physics\n" +
                            "B.Sc.(H)Zoology\n" +
                            "Bachelor in Management Studies",

//delhicollegeofartsandcommerce
                    "B.Com. (Honours)\n" +
                            "B.A.(Honours)Economics\n" +
                            "B.A.(Honours)English\n" +
                            "B.A.(Honours)Journalism\n" +
                            "B.A.(Honours)History\n" +
                            "B.A.(Honours)Political Science\n\n" +
                            "B.Com.(Programme)\n\n" +
                            "B.A.(Programme)",

//deshbandhu
                    "B.A. programme \n" +
                            "B.A.programme with Bengali, Punjabi, Sanskrit\n" +
                            "B.A.programme with Philosophy\n" +
                            "B.A.(Hons.)Economics\n" +
                            "B.A.(Hons.)English\n" +
                            "B.A.(Hons.)Hindi\n" +
                            "B.A.(Hons.)History\n" +
                            "B.A.(Hons.)Political Science\n" +
                            "B.A.(Hons.)Sanskrit\n\n" +
                            "B.Com.(Hons.)\n\n" +
                            "B.Sc.(Hons.)Botany\n" +
                            "B.Sc.(Hons.)Chemistry\n" +
                            "B.Sc.(Hons.)Mathematics\n" +
                            "B.Sc.(Hons.)Physics\n" +
                            "B.Sc.(Hons.)Zoology\n\n" +
                            "B.Sc.(General)Industrial Chemistry\n" +
                            "B.Sc.Physical Science\n" +
                            "B.Sc.Physical Science(Computer Science)",

//bhim rao ambedkar
                    "B.A.(Hons.)Applied Psychology\n" +
                            "B.A.(Hons.)Business Economics (through entrance)\n" +
                            "B.A.(Hons.)Geography\tPDF icon B.A. (H) Geography.pdf\n" +
                            "B.A.(Hons.)Hindi Journalism and Mass Communication\n" +
                            "B.A.(Hons.)Social Work\n" +
                            "B.A.(Hons.)History\n\n" +
                            "B.Com.(Hons.)\n" +
                            "B. Com.\n\n" +
                            "B.A. Programme",

//gargi
                    "B.Sc.(Hons.)Botany\n" +
                            "B.Sc.(Hons.)Chemistry\n" +
                            "B.Sc.(Hons.)Microbiology\n" +
                            "B.Sc.(Hons.)Zoology\n" +
                            "B.Sc.(Hons.)Mathematics\n" +
                            "B.Sc.(Hons.)Physics\n\n" +
                            "B.Com\n\n" +
                            "B.A(Hons.)Business Economics\n" +
                            "B.A(Hons.)Political Science\n" +

                            "B.A(Hons.)Hindi\n" +
                            "B.A(Hons.)History\n" +
                            "B.A(Hons.)Economics\n" +
                            "B.A(Hons.)English\n" +
                            "B.A(Hons.)Philosophy\n" +
                            "B.A(Hons.)Psychology\n" +
                            "B.A(Hons.)German\n" +
                            "B.A(Hons.)Physical Education" +
                            "B.A(Hons.)Sanskrit\n\n" +
                            "B.A. Programme\n\n" +
                            "Elementary Education\n",

//hansraj
                    "B.Sc.(Hons.)Anthropology\n" +
                            "B.Sc.(Hons.)Botany\n" +
                            "B.Sc.(Hons.)Chemistry\n" +
                            "B.Sc.(Hons.)Computer Science\n" +
                            "B.Sc.(Hons.)Electronics\n" +
                            "B.Sc.(Hons.)Geology\n" +
                            "B.Sc.(Hons.)Mathematics\n" +
                            "B.Sc.(Hons.)Zoology\n" +
                            "B.Sc.(Hons.)Physics\n" +
                            "B.Sc.Physical Sciences\n" +
                            "B.Sc.Life Sciences\n\n" +
                            "B.Com(Hons.)\n\n" +
                            "B.A.Programme\n\n" +
                            "B.A(Hons.)Hindi\n" +
                            "B.A(Hons.)History\n" +
                            "B.A(Hons.)Economics\n" +
                            "B.A(Hons.)English\n" +
                            "B.A(Hons.)Sanskrit\n",

//hindu
                    "B.Sc.(Hons.)Botany\n" +
                            "B.Sc.(Hons.)Chemistry\n" +
                            "B.Sc.(Hons.)Mathematics\n" +
                            "B.Sc.(Hons.)Physics\n" +
                            "B.Sc.(Hons.)Zoology\n\n" +
                            "B.Com(Hons.)\n\n" +
                            "B.A(Hons.)Economics\n" +
                            "B.A(Hons.)English\n" +
                            "B.A(Hons.)Hindi\n" +
                            "B.A(Hons.)History\n" +
                            "B.A(Hons.)Philosophy\n" +
                            "B.A(Hons.)Political Science\n" +
                            "B.A(Hons.)Sanskrit\n" +
                            "B.A(Hons.)Sociology\n" +
                            "B.A(Hons.)Statistics\n",


                    "B.Sc(P.E.,H.E & S)",

                    //indraprastha college for women
                    "B.Com\n" +
                            "B.Sc(Hons.)Computer Science\n" +
                            "B.Sc(Hons.)Mathematics\n\n" +
                            "B.A(Hons.)Economics\n" +
                            "B.A.(Hons.)English\n" +
                            "B.A.(Hons.)Environmental Studies\n" +
                            "B.A.(Hons.)Geography\n" +
                            "B.A.(Hons.)Hindi\n" +
                            "B.A.(Hons.)History\n" +
                            "B.A.(Hons.)Multimedia and Mass Communication\n" +
                            "B.A.(Hons.)Music\n" +
                            "B.A.(Hons.)Philosophy\n" +
                            "B.A.(Hons.)Political Science\n" +
                            "B.A.(Hons.)Psychology\n" +
                            "B.A.(Hons.)Sanskrit\n" +
                            "B.A.(Hons.)Sociology\n\n" +
                            "B.A Program",

//institue of home economics
                    "B.Sc Home Science (Honours)\n" +
                            "B.Sc Home Science (Pass)\n" +
                            "B.Sc Biochemistry (Honours)\n" +
                            "B.Sc Microbiology (Honours)\n" +
                            "B.Sc Food Technology (Honours)\n\n" +
                            "B.A. Journalism (Honours)\n\n" +
                            "Bachelor of Elementary Education",


                    "B.A(Hons.)Economics\n" +
                            "B.A(Hons.)English\n" +
                            "B.A(Hons.)Hindi\n" +
                            "B.A(Hons.)History\n" +
                            "B.A(Hons.)Philosophy\n" +
                            "B.A(Hons.)Political Science\n" +
                            "B.A(Hons.)Sanskrit\n" +
                            "B.A(Hons.)Sociology\n\n" +
                            "B.A.Programme\n\n" +
                            "B.Sc(Hons.)Mathematics\n\n" +
                            "B.Com\n" +
                            "B.Com(Hons.)\n",

//jesus and mery

                    "B.Com(Hons.)\n\n" +
                            "B.A(Hons.)Economics\n" +
                            "B.A(Hons.)Elementary Education\n" +
                            "B.A(Hons.)English\n" +
                            "B.A(Hons.)Hindi\n" +
                            "B.A(Hons.)History\n" +
                            "B.A(Hons.)Philosophy\n" +
                            "B.A(Hons.)Physical Education\n" +
                            "B.A(Hons.)Political Science\n" +
                            "B.A(Hons.)Psychology\n" +
                            "B.A(Hons.)Sociology\n" +
                            "B.A(Hons.)Spanish\n\n" +
                            "B.Sc(Hons.)Mathematics\n" +
                            "B.Sc(Hons.)Computer Science",

                    //kalindin college
                    "B.A.(Hons)English\n" +
                            "B.A.(Hons.)Hindi\n" +
                            "B.A.(Hons.)Sanskrit\n" +
                            "B.A.(Programme)\n" +
                            "B.A.(Hons.)History\n" +
                            "B.A.(Hons.)Journalism\n" +
                            "B.A.(Hons.)Political Science\n" +
                            "B.A.(H)Geography\n" +
                            "B.A.(Hons.)Economics\n\n" +
                            "B.Com.Programme\n" +
                            "B.Com.(Hons.)\n\n" +
                            "B.Sc.(Prog.) Life Sciences\n" +
                            "B.Sc.(prog.) Physical Sciences\n" +
                            "B.Sc(H)Computer Science\n" +
                            "B.Sc.(Hons.)Mathematics\n" +
                            "B.Sc.(Hons.)Physics\n" +
                            "B.Sc(H)Botany\n" +
                            "B.Sc(H)Chemistry\n" +
                            "B.Sc(H)Zoology\n\n" +
                            "B.Voc",

//kamala nehru college
                    "Journalism\n\n" +
                            "B.A.(Hons.)English\n" +
                            "B.A.(Hons.)Geography\n" +
                            "B.A.(Hons.)Hindi\n" +
                            "B.A.(Hons.)History\n" +
                            "B.A.(Hons.)\n" +
                            "B.A. (Hons.)Philosophy\n" +
                            "B.A. (Hons.)Psychology" +
                            "B.A. (Hons.) Political Science\n" +
                            "B.A. (Hons.) Sanskrit\n" +
                            "B.A. (Hons.) Sociology\n\n" +
                            "B.A. (Programme)\n\n" +
                            "B.Com. (Hons.)\n" +
                            "B.Com. (Programme)\n\n" +
                            "B.Sc.(Hons.)Mathematics\n" ,

//keshav mahavidyalaya
                            "B.Com.(Hons.)\n" +
                            "B.Sc.(Hons.)Computer Science\n" +
                            "B.Sc.(Hons.)Electronics\n" +
                            "B.Sc.(Hons.)Mathematics\n" +
                            "B.Sc.(Prog.)Mathematical Sciences\n" +
                            "B.Sc.(Hons.)Physics\n\n" +
                            "B.Sc.(Prog.)Physical Science with Computer Science\n\n" +
                            "Bachelor of Management Studies\n\n" +
                            "B.A.(Hons.)Psychology",

//kirori mal
                    "B.A. (Programme)\n" +
                            "B.A. (Programme) with Bengali\n\n" +
                            "B.Com.\n" +
                            "B.Com.(Hons.)\n\n" +
                            "B.A.(H)Economics\n" +
                            "B.A.(H)English\n" +
                            "B.A.(H)Geography\n" +
                            "B.A.(H)Hindi\n" +
                            "B.A.(H)History\n" +
                            "B.A.(H)Political Science\n" +
                            "B.A.(H)Sanskrit\n" +
                            "B.A.(H)Urdu\n\n" +
                            "B.Sc.Physical Sciences\n" +
                            "B.Sc.Physical Sciences with Computer Science Option\n" +
                            "B.Sc.Life Science\n" +
                            "B.Sc.Applied Physical Sciences (Analytical Chemistry)\n\n" +
                            "B.Sc.(H)Botany\n" +
                            "B.Sc.(H)Chemistry\n" +
                            "B.Sc.(H)Physics\n" +
                            "B.Sc.(H)Mathematics\n" +
                            "B.Sc.(H)Statistics\n" +
                            "B.Sc.(H)Zoology",

//lady irwin
                    "B.Sc.Home Science\n" +
                            "B.Sc.(Hons.)Home Science\n" +
                            "B.Sc.(Hons)Food Technology",

//lady shri ram
                    "B.A. Programme\n" +
                            "B.Com\n\n" +
                            "B.A(Hons.)Mathematics\n\n" +
                            "B.A(Hons.)Economics\n" +
                            "B.A(Hons.)Elementary Education\n" +
                            "B.A(Hons.)English\n" +
                            "B.A(Hons.)Hindi\n" +
                            "B.A(Hons.)History\n" +
                            "B.A(Hons.)Journalism\n" +
                            "B.A(Hons.)Philosophy\n" +
                            "B.A(Hons.)Political Science\n" +
                            "B.A(Hons.)Psychology\n" +
                            "B.A(Hons.)Sanskrit\n" +
                            "B.A(Hons.)Sociology\n" +
                            "B.A(Hons.)Statistics",

//lakshimabi college
                    "B.A. (Hons) Economics\n" +
                            "B.A.(Hons) English\n" +
                            "B.A.(Hons) Hindi\n" +
                            "B.A.(Hons) History \n" +
                            "B.A.(Hons) Philosophy\n" +
                            "B.A.(Hons) Political Science\n" +
                            "B.A.(Hons) Sanskrit\n" +
                            "B.A.(Programme)\n\n" +
                            "B.Com.(Hons)\n" +
                            "B.Com.(Programme)\n" +
                            "B.Sc.(Hons)Mathematics\n",

                    //maharaja agrasena college
                    "B.A.(H)Business Economics(BBE)\n" +
                            "B.A.(H)English\n" +
                            "B.A.(H)Journalism\n" +
                            "B.A.(H)Hindi\n" +
                            "B.A.(H)Political Science\n" +
                            "B.A.(Programme)\n" +
                            "B.Com.(H)\n" +
                            "B.Sc.(Physical Science)\n" +
                            "B.Sc.(H)Electronics\n" +
                            "B.Sc.(H)Mathematics\n",

                    //maharishi valmiki college
                    "Bachelor of Education Programme(B.Ed)",

                    //maitreyi college du
                    "B.Sc(H)Botany\n" +
                            "B.Sc(H)Chemistry (Integrated)\n" +
                            "B.Sc(H)Mathematics\n" +
                            "B.Sc(H)Physics (Integrated)\n" +
                            "B.Sc(H)Zoology\n" +
                            "B.Sc Programme Physical Science (Physics, Chemistry / Computer Science, Maths)\n" +
                            "B.Sc Life Sciences (Botany Chemistry, Zoology)\n\n" +
                            "B.A.(H)Economics\n" +
                            "B.A.(H)English\n" +
                            "B.A.(H)Hindi\n" +
                            "B.A.(H)History\n" +
                            "B.A.(H)Political Science\n" +
                            "B.A.(H)Sanskrit\n" +
                            "B.A.(H)Sociology\n" +
                            "B.A.Programme\n\n" +
                            "B.Com(Programme)\n" +
                            "B.Com(H)",

//mata sundri
                    "B.A.(Programme)\n" +
                            "B.Com(Programme)\n" +
                            "B.Com(H)\n\n" +
                            "B.A.(H)English\n" +
                            "B.A.(H)Hindi\n" +
                            "B.A.(H)History\n" +
                            "B.A.(H)Philosophy\n" +
                            "B.A.(H)Political Science\n" +
                            "B.A.(H)Psychology\n" +
                            "B.A.(H)Punjabi\n" +
                            "B.A.(H)Sanskrit\n" +
                            "B.Sc.(H)Mathematics\n" +
                            "B.Sc.(H)Statistics\n" +
                            "B.Sc.(H)Computer Science\n\n" +
                            "B.El.Ed.",

//miranda house
                    "B.A. Programme\n" +

                            "B.A.(H)Bengali\n" +
                            "B.A.(H)Economics\n" +
                            "B.A.(H)English\n" +
                            "B.A.(H)Geography\n" +
                            "B.A.(H)Hindi\n" +
                            "B.A.(H)History\n" +
                            "B.A.(H)Music\n" +
                            "B.A.(H)Philosophy\n" +
                            "B.A.(H)Political Science\n" +
                            "B.A.(H)Sanskrit\n" +
                            "B.A.(H)Sociology\n" +
                            "B.Sc.(H)Botany\n" +
                            "B.Sc.(H)Chemistry\n" +
                            "B.Sc.(H)Mathematics\n" +
                            "B.Sc.(H)Physics\n" +
                            "B.Sc.(H)Zoology\n" +
                            "B.Sc. Programme\n" +
                            "B.Sc. Life Sciences\n" +
                            "B.Sc. Physical Sciences\n" +
                            "B.El.Ed.",


                    //motilal nehru
                    "B.Com(Hons.)" +
                            "B.Sc.(H)Chemistry\n" +
                            "B.Sc.(H)Computer Science\n" +
                            "B.Sc.(H)Mathematics\n" +
                            "B.Sc.(H)Physics\n\n" +

                            "B.A.(H)Economics\n" +
                            "B.A.(H)English\n" +
                            "B.A.(H)Hindi\n" +
                            "B.A.(H)History\n" +
                            "B.A.(H)Political Science\n" +
                            "B.A.(H)Sanskrit\n",

//motilal eve
                    "Bachelor with Honours in English\n" +
                            "Bachelor with Honours in Hindi\n" +
                            "Bachelor with Honours in History\n" +
                            "Bachelor with Honours in Political Science\n" +
                            "Bachelor with Honours in Commerce\n" +
                            "B.A. (Programme)\n" +
                            "Bachelor of Commerce",


//PGDAV
                    "B.A. Programme\n\n" +
                            "B.Com.\n" +
                            "B.Com.(Hons)\n\n" +
                            "B.A.(Hons)Economics\n" +
                            "B.A.(Hons.)English\n" +
                            "B.A.(Hons.)History\n" +
                            "B.A.(Hons.)Hindi\n" +
                            "B.A.(Hons.)Political Science\n" +
                            "B.A.(Hons.)Sanskrit\n\n" +
                            "B.Sc.(Hons.)Mathematics\n" +
                            "B.Sc.(Hons)Statistics\n" +
                            "B.Sc.(Hons)Computer Science\n\n" +
                            "B.Sc. Mathematical Science",

//pgdav eve
                    "B.A.(Prog.)\n\n" +
                            "B.Com(Prog.)\n" +
                            "B.Com(H)\n\n" +
                            "B.A.(H)Pol.Sc.\n" +
                            "B.A.(H)Hindi\n\n" +
                            "B.Sc.(H)Mathematics",

//rajdhani

                    "B.Com(Hons)\n\n" +
                            "B.A Programme\n" +
                            "B.A(Hons) Political Science\n" +
                            "B.A(Hons) Sanskrit\n" +
                            "B.A(Hons) Hindi\n" +
                            "B.A(Hons) Economics\n" +
                            "B.A(Hons) English\n" +
                            "B.A(Hons) History\n\n" +
                            "B.Sc(Hons)Chemistry\n" +
                            "B.Sc(Hons) Electronics" +
                            "B.Sc(Hons) Mathematics\n" +
                            "B.Sc(Hons) Physics\n" +

                            "B.Sc(APS) Industrial Chemistry\n" +

                            "B.Sc(Physical Science) Chemistry\n" +
                            "B.Sc(Physical Science) Electronics\n" +
                            "B.Sc(Physical Science) Computer Science\n"
                    ,

//ramlal anand
                    "B.A.(Prog.)\n\n" +
                            "B.A.(Hons.)English\n" +
                            "B.A.(Hons.)Hindi\n" +
                            "B.A.(Hons.)BJMC\n" +
                            "B.A.(Hons.)Pol. Sc.\n" +
                            "B.A.(Hons.)History\n\n" +
                            "B.Com(Prog.)\n" +
                            "B.Com(Hons.)\n\n" +
                            "B.Sc.(Hons.)Comp. Sc.\n" +
                            "B.Sc.(Hons.)Geology\n" +
                            "B.Sc.(Hons.)Microbiology\n" +
                            "B.Sc.(Hons.)Statistics\n" +
                            "B.Sc.(Hons.)Mathematics\n\n" +
                            "Bachelor of Management Studies",

//ramanunjan college
                    "B.Com(Hons.)\n" +
                            "B.Com\n\n" +
                            "Bachelor of Management Studies\n" +
                            "B.A(Hons.) Political Science\n" +
                            "B.A(Hons.)Hindi\n" +
                            "B.A(Hons.)Philosophy" +
                            "B.A(Hons.)Economics" +
                            "B.A(Hons.)Applied Psychology\n" +
                            "B.A(Hons.)English\n\n" +
                            "B.A Programme\n\n" +
                            "B.Sc(Hons.)Statistics\n" +
                            "B.Sc(Hons.)Mathematics\n" +
                            "B.Sc(Hons.)Computer Science",

//ramjas
                    "B.A. Programme\n" +
                            "B.A.(Hons.)English\n" +
                            "B.A.(Hons.)Hindi\n" +
                            "B.A.(Hons.)Sanskrit\n" +
                            "B.A.(Hons.)Economics\n" +
                            "B.A.(Hons.)History\n" +
                            "B.A.(Hons.)Political Science\n" +
                            "B.A.(Hons.)Music\n\n" +

                            "B.Sc. (Hons.) Mathematics\n" +
                            "B.Sc. (Hons.) Statistics\n" +
                            "B.Sc (Hons.) Botany\n" +
                            "B.Sc (Hons.) Zoology\n" +
                            "B.Sc. (Hons.) Physics\n" +
                            "B.Sc. (Hons.) Chemistry\n\n" +
                            "B.Sc. (Prog.) Life Sciences\n" +
                            "B.Sc. (Prog.) Physical Sciences\n\n" +
                            "B. Com (Hons.)\n" +
                            "B. Com Programme",

//satyawati
                    "B.COM(H)\n" +
                            "B.COM(P)\n" +
                            "B.A.(Prog.)\n\n" +
                            "B.A.(H)ECONOMICS\n" +
                            "B.A.(H)ENGLISH\n" +
                            "B.A.(H)HINDI\n" +
                            "B.A.(H)HISTORY\n" +
                            "B.A.(H)POLITICAL SCIENCE\n" +
                            "B.A.(H)SANSKRIT\n" +
                            "B.A.(H)URDU\n" +
                            "B.SC.(H)MATHEMATICS\n"
                    ,

//satyawati eve
                    "B.A.(Prog.)\n\n" +
                            "B.Com(Hons.)\n" +
                            "B.Com(Prog.)\n\n" +
                            "Economics (Hons.)\n" +
                            "English (Hons.)\n" +
                            "Hindi (Hons.)\n" +
                            "History (Hons.)\n" +
                            "Pol Science (Hons.)",

                    "B.Com. (Hons.)\n" +
                            "B.Com\n" +
                            "B.A.(H)Economics\n" +
                            "B.A.(H)History\n" +
                            "B.A.(H)Pol. Science\n" +
                            "B.A.(H)Geography\n" +
                            "B.A.(H)Hindi\n" +
                            "B.A.(H)English\n" +
                            "B.A.(Prog.)" +
                            "B.Sc.(H)Mathematics\n",

                    //shahhed bhagat singh college evening
                    "B.Com(H)\n\n" +
                            "B.A.(Hons.)Geography\n" +
                            "B.A.(Hons.)English\n" +
                            "B.A.(Hons.)Economics\n" +
                            "B.A.(Hons.)History\n" +
                            "B.A.(Hons.)Pol. Science\n" +
                            "B.A.(Hons.)Hindi\n" +
                            "B.A.(Hons.)Physical Education",


                    //shaheed rajguru college of applied sciences
                    "B.Sc. (Hons.) Electronics\n" +
                            "B.Sc.(Hons.)Instrumentation\n" +
                            "B.Sc.(Hons.)Food Technology\n" +
                            "B.Sc.(Hons.)Computer Science\n" +
                            "B.Sc.(Hons.)Biomedical Science\n" +
                            "B.Sc.(Hons.)Physics\n" +
                            "B.Sc.(Hons.)Chemistry\n" +
                            "B.Sc.(Hons.)Mathematics\n" +
                            "B.Sc.(Hons.)Microbiology\n" +
                            "B.Sc.(Hons)Statistics\n" +
                            "B.Sc.(Hons.)Biochemistry\n" +
                            "B.Sc.(Hons.)Biochemistry\n\n" +
                            "B.A.(Hons)Psychology\n\n" +
                            "Bachelor of Management Studies\n" +
                            "Bachelor of Business Administration (FIA)\n"
                    ,

                    //shaheed sukhdev college of business studies
                    "Bachelor of Management Studies\n" +
                            "Bachelor of Financial & Investment Analysis\n" +
                            "Bachelor of Bussiness Studies\n\n" +
                            "B.Sc(Hons)Computer Science\n",

                    //shivaji college

                    "B.Sc(Hons)Biochemistry\n" +
                            "B.Sc(Hons)Botany\n" +
                            "B.Sc(Hons)Physics\n" +
                            "B.Sc(Hons)Zoology\n" +
                            "B.Sc(Hons)Mathematics\n" +
                            "B.Sc(Hons)Computer Science\n" +
                            "B.Sc(Hons)Environmental Studies\n" +
                            "B.Sc(Hons)Chemistry\n\n" +
                            "B.Com(H)\n\n" +
                            "B.A.(Hons.)Economics\n" +
                            "B.A.(Hons.)English\n" +
                            "B.A.(Hons.)Geography\n" +
                            "B.A.(Hons.)Hindi\n" +
                            "B.A.(Hons.)History\n" +
                            "B.A.(Hons.)Physical Education\n" +
                            "B.A.(Hons.)Political Science\n" +
                            "B.A.(Hons.)Sanskrit\n" +
                            "B.A.(Hons.)Sociology\n\n" +
                            "Bachelor Business Economics\n",

                    // shri ram college
                    "B.Com(H)\n\n" +
                            "B.A. (H) Economics\n\n",

                    "B.Sc in Physical Science\n"+
                            "B.Sc Physical Science in Chemistry\n"+
                            "B.Sc Physical Science in Computer Science\n"+
                            "B.Sc Physical Science in Electronics\n\n"+
                            "B.Com(Hons.)\n"+
                            "B.Com\n\n"+
                            "B.A.(Hons.)Hindi\n" +
                            "B.A.(Hons.)Pol. Science\n" +
                            "B.A.(Hons.)English\n" +
                            "B.A.(Hons.)Ecnomics\n" +
                            "B.A.(Hons.)History\n",


                    "B.Com. Programme\n" +
                            "B.Com.(Hons.)\n\n" +
                            "B.A.(Hons.) Economics\n" +
                            "B.A.(Hons.)Hindi\n" +
                            "B.A.(Hons.)Pol. Science\n" +
                            "B.A. Programme",

                    //sri aurobindo college
                    "B.Sc(Hons) Botany\n" +
                            "B.Sc(Hons)Maths\n" +
                            "B.Sc(Hons)Physics\n" +
                            "B.Sc(Hons) Electronics\n" +
                            "B.Sc(Hons)Zoology\n" +
                            "B.Sc(Hons)Computer Science\n" +
                            "B.Sc(Hons)Environmenal Science\n" +
                            "B.Sc(Hons) Chemistry\n\n" +
                            "B. Com (Hons.)\n\n" +
                            "B.A.(Hons.)Economics\n" +
                            "B.A.(Hons.)English\n" +
                            "B.A.(Hons.)Hindi\n" +
                            "B.A.(Hons.)History\n" +
                            "B.A.(Hons.)Political Science\n" +
                            "B.A.(Hons.)Physical Education\n" +
                            "B.A.(Hons.)Sanskrit\n",

                    //sri aurobindo college
                    "B. Com\n" +
                            "B. Com (Hons.)\n\n" +
                            "B.A(Programme)\n" +
                            "B.A.(Hons.)Hindi\n" +
                            "B.A.(Hons.) App. Psy.\n\n",

                    //sri guru govind singh college
                    "B. Com (Hons)\n" +
                            "B.Com\n\n" +
                            "B.A.(Hons) Economics\n" +
                            "B.A(H)Punjabi\n" +
                            "B.A.(Hons)Business Economics\n\n" +
                            "B.Sc.(Hons)Computer Science\n",

                    //sri guru nanak dev khalsa college
                    "B.Com (Hons.)\n" +
                            "B.Com Prog.\n\n" +
                            "B.A.(Hons.)English\n" +
                            "B.A.(Hons.)Hindi\n" +
                            "B.A.(Hons.)Punjabi\n" +
                            "B.A.(Hons.)History\n" +
                            "B.A.(Hons.)Political Science\n" +
                            "B.A.(Hons.)Hindi Journalism & Mass Communication\n" +
                            "B.A.(Hons.)Business Economics\n" +
                            "B.A.(Hons.)Mathematics\n" +
                            "B.A.Programme\n\n",

                    //sri guru teg bahadur
                    "B.Com (Program)\n" +
                            "B.Com (Hons)\n\n" +
                            "B.Sc Life Science\n" +
                            "B.Sc Physical Science\n" +
                            "B.Sc(Hons)Botany\n" +
                            "B.Sc(Hons)Chemistry\n" +
                            "B.Sc(Hons)Computer Science\n" +
                            "B.Sc(Hons)Electronics\n" +
                            "B.Sc(Hons)Mathematics\n" +
                            "B.Sc(Hons)Zoology\n" +
                            "B.Sc(Hons)Physics\n\n" +
                            "B.A.(Hons)Economics\n" +
                            "B.A.(Hons)English\n" +
                            "B.A.(Hons)Hindi\n" +
                            "B.A.(Hons)History\n" +
                            "B.A.(Hons)Political Science\n" +
                            "B.A.(Hons)Physical Education\n" +
                            "B.A(Program\n" +
                            "B.A.(Hons)Punjabi\n",

                    //sri Venketashwara college
                    "B.A.(Programme)\n" +
                            "B.A.(Hons)English\n" +
                            "B.A.(Hons)Hindi\n" +
                            "B.A.(Hons)Sanskrit\n" +
                            "B.A.(Hons)Economics\n" +
                            "B.A.(Hons)History\n" +
                            "B.A.(Hons)Political Science\n" +
                            "B.A.(Hons)Sociology\n\n" +
                            "B.Com\n" +
                            "B.Com (Hons)\n\n" +
                            "B.Sc(Programme)Life Sciences\n" +
                            "B.Sc(Hons)Bio-Chemistry\n" +
                            "B.Sc(Hons)Biological Sciences\n" +
                            "B.Sc(Hons)Botany\n" +
                            "B.Sc(Hons)Chemistry\n" +
                            "B.Sc(Hons)Electronics\n" +
                            "B.Sc(Hons)Mathematics\n" +
                            "B.Sc(Hons)Physics\n" +
                            "B.Sc(Hons)Statistics\n" +
                            "B.Sc(Hons)Zoologyn\n\n",

                    //st stephen college
                    "B.A.(H) Economics \n" +
                            "B.A.(H) English\n" +
                            "B.A.(H) History\n" +
                            "B.A.(H) Sanskrit\n" +
                            "B.A.(H) Philosophy\n\n" +
                            "B.Sc.(H) Chemistry\n" +
                            "B.Sc.(H) Mathematics\n" +
                            "B.Sc.(H) Physics\n\n" +
                            "B.Sc. Programme (Physical Science)\n" +
                            "B.A. Programme\n",

                    //swami shraddhananda college
                    "B.A.(H) English\n" +
                            "B.A.(H) Geography\n" +
                            "B.A.(H) Hindi\n" +
                            "B.A.(H) History\n" +
                            "B.A.(Program)\n\n" +
                            "B.Com.(H)\n" +
                            "B.Com.(Prog)\n\n" +
                            "B.Sc.(H) Botany\n" +
                            "B.Sc.(H) Chemistry\n" +
                            "B.Sc.(H) Microbiology\n" +
                            "B.Sc.(H) Physics\n" +
                            "B.Sc.(H) Zoology\n" +
                            "B.Sc.(H) Physical Science\n" +
                            "B.Sc. Life Science\n" +
                            "B.Sc. Applied Life Science",

                    //viveknand college
                    "B.A.(Hons.)Applied Psychology\n" +
                            "B.A.(Hons.)English\n" +
                            "B.A.(Hons.)Hindi\n" +
                            "B.A.(Hons.)History\n" +
                            "B.A.(Hons.)Political Science\n" +
                            "B.A.(Hons.)Sanskrit\n\n" +
                            "B.Com(Hons.)Commerce\n\n",

                    //zakhir hussain colege
                    " B.Sc. (H) Botany\n" +
                            "B.Sc.(H) Chemistry\n" +
                            "B.Sc. (H) Electronics\n" +
                            "B.Sc. (H) Mathematics\n" +
                            "B.Sc.(H) Zoology\n" +
                            "B.Sc. Life Sciences\n" +
                            "B.Sc. Physical Sciences\n\n" +
                            "B.Com.(Hons.)\n" +
                            "B.Com.\n\n" +
                            "B.A.(Hons.) Arabic\n" +
                            "B.A.(Hons.) Bengali\n" +
                            "B.A.(Hons.) Economics\n" +
                            "B.A.(Hons.) English\n" +
                            "B.A.(Hons.) Hindi\n" +
                            "B.A.(Hons.) History\n" +
                            "B.A.(Hons.) Persian\n" +
                            "B.A.(Hons.) Philosophy\n" +
                            "B.A.(Hons.) Political Science\n" +
                            "B.A.(Hons.) Psychology\n" +
                            "B.A.(Hons.) Sanskrit\n" +
                            "B.A.(Hons.) Urdu\n" +
                            "B.A.(Prog.) Arabic\n" +
                            "B.A.(Prog.) Bengali MIL & LS\n" +
                            "B.A.(Prog.) Economics\n" +
                            "B.A.(Prog.) English\n" +
                            "B.A.(Prog.) Hindi\n" +
                            "B.A.(Prog.) History\n" +
                            "B.A.(Prog.) HRM Commerce\n" +
                            "B.A.(Prog.) Mathematics\n" +
                            "B.A.(Prog.) Persian\n" +
                            "B.A.(Prog.) Philosophy\n" +
                            "B.A.(Prog.) Political Science\n" +
                            "B.A.(Prog.) Psychology\n" +
                            "B.A.(Prog.) Sanskrit\n" +
                            "B.A.(Prog.) Urdu"
                    ,


                    // zakhir hussain eve
                    "B. Com\n" +
                            "B. Com (Hons.)\n\n" +
                            "B.A (Prog.)\n" +
                            "B.A.(Hons.)Hindi\n" +
                            "B.A.(Hons.)Persian\n" +
                            "B.A.(Hons.)Political Science\n" +
                            "B.A.(Hons.)History\n" +
                            "B.A.(Hons.)English\n" +
                            "B.A.(Hons.)Sanskrit\n" +
                            "B.A.(Hons.)Urdu"
            };


    String[] collink = {
            "http://andcollege.du.ac.in/",
            "http://aditi.du.ac.in/",
            "http://aryabhattacollege.ac.in/",
            "http://arsdcollege.ac.in/",
            "http://www.bhagininiveditacollege.in/",
            "https://www.bharaticollege.org/",
            "http://bcas.du.ac.in/",
            "http://delhi.gov.in/wps/wcm/connect/Lib_Collegeofart/collegeofarts/home",
            "http://www.cvs.edu.in/",
            "http://dr.du.ac.in/",
            "http://www.dsc.du.ac.in/",
            "http://dsce.du.ac.in/",
            "https://dducollegedu.ac.in/",
            "http://www.dcac.du.ac.in/",
            "https://www.deshbandhucollege.ac.in/",
            "http://www.drbrambedkarcollege.ac.in/",
            "http://gargi.du.ac.in/",
            "https://www.hansrajcollege.ac.in/",
            "http://www.hinducollege.ac.in/",
            "http://igipess1.du.ac.in:8080/web/home_page.jsp",
            "http://www.ipcollege.ac.in/",
            "http://www.ihe-du.com/",
            "http://jdm.du.ac.in/",
            "http://www.jmc.ac.in/",
            "http://kalindi.du.ac.in/",
            "https://www.knc.edu.in/",
            "http://keshav.du.ac.in/",
            "http://www.kmcollege.ac.in/",
            "http://www.ladyirwin.edu.in/",
            "http://lsr.edu.in/",
            "https://lakshmibaicollege.in/",
            "http://mac.du.ac.in/",
            "http://www.mvce.ac.in/",
            "http://maitreyi.ac.in/",
            "http://www.ms.du.ac.in/",
            "http://www.mirandahouse.ac.in/",
            "http://www.mlncdu.ac.in/",
            "http://www.mlnce.org/",
            "http://pgdavcollege.edu.in/",
            "https://www.pgdaveve.in/",
            "http://rajdhanicollege.ac.in/",
            "https://rlacollege.edu.in/",
            "http://rcdu.in/",
            "http://ramjas.du.ac.in/",
            "http://satyawati.du.ac.in/",
            "http://satyawatievedu.ac.in/",
            "http://www.sbsc.in/",
            "http://www.sbsec.org/",
            "http://www.rajgurucollege.com/",
            "http://sscbs.du.ac.in/",
            "http://www.shivajicollege.ac.in/",
            "http://www.srcc.edu/",
            "http://shyamlal.du.ac.in/",
            "http://shyamlale.du.ac.in/",
            "http://www.aurobindo.du.ac.in/",
            "http://www.saceve.in/",
            "http://www.sggscc.ac.in/",
            "https://sgndkc.org/",
            "http://www.sgtbkhalsadu.ac.in/",
            "http://www.svc.ac.in/",
            "http://www.ssncollege.com/",
            "http://www.ssncollege.com/",
            "http://vivekanandacollege.edu.in/",
            "http://www.zakirhusaindelhicollege.ac.in/",
            "http://www.zakirhusainpgeve.in/"};

    String colmap[] = {
            "acharya+narendra+dev+college+du",
            "aditi+mahavidyalaya+college+du",
            "Aryabhatta+College+du",
            "Atma+Ram+Sanatan+Dharma+College+du",
            "Bhagini+Nivedita+College+du",
            "Bharati+College+du",
            "Bhaskaracharya+College+Of+Applied+Sciences+du",
            "College+Of+Arts+du",
            "College+Of+Vocational+Studies+du",
            "Daulat+Ram+College+du",
            "Dyal+Singh+College+du",
            "Dyal+Singh+College+du",
            "Deen+Dayal+Upadhyaya+College+du",
            "Delhi+ollege+Of+Arts+and+Commerce+du",
            "Deshbandhu+College+du",
            "Dr.+Bhim+Rao+Ambedkar+College+du",
            "Gargi+College+du",
            "Hansraj+College+du",
            "Hindu+College+du",
            "Indira+Gandhi+Institute+of+Physical+Education+and+Sports+Sciences+du",
            "Indraprastha+College+for+women+du",
            "Insitute+Of+Home+Economics+du",
            "Janki+Devi+Memorial+College+du",
            "Jesus+and+Mary+College+du",
            "Kalindi+College+du",
            "Kamala+Nehru+College+du",
            "Keshav+Mahavidyalaya+College+du",
            "Kirori+Mal+College+du",
            "Lady+Irwin+College+du",
            "Lady+Shri+Ram+College+for+women+du",
            "Lakshimbai+College+du",
            "Maharaja+Agrasena+College+du",
            "Maharishi+Valmiki+College+of+Education+du",
            "Maitreyi+College+du",
            "Mata+Sundri+College+for+Women+du",
            "Miranda+House+du",
            "Motilal+Nehru+College+du",
            "Motilal+Nehru+College+du",
            "P.G.D.A.V+college+du",
            "P.G.D.A.V+College+du",
            "Rajdhani+College+du",
            "Ram+Lal+Anand+College+du",
            "Ramanujan+College+du",
            "Ramjas+College+du",
            "Satyawati+College+du",
            "Satyawati+College+du",
            "Shaheed+Bhagat+Singh+College+du",
            "Shahhed+Bhagat+Singh+College+du",
            "Shaheed+Rajguru+College+Of+Applied+Sciences+du",
            "Shaheed+Sukhdev+College+Of+Business+Studies+du",
            "Shivaji+College+du",
            "Shri+Ram+College+Of+Commerce+du",
            "Shyama+Lal+College+du",
            "Shyama+Lal+College+du",
            "Sri+Aurobindo+College+du",
            "Sri+Aurobindo+College+du",
            "Sri+Guru+Gobind+Singh+College+Of+Commerce+du",
            "Sri+Guru+Nanak+Dev+Khalsa+College+du",
            "Sri+Guru+Teg+Bahadur+Khasa+College+du",
            "Sri+Venkateswara+College+du",
            "St.+Stephen's+College+du",
            "Swami+Shraddhanada+College+du",
            "Vivekananda+College+du",
            "Zakir+Hussain+Delhi+College+du",
            "Zakir+Hussain+Delhi+College+du"


    };

    int cImages[] = {
            R.raw.acharya,
            R.raw.aditi,
            R.raw.aryabhatta,
            R.raw.atmaram,
            R.raw.bhagini,
            R.raw.bharati,
            R.raw.bhaskarachary,
            R.raw.collofarts,
            R.raw.cvs,
            R.raw.daulatram,
            R.raw.dayals,
            R.raw.dayaleve,
            R.raw.ddu,
            R.raw.delhicolofanc,
            R.raw.deshbandhu,
            R.raw.bhimrao,
            R.raw.gargi,
            R.raw.hansraj,
            R.raw.hindu,
            R.raw.igi,
            R.raw.indraprastha,
            R.raw.homeeconomics,
            R.raw.janakidevi,
            R.raw.jesusnmerry,
            R.raw.kalindi,
            R.raw.kamalanehru,
            R.raw.keshav,
            R.raw.kirorimal,
            R.raw.lady,
            R.raw.ladyshri,
            R.raw.lakshimibai,
            R.raw.maharaja,
            R.raw.maharishi,
            R.raw.maitreyi,
            R.raw.matasundri,
            R.raw.miranda,
            R.raw.motilal,
            R.raw.motilaleve,
            R.raw.pgd,
            R.raw.pgdeve,
            R.raw.rajdhani,
            R.raw.ramlal,
            R.raw.ramanunjan,
            R.raw.ramjas,
            R.raw.satyawati,
            R.raw.satyawatieve,
            R.raw.shaheed,
            R.raw.shaheed,
            R.raw.shaheedraj,
            R.raw.shaheedsukhdev,
            R.raw.shivajicollege,
            R.raw.ladyshri,
            R.raw.shyamlal,
            R.raw.shyamlal,
            R.raw.sriaurobindo,
            R.raw.sriaurobindo,
            R.raw.srigurugobind,
            R.raw.srigurunanakdev,
            R.raw.srigurutegbahadur,
            R.raw.srivenkatesh,
            R.raw.stephens,
            R.raw.swami,
            R.raw.vivekanada,
            R.raw.zakir,
            R.raw.zakir


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collegelist);


        final ListView listView = findViewById(R.id.lv);
        final customadapter cs = new customadapter();
        listView.setAdapter(cs);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                positionsetter(position);
            }
        });





    }


    class customadapter extends BaseAdapter {

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
            convertView = getLayoutInflater().inflate(R.layout.listviewcollege, null);
            TextView t1 = convertView.findViewById(R.id.colname);
            TextView t2 = convertView.findViewById(R.id.coldesc);
            t1.setText(collnames[position]);
            t2.setText(colldesc[position]);
            return convertView;

        }


    }


    public void positionsetter(int position) {
        tempcname = collnames[position];
        tempcrname = colldesc[position];
        tempcolmapname = colmap[position];
        tempcolimage = cImages[position];
        tempcollink = collink[position];
        tempcoursedetailed = colcoursedetailed[position];
        tempbroname = broch[position];


        i = new Intent(collegelist.this, collegeinfo.class);
        i.putExtra("collegenametopass", tempcname);
        i.putExtra("coursesnametopass", tempcrname);
        i.putExtra("colmapnametopass", tempcolmapname);
        i.putExtra("colimagetopass", tempcolimage);
        i.putExtra("coursedetailtopass", tempcoursedetailed);
        i.putExtra("collinktopass", tempcollink);
        i.putExtra("borlinktopass", tempbroname);

        startActivity(i);
        //  Toast.makeText(collegelist.this, tempcname, Toast.LENGTH_SHORT).show();
    }


}
