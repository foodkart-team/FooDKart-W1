package com.example.foodkart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodkart.adapters.RecyclerOrder;
import com.example.foodkart.model.order;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class notifications extends AppCompatActivity {
    private String Json_URL = "http://192.168.1.3/foodkart/ordersjson.php";

    private RequestQueue requestQueue;
    private List<order> lstAnime;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        recyclerView = findViewById(R.id.recycledview2);
        lstAnime = new ArrayList<>();
        jsonrequest();


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
                        anime.setCurrent_phn_num(rest.getString("Current_phn_num"));
                        anime.setCurrent_Location(rest.getString("Current_Location"));
                        anime.setCurrent_Location(rest.getString("order_time"));


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
}
