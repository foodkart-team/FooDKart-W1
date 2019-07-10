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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class frontactivity extends AppCompatActivity {
   private EditText eml,pass;
   private Button log,reg;
   RequestQueue requestQueue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontactivity);
        reg=(Button) findViewById(R.id.register);
        log=(Button) findViewById(R.id.login);
        eml=(EditText) findViewById(R.id.email);
        pass=(EditText) findViewById(R.id.password);
        requestQueue = Volley.newRequestQueue(getApplicationContext());


        reg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               Openactivity();
            }
        });



       log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login();
            }
        });
    }
    public void login(){
        StringRequest request = new StringRequest(Request.Method.POST,"http://192.168.1.3/foodkart/login.php",new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (response.contains("2")){
                   startActivity(new Intent(getApplicationContext(),MainActivity.class));

                }
                else if(response.contains("3")){
                    startActivity(new Intent(getApplicationContext(),restaurantswindow.class));
                }

                else if(response.contains("1")){
                    startActivity(new Intent(getApplicationContext(),Admin.class));
                }

                else{
                    Toast.makeText(getApplicationContext(),"Wrong email or password",Toast.LENGTH_SHORT).show();
                }
            }
        },new Response.ErrorListener(){



            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>params = new HashMap<String,String>();
                params.put("email",eml.getText().toString());
                params.put("password",pass.getText().toString());

                return params;
            }
        };
        requestQueue.add(request);
    }
    public void Openactivity(){
        Intent intent = new Intent(this, register.class);
        startActivity(intent);

    }

}
