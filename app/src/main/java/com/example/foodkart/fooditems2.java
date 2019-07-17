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
import com.example.foodkart.adapters.Recyclerfood;
import com.example.foodkart.model.foodaneme;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class fooditems2 extends AppCompatActivity {
    private String Json_URL = "http://192.168.1.7/foodkart/foodlist.php";
    private RequestQueue requestQueue;
    private List<foodaneme> lstAnime2;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fooditems);
        recyclerView = findViewById(R.id.recycleviewid2);
        lstAnime2 = new ArrayList<>();
        jsonrequest();

    }

    private void jsonrequest() {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,Json_URL,null,new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {

                try{
                    JSONArray res = response.getJSONArray("foodname");
                    for (int i =0; i<res.length(); i++){

                        JSONObject rest = res.getJSONObject(i);
                        foodaneme anime = new foodaneme();
                        anime.setFood_image(rest.getString("item photo"));
                        anime.setItem_name(rest.getString("item_name"));
                        anime.setPrice(rest.getString("price"));
                        lstAnime2.add(anime);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                setuprecyclerview(lstAnime2);
            }
        },new Response.ErrorListener(){


            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);

    }
    private void setuprecyclerview(List<foodaneme>lstAnime) {
        Recyclerfood my = new Recyclerfood(this,lstAnime);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(my);
    }
}
