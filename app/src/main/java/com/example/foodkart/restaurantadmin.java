package com.example.foodkart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class restaurantadmin extends AppCompatActivity {
private Button foodbutton,orderbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantadmin);
        foodbutton=(Button) findViewById(R.id.foodbutton);
        orderbutton=(Button) findViewById(R.id.orderbutton);
        foodbutton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                foodbuttonf();
            }
        });

        orderbutton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                orderbuttonf();
            }
        });
    }

    public void orderbuttonf(){
        Intent intent=new Intent(this,notifications.class);
        startActivity(intent);
    }
    public void foodbuttonf(){
        Intent intent=new Intent(this,foodaddbyres.class);
        startActivity(intent);
    }
}


