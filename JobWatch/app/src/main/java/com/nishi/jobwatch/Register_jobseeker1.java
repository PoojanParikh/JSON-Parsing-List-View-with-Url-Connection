package com.nishi.jobwatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Register_jobseeker1 extends AppCompatActivity {


    Button btnnext;

    Spinner seeker_industry,seeker_role,seeker_jobtype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_jobseeker1);

        btnnext = (Button)findViewById(R.id.btn_jobseeker_next);

        seeker_industry = (Spinner) findViewById(R.id.industry);
        seeker_role = (Spinner) findViewById(R.id.role);
        seeker_jobtype = (Spinner) findViewById(R.id.jobtype);

        ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(this,R.array.IndustryType,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seeker_industry.setAdapter(arrayAdapter);

        ArrayAdapter<CharSequence> arrayAdapter2=ArrayAdapter.createFromResource(this,R.array.Function,android.R.layout.simple_spinner_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seeker_role.setAdapter(arrayAdapter2);

        ArrayAdapter<CharSequence> arrayAdapter1=ArrayAdapter.createFromResource(this,R.array.Job_Type,android.R.layout.simple_spinner_item);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seeker_jobtype.setAdapter(arrayAdapter1);


        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register_jobseeker1.this,Register_jobseeker2.class);
                startActivity(i);

            }
        });

    }
}
