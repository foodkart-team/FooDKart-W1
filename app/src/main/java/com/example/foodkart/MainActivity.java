package com.example.foodkart;

import android.content.Intent;  //message passed between components
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.foodkart.R;
import com.example.foodkart.drinkswindow;
import com.example.foodkart.foodwindow;
import com.example.foodkart.restaurantswindow;

    public class MainActivity extends AppCompatActivity
    {
        private Button button,button3,button4;

        @Override
        protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        button=(Button) findViewById(R.id.button);
        button3=(Button) findViewById(R.id.button3);
        button4=(Button) findViewById(R.id.button4);


        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Openactivity();

            }
        });
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Openactivity1();
            }
        });
        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Openactivity2();
            }
        });
    }

    public void Openactivity(){
        Intent intent = new Intent(this, foodwindow.class);
        startActivity(intent);

    }
    public void Openactivity1(){
        Intent intent;
        intent = new Intent (this, drinkswindow.class);
        startActivity(intent);
    }
    public void Openactivity2(){
        Intent intent= new Intent (this, restaurantswindow.class);
        startActivity(intent);
    }





        //For options items




        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.options, menu);
            return true;
        }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.logout) {

                Intent myintent = new Intent(this,logout.class);
                startActivity(myintent);
                return false;
            }

            if (id==R.id.about){
                Intent myintent = new Intent(this,aboutus.class);
                startActivity(myintent);
                return false;
            }

            return super.onOptionsItemSelected(item);
        }





        //For Button navigation




             private TextView mTextMessage;

             BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                    = new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            break;
                        case R.id.navigation_profile:
                            Intent intent1;
                            intent1 = new Intent(MainActivity.this,profile.class);
                            startActivity(intent1);
                            break;
                        case R.id.navigation_notifications:

                            Intent intent2;
                            intent2 = new Intent(MainActivity.this,notifications.class);
                            startActivity(intent2);
                            break;
                    }
                    return false;
                }
            };

    }


