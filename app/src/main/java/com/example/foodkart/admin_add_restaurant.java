package com.example.foodkart;

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

public class admin_add_restaurant extends AppCompatActivity {
    private EditText r_name, r_address , r_phone, r_email ,  r_password;
    private Button adds;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_restaurant);

        r_name = (EditText) findViewById(R.id.r_name);
        r_address = (EditText) findViewById(R.id.r_address);
        r_phone = (EditText) findViewById(R.id.r_phone);
        r_email = (EditText)findViewById(R.id.r_email);
        r_password = (EditText) findViewById(R.id.r_password);
        adds = (Button) findViewById(R.id.adds);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        adds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addres();
            }
        });
    }

    public void addres(){

        StringRequest request = new StringRequest(Request.Method.POST,"http://192.168.1.7/foodkart/registerres.php",new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                if (response.contains("1")){
                    Toast.makeText(getApplicationContext(),"Please fill all the blocks",Toast.LENGTH_SHORT).show();

                }
                else if(response.contains("exist")){
                    Toast.makeText(getApplicationContext(),"Sorry, already added",Toast.LENGTH_SHORT).show();
                }
                else if(response.contains("added")){
                    Toast.makeText(getApplicationContext(),"Restaurant successfully added",Toast.LENGTH_SHORT).show();
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
                params.put("r_name",r_name.getText().toString());
                params.put("r_address",r_address.getText().toString());
                params.put("r_email",r_email.getText().toString());
                params.put("r_phn_num",r_phone.getText().toString());
                params.put("r_password",r_password.getText().toString());

                return params;
            }
        };
        requestQueue.add(request);
    }


}

