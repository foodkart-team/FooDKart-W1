
package com.example.foodkart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class register extends AppCompatActivity {
    Button regi;
    EditText name,email,password,phone,address;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        regi = (Button) findViewById(R.id.register);
        name = (EditText) findViewById(R.id.name);
        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);
        phone =(EditText) findViewById(R.id.phone);
        address = (EditText) findViewById(R.id.address);
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });


    }

    public void register(){
        StringRequest request = new StringRequest(Request.Method.POST,"http://192.168.1.3/foodkart/customerregister.php",new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (response.contains("1")){
                    Toast.makeText(getApplicationContext(),"Fill all the Fields",Toast.LENGTH_SHORT).show();
                }
                else if(response.contains("2")){
                Toast.makeText(getApplicationContext(),"This email is already registered",Toast.LENGTH_SHORT).show();
                }
                else if(response.contains("3")){
                    Toast.makeText(getApplicationContext(),"Successfully registered",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please check the server connection",Toast.LENGTH_SHORT).show();
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

                params.put("Customer_email",email.getText().toString());
                params.put("Customer_password",password.getText().toString());
                params.put("Phone_number",phone.getText().toString());
                params.put("Address",address.getText().toString());
                params.put("Customer_name",name.getText().toString());

                return params;
            }
        };
        requestQueue.add(request);
    }
}





















