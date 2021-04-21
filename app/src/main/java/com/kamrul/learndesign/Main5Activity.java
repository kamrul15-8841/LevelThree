package com.kamrul.learndesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Main5Activity extends AppCompatActivity {

//    private Button goback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

      /*  //For hide action bar
        getSupportActionBar().hide();*/

        //for back arrow button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//       goback = (Button) findViewById(R.id.logoid);
        findViewById(R.id.logoid);
        findViewById(R.id.iconId);
    }

    //for back arrow button in menu left
    @Override
    public boolean onOptionsItemSelected(MenuItem items) {
        if (items.getItemId()==android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(items);
    }




    public void logoBtn(View view){
        if(view.getId() == R.id.logoid) {
            Intent i = new Intent(Main5Activity.this, Main3Activity.class);
            startActivity(i);
        }
    }
    public void iconBtn(View view){
        if(view.getId() == R.id.logoid) {
            Intent i = new Intent(Main5Activity.this, Main3Activity.class);
            startActivity(i);
        }
    }

}
