package com.nishi.jobwatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register_Recruiter1 extends AppCompatActivity {
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__recruiter1);
        next = (Button)findViewById(R.id.btnnextrecruiter);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register_Recruiter1.this,Register_Recruiter2.class);
                startActivity(i);
            }
        });
    }
}
