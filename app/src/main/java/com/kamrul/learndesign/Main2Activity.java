package com.kamrul.learndesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import static com.kamrul.learndesign.R.id.buttonId3;

public class Main2Activity extends AppCompatActivity {
    private Button Goto;


   /* private static final String TAG="Main3Activity";
    private DrawerLayout drawer;
    private NavigationView navigationView;
    //    private Toolbar toolbar;
    androidx.appcompat.widget.Toolbar toolbar;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       /* //For hide action bar
        getSupportActionBar().hide();*/

        Goto = (Button) findViewById(buttonId3);

        //for back arrow button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


       /* initView();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
*/

    }

/*    private void initView() {
        Log.d(TAG,"initViews: Started");
        drawer = (DrawerLayout)findViewById(R.id.drawer);
        navigationView = (NavigationView)findViewById(R.id.navigation_drawer);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
       *//* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar = (Toolbar) this.findViewById(R.id.toolbar);*//*
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);

    }*/

    //for back arrow button in menu left
    @Override
    public boolean onOptionsItemSelected(MenuItem items) {
        if (items.getItemId()==android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(items);
    }

    //For Menu bar in menu right 3dot menu item
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void clickbtn(View view){
        Intent i = new Intent(Main2Activity.this,Main3Activity.class);
        startActivity(i);
    }
}
