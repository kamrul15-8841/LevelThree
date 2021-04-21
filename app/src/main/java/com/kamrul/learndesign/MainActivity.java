package com.kamrul.learndesign;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.kamrul.learndesign.R.id.buttonId;
import static com.kamrul.learndesign.R.id.buttonId2;
import static com.kamrul.learndesign.R.id.buttonId3;
import static com.kamrul.learndesign.R.id.textViewId;


public class MainActivity extends AppCompatActivity {
    private Button login,logout,Goto;
    private TextView showMe;


//    public void clickbtn(View view){
//        Log.i("this","clickbtn: This is a message");
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        //For hide action bar
        getSupportActionBar().hide();
*/

        //for back arrow button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        login = (Button) findViewById(buttonId);
        logout = (Button) findViewById(buttonId2);
        Goto = (Button) findViewById(buttonId3);
        showMe = (TextView) findViewById(textViewId);



    }

    //for back arrow button in menu left
    @Override
    public boolean onOptionsItemSelected(MenuItem items) {
        if (items.getItemId()==android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(items);
    }


    public void clickbtn(View v){
        if(v.getId() == R.id.buttonId){
//            Toast toast = Toast.makeText(MainActivity.this,"Login button is clicked",Toast.LENGTH_SHORT);
//            toast.setGravity(Gravity.CENTER,0,0);
//            toast.show();

            showMe.setText("Login button is clicked");

            Log.i("this","clickbtn: Login button is clicked");

//            Custom Toast
            LayoutInflater inflater = getLayoutInflater();
            View customView = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.customId));
            Toast toast = Toast.makeText(MainActivity.this,"Login button is clicked",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.setView(customView);
            toast.show();
        }
        else if(v.getId() == R.id.buttonId2){
            showMe.setText("Logout button is clicked");

            Toast toast = Toast.makeText(MainActivity.this,"Logout button is clicked",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();

            Log.i("this","clickbtn: Logout button is clicked");
        }
    }
    public void clickbtn2(View view){
        Intent i = new Intent(MainActivity.this,Main3Activity.class);
        startActivity(i);
    }
}
