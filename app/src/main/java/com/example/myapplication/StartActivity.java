package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity {
    ViewPager slideViewPager;
    sliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        slideViewPager= findViewById(R.id.slideViewPager);

        SharedPreferences sharedPreferences= getSharedPreferences("MONKTREE",MODE_PRIVATE);
        if(sharedPreferences.getString("entered",null)!=null){
            Intent intent= new Intent(StartActivity.this, MainActivity.class);
            startActivity(intent);
        }

        sliderAdapter= new sliderAdapter(getSupportFragmentManager());
        sliderAdapter.AddFragment(new SplashScreen());
        sliderAdapter.AddFragment(new Screen2());
        sliderAdapter.AddFragment(new Screen3());
        sliderAdapter.AddFragment(new Screen4());
        slideViewPager.setAdapter(sliderAdapter);
        slideViewPager.addOnPageChangeListener(viewListener);

    }

    ViewPager.OnPageChangeListener viewListener= new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            if(i==3) {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                SharedPreferences sharedPreferences= getSharedPreferences("MONKTREE",MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString("entered","yes");
                editor.commit();
                Intent intent= new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

}
