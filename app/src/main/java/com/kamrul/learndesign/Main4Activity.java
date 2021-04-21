package com.kamrul.learndesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main4Activity extends AppCompatActivity {
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

    /*    //For hide action bar
        getSupportActionBar().hide();*/

        //for back arrow button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

         save = (Button) findViewById(R.id.save);
    }

    //for back arrow button in menu left
    @Override
    public boolean onOptionsItemSelected(MenuItem items) {
        if (items.getItemId()==android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(items);
    }


    public void save(View view){
        if(view.getId() == R.id.save) {
            Intent i = new Intent(Main4Activity.this, Main3Activity.class);
            startActivity(i);
        }
    }
}
