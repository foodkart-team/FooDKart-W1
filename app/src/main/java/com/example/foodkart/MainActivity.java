package com.example.foodkart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.foodkart.R;
import com.example.foodkart.drinkswindow;
import com.example.foodkart.foodwindow;
import com.example.foodkart.restaurantswindow;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button3;
    private Button button4;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}
