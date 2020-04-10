package com.technogenr.ocovid;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class NeedToDoActivity extends AppCompatActivity {
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_to_do);
back=(Button)findViewById(R.id.back);
        models = new ArrayList<>();
        models.add(new Model(R.drawable.maskk, "USE MASK", "Wear a mask if you are coughing or sneezing.\n" +
                "Masks are effective only when used in combination with frequent hand-cleaning with alcohol-based hand rub or soap and water.\n" +
                "If you wear a mask, then you must know how to use it and dispose of it properly."));
        models.add(new Model(R.drawable.handwash, "HAND WASH", "Wash your hands often with soap and water for at least 20 seconds especially after you coming from public place.\n" +
                "If soap and water are not readily available, use a hand sanitizer that contains at least 60% alcohol.\n" +
                "Avoid touching your eyes, nose, and mouth with unwashed hands."));
        models.add(new Model(R.drawable.social_distance, "SOCIAL DISTANCING", "Avoid close contact with people who are sick.\n" +
                "Maintain at least 1 metre distance between yourself and anyone who is coughing or sneezing.\n" +
                "Stay home when you are sick.\n" +
                "Cover your cough or sneeze with a tissue, then dispose of the tissue safely."));
        models.add(new Model(R.drawable.isolattion, "SELF ISOLATION", "Stay home for 14 days from the time you left an area with ongoing spread of virus.\n" +
                "Stay at home if you begin to feel unwell, even with mild symptoms until you recover.\n" +
                "If you develop fever, cough and difficulty breathing, seek medical advice promptly."));
      //  models.add(new Model(R.drawable.namecard, "Namecard", "Business cards are cards bearing business information about a company or individual."));

        adapter = new Adapter(models, this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NeedToDoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
