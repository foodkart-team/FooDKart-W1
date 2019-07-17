package com.example.foodkart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodkart.model.forprofile;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class frontactivity extends AppCompatActivity {
    private EditText eml, pass;
    private Button log, reg;
    RequestQueue requestQueue;
    private List<forprofile> profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontactivity);
        reg = (Button) findViewById(R.id.register);
        log = (Button) findViewById(R.id.login);
        eml = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        profile = new ArrayList<>();


        reg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Openactivity();
            }
        });

        log.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View view) {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "http://192.168.1.7/foodkart/login.php", null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray res = response.getJSONArray("register");
                            for (int i = 0; i < reg.length(); i++) {
                                JSONObject rest = res.getJSONObject(i);
                                forprofile anime = new forprofile();
                                anime.setCname(rest.getString("Customer_name"));
                                anime.setCemail(rest.getString("Customer_email"));
                                anime.setCphone(rest.getString("Phone_number"));
                                anime.setCaddress(rest.getString("Address"));
                                profile.add(anime);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                requestQueue.add(jsonObjectRequest);
                log.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        StringRequest request = new StringRequest(Request.Method.POST,"http://192.168.1.7/foodkart/login.php",new Response.Listener<String>(){

                            @Override
                            public void onResponse(String response) {
                                if (response.contains("2")) {
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                                } else if (response.contains("3")) {
                                    startActivity(new Intent(getApplicationContext(), restaurantadmin.class));
                                } else if (response.contains("1")) {
                                    startActivity(new Intent(getApplicationContext(), Admin.class));
                                } else {
                                    Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }, new Response.ErrorListener(){

                            /**
                             * Callback method that an error has been occurred with the provided error code and optional
                             * user-readable message.
                             *
                             * @param error
                             */
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }){
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String>  params = new HashMap<String, String>();
                                params.put("email", eml.getText().toString());
                                params.put("password", pass.getText().toString());
                                return params;

                            }
                        };
                        requestQueue.add(request);
                    }
                });
            }
        });



    }
    public void Openactivity(){
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }
}
    /**private void jsonrequest() {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "http://192.168.1.7/foodkart/login.php", null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray res = response.getJSONArray("register");
                    for (int i = 0; i < res.length(); i++) {

                        JSONObject rest = res.getJSONObject(i);
                        forprofile anime = new forprofile();
                        anime.setCname(rest.getString("Customer_name"));
                        anime.setCemail(rest.getString("Customer_email"));
                        anime.setCphone(rest.getString("Phone_number"));
                        anime.setCaddress(rest.getString("Address"));
                        profile.add(anime);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);

        public void login(){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.1.7/foodkart/login.php", new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    if (response.contains("2")) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));

                    } else if (response.contains("3")) {
                        startActivity(new Intent(getApplicationContext(), restaurantadmin.class));
                    } else if (response.contains("1")) {
                        startActivity(new Intent(getApplicationContext(), Admin.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {


                @Override
                public void onErrorResponse(VolleyError error) {
                }
            }) {

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("email", eml.getText().toString());
                    params.put("password", pass.getText().toString());

                    return params;
                }
            };
            requestQueue.add(stringRequest);
        }
    }
    public void Openactivity(){
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }
    }
     */