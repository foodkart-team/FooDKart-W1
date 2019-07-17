package com.example.foodkart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Admin extends AppCompatActivity {
private Button corder;
private Button address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        corder=(Button) findViewById(R.id.Corder);
        address=(Button) findViewById(R.id.Ares);

        corder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Openactivity();

            }
        });

        address.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                addres();
            }
        });

    }

    public void Openactivity(){

        Intent intent = new Intent(this, notifications.class);
        startActivity(intent);

    }

    public void addres(){
        Intent intent = new Intent (this,admin_add_restaurant.class);
        startActivity(intent);
    }
}
