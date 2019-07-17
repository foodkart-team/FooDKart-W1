package com.example.foodkart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class foodaddbyres extends AppCompatActivity {
private Button addfood,removefood,seelistoffood;
private TextView fprice,addfoodtext,removefoodtext;
private RequestQueue requestQueue;

private String url="http://192.168.1.7/foodkart/addfoodbyres.php";
private String url2 ="http://192.168.1.7/foodkart/deletefood.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodaddbyres);
        addfood = (Button)findViewById(R.id.addfood);
        removefood=(Button)findViewById(R.id.removefood);
        seelistoffood=(Button)findViewById(R.id.seelistoffood);
        fprice=(TextView)findViewById(R.id.fprice);
        addfoodtext=(TextView)findViewById(R.id.addfoodtext);
        removefoodtext=(TextView)findViewById(R.id.removefoodtext);
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        addfood.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               funaddfood();
            }
        });
        removefood.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funremovefood();
            }
        }));
        seelistoffood.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                funfoodlist();
            }
        });
    }

    public void funaddfood(){
        StringRequest stringRequest=new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (response.contains("empty")) {
                    Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();

                } else if (response.contains("nofood")) {
                    Toast.makeText(getApplicationContext(), "Sorry Already added", Toast.LENGTH_SHORT).show();
                } else if(response.contains("added")){
                    Toast.makeText(getApplicationContext(), "Food added successfully", Toast.LENGTH_SHORT).show();

                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>params = new HashMap<String,String>();
                params.put("item_name",addfoodtext.getText().toString());
                params.put("price",fprice.getText().toString());
                return params;
            }
        };
        requestQueue.add(stringRequest);

    }
    public void funremovefood(){
        StringRequest stringRequest2=new StringRequest(Request.Method.POST, url2, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (response.contains("lol")) {
                    Toast.makeText(getApplicationContext(), "food deleted successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Already deleted or not avialable", Toast.LENGTH_SHORT).show();

                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>params = new HashMap<String,String>();
                params.put("item_name",removefoodtext.getText().toString());

                return params;
            }
        };
        requestQueue.add(stringRequest2);

    }
    public void funfoodlist(){

        Intent intent = new Intent(getApplicationContext(),fooditems2.class);
        startActivity(intent);
    }

    }


