package com.kamrul.learndesign;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Main3Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, CardView.OnClickListener{

//   For cardview
    private CardView report,record,prescript,visit,reminder,schedule;

    private static final String TAG="Main3Activity";
    private DrawerLayout drawer;
    private NavigationView navigationView;

//    private Toolbar toolbar;
    androidx.appcompat.widget.Toolbar toolbar;

//    For Image Slider
    ////////Banner Slider///////

    private ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage = 2;
    private Timer timer;
    final private long DELAY_TIME =3000;
    final private long PERIOD_TIME =3000;

    ////////Banner Slider///////




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

//       For Image Slider

        ////////Banner Slider///////

        bannerSliderViewPager = findViewById(R.id.banner_slider);
        sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.drawable.banner5));
        sliderModelList.add(new SliderModel(R.drawable.banner6));


        sliderModelList.add(new SliderModel(R.drawable.banner1));
        sliderModelList.add(new SliderModel(R.drawable.banner2));
        sliderModelList.add(new SliderModel(R.drawable.banner3));
        sliderModelList.add(new SliderModel(R.drawable.banner4));
        sliderModelList.add(new SliderModel(R.drawable.banner5));
        sliderModelList.add(new SliderModel(R.drawable.banner6));

        sliderModelList.add(new SliderModel(R.drawable.banner1));
        sliderModelList.add(new SliderModel(R.drawable.banner2));



        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);

        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state == ViewPager.SCROLL_STATE_IDLE){
                    pageLooper();
                }
            }
        };
        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);


        startBannerSlideShow();

        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                pageLooper();
                stopBannerSlideShow();
                if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    startBannerSlideShow();
                }
                return false;
            }
        });

        ////////Banner Slider///////

        //For hide action bar
        getSupportActionBar().hide();

//        For CarrdView
        report = findViewById(R.id.reportId);
        record = findViewById(R.id.recordId);
        prescript = findViewById(R.id.prescriptId);
        visit = findViewById(R.id.visitId);
        reminder = findViewById(R.id.reminderId);
        schedule = findViewById(R.id.scheduleId);

        report.setOnClickListener(this);
        record.setOnClickListener(this);
        prescript.setOnClickListener(this);
        visit.setOnClickListener(this);
        reminder.setOnClickListener(this);
        schedule.setOnClickListener(this);
//        int image[]=(R.drawable.image, R.drwable.file, R.drawable.document);


        initView();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }

//    For Image Slider

    ////////Banner Slider///////

    private void pageLooper(){
        if (currentPage == sliderModelList.size()-2){
            currentPage = 2;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
        if (currentPage == 1){
            currentPage = sliderModelList.size()-3;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
    }

    private  void startBannerSlideShow(){
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage >= sliderModelList.size()){
                    currentPage = 1;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++,true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },DELAY_TIME,PERIOD_TIME);
    }

    private void stopBannerSlideShow(){
        timer.cancel();
    }


    ////////Banner Slider///////

//    For Navigation Drower
    private void initView() {

        Log.d(TAG,"initViews: Started");
        drawer = (DrawerLayout)findViewById(R.id.drawer);
        navigationView = (NavigationView)findViewById(R.id.navigation_drawer);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar = (Toolbar) this.findViewById(R.id.toolbar);*/
       navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
               case R.id.item1:

                    Intent i = new Intent(Main3Activity.this, MainActivity.class);
                    startActivity(i);
                Toast.makeText(getApplicationContext(),"Item 1 is Selected", Toast.LENGTH_SHORT).show();
                break;


                case R.id.item2:

                    Intent intent = new Intent(Main3Activity.this,Main3Activity.class);
                    startActivity(intent);

                    Toast.makeText(getApplicationContext(),"Item 2 is Selected",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.item3:

                      Intent intent2 = new Intent(Main3Activity.this,Main5Activity.class);
                    startActivity(intent2);

                Toast.makeText(getApplicationContext(),"Item 3 is Selected",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }


//      For Card view listener
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.reportId){
          Intent intent = new Intent(Main3Activity.this,MainActivity.class);
          startActivity(intent);
        }
        else if(v.getId()==R.id.recordId){
            Intent intent = new Intent(Main3Activity.this,Main2Activity.class);
            startActivity(intent);

        } else if(v.getId()==R.id.prescriptId){
            Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
            startActivity(intent);

        } else if(v.getId()==R.id.visitId){
            Intent intent = new Intent(Main3Activity.this,Main5Activity.class);
            startActivity(intent);

        } else if(v.getId()==R.id.reminderId){
            Intent intent = new Intent(Main3Activity.this,MainActivity.class);
            startActivity(intent);

        } else if(v.getId()==R.id.scheduleId){
            Intent intent = new Intent(Main3Activity.this,Main2Activity.class);
            startActivity(intent);

        }
    }

    private class SliderLyout {
    }
}
