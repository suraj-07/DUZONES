package duzones.creativednas.com.duzones;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context=context;
    }

    //array
    public String[] slide_headings={
            "ABOUT",
            "EDUCATION",
            "INFORMATION"
    };

    public int[] slide_images = {

            R.raw.finalpngall,R.raw.studylogo2,R.raw.studylogo4,


    };

    public String[] slide_description ={
      "This application fulfills all the need of students pursuing undergraduate courses in Delhi Univesity or willing to take admission. It includes information about DU colleges their courses, location and much more. All the information is updated daily.",
      "Education gives us a knowledge of the world around us and changes it into something better. We are trying our best to provide you the study material that help to enlighten you in your studies.  ",
            "Every year thousands of student dream to take admission in DU but it is difficult to choose and take admission. Here you will get all the details about procedure for taking admissions. You will be notified about the Events and Internships."
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==(LinearLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_description[position]);

        container.addView(view);

     return view;
    }

    @Override
    public void destroyItem (ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout)object);
    }
}
