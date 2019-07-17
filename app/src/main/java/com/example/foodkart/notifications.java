package com.example.foodkart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.example.foodkart.adapters.RecyclerOrder;
import com.example.foodkart.model.order;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class notifications extends AppCompatActivity {
    private String Json_URL = "http://192.168.1.7/foodkart/ordersjson.php";
    private String url2 = "http://192.168.1.7/foodkart/deleteorder.php";


    private List<order> lstAnime;
    private RecyclerView recyclerView;
    private EditText ordertext;
    private Button removeorder;
    private RequestQueue requestQueue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        recyclerView = findViewById(R.id.recycledview2);
        removeorder=(Button) findViewById(R.id.removeorder);
        ordertext=(EditText) findViewById(R.id.ordernumtext);
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        lstAnime = new ArrayList<>();
        jsonrequest();
        removeorder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                removeorders();
            }
        });
    }

    private void jsonrequest() {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,Json_URL,null,new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {

                try{
                    JSONArray res = response.getJSONArray("order");
                    for (int i =0; i<res.length(); i++){

                        JSONObject rest = res.getJSONObject(i);
                        order anime = new order();
                        anime.setItem_name(rest.getString("item_name"));
                        anime.setNo_of_items(rest.getString("no_of_items"));
                        anime.setOrder_message(rest.getString("order_message"));
                        anime.setCurrent_phn_num(rest.getLong("Current_phn_num"));
                        anime.setCurrent_Location(rest.getString("Current_Location"));
                        anime.setOrder_time(rest.getString("order_time"));
                        anime.setOrder_number(rest.getString("Order_number"));



                        lstAnime.add(anime);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                setuprecyclerview(lstAnime);
            }
        },new Response.ErrorListener(){


            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);

    }


    private void setuprecyclerview(List<order>lstAnime) {
        RecyclerOrder my = new RecyclerOrder(this,lstAnime);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(my);
    }
    public void removeorders(){
        StringRequest stringRequest2=new StringRequest(Request.Method.POST, url2, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (response.contains("lol")) {
                    Toast.makeText(getApplicationContext(), "order deleted successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),notifications.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Already deleted or not avialable or empty", Toast.LENGTH_SHORT).show();

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
                params.put("Order_number",ordertext.getText().toString());

                return params;
            }
        };
        requestQueue.add(stringRequest2);

    }
}
