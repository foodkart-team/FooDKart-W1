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

public class orderactivity extends AppCompatActivity {
    EditText iname, noofitems , number, location ,  message;
    Button order;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderactivity);

        iname = (EditText) findViewById(R.id.Iname);
        noofitems = (EditText) findViewById(R.id.noofitems);
        number = (EditText) findViewById(R.id.phone);
        location = (EditText)findViewById(R.id.address);
        message = (EditText) findViewById(R.id.message);
        order = (Button) findViewById(R.id.order);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order();
            }
        });
    }

    public void Order(){

        StringRequest request = new StringRequest(Request.Method.POST,"http://192.168.1.7/foodkart/ordering.php",new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (response.contains("1")){
                    Toast.makeText(getApplicationContext(),"Please fill all the blocks",Toast.LENGTH_SHORT).show();
                }
                else if(response.contains("2")){
                    Toast.makeText(getApplicationContext(),"Sorry, this item isn't avialable",Toast.LENGTH_SHORT).show();
                }
                else if(response.contains("3")){
                    Toast.makeText(getApplicationContext(),"Enter Valuable number of items,should be less than 20!",Toast.LENGTH_SHORT).show();
                }
                else if(response.contains("4")){
                    Toast.makeText(getApplicationContext(),"Please Enter valid Phone number",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),orderactivity.class);
                    startActivity(intent);
                }
                else if(response.contains("5")){
                    Toast.makeText(getApplicationContext(),"Your order received successfully,You can see Here",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),notifications.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Servererror",Toast.LENGTH_SHORT).show();
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
                params.put("item_name",iname.getText().toString());
                params.put("no_of_items",noofitems.getText().toString());
                params.put("Current_phn_num",number.getText().toString());
                params.put("Current_Location",location.getText().toString());
                params.put("order_message",message.getText().toString());

                return params;
            }
        };
        requestQueue.add(request);
    }
}

