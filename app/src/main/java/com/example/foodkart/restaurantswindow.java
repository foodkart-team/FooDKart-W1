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
import com.example.foodkart.adapters.Recycler;
import com.example.foodkart.model.Anime;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class restaurantswindow extends AppCompatActivity {
private String Json_URL = "http://192.168.1.7/foodkart/addres.php";
private RequestQueue requestQueue;
private List<Anime> lstAnime;
private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantswindow);
        recyclerView = findViewById(R.id.recycleviewid);
        lstAnime = new ArrayList<>();
        jsonrequest();

    }

    private void jsonrequest() {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,Json_URL,null,new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {

                try{
                    JSONArray res = response.getJSONArray("restaurant");
                for (int i =0; i<res.length(); i++){

                    JSONObject rest = res.getJSONObject(i);
                        Anime anime = new Anime();
                        anime.setR_name(rest.getString("r_name"));
                        anime.setR_address(rest.getString("r_address"));
                        anime.setImage(rest.getString("image"));
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

    private void setuprecyclerview(List<Anime>lstAnime) {
        Recycler my = new Recycler(this,lstAnime);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(my);
    }
}
