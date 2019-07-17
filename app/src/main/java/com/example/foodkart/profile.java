




package com.example.foodkart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.foodkart.model.forprofile;

public class profile extends AppCompatActivity {

    TextView  urname, uremail, uraddress, urphone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        urname = (TextView) findViewById(R.id.urname);
        uremail = (TextView) findViewById(R.id.uremail);
        urphone = (TextView) findViewById(R.id.urphone);
        uraddress = (TextView) findViewById(R.id.uraddress);

        urname.setText(forprofile.getCname());
        uremail.setText(forprofile.getCemail());
        urphone.setText(forprofile.getCphone());
        uraddress.setText(forprofile.getCaddress());


    }
}
/*
        textViewId = (TextView) findViewById(R.id.textViewId);

        buttonlogout=(Button) findViewById(R.id.buttonLogout);

        //getting the current user
        forprofile user = forsingelatonpattern.getInstance(this).getUser();

        //setting the values to the textviews
        textViewId.setText(String.valueOf(user.getId()));




        //when the user presses logout button
        //calling the logout method
        buttonlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                forsingelatonpattern.getInstance(getApplicationContext()).logout();
            }
        });
    }
}*/