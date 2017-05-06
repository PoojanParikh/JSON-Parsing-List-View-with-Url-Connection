package com.nishi.jobwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class sear_job extends AppCompatActivity {
    Spinner jobtype,jobtitle,keyskill,location,industry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sear_job);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        jobtype = (Spinner) findViewById(R.id.jobtype);
        jobtitle = (Spinner) findViewById(R.id.jobtitle);
        keyskill = (Spinner) findViewById(R.id.keyskill);
        location = (Spinner) findViewById(R.id.location);
        industry = (Spinner) findViewById(R.id.industry);



        ArrayAdapter<CharSequence> arrayAdapterkeyskill=ArrayAdapter.createFromResource(this,R.array.Key_Skills,android.R.layout.simple_spinner_item);
        arrayAdapterkeyskill.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        keyskill.setAdapter(arrayAdapterkeyskill);


        ArrayAdapter<CharSequence> arrayAdaptertitle=ArrayAdapter.createFromResource(this,R.array.Job_Title,android.R.layout.simple_spinner_item);
        arrayAdaptertitle.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jobtitle.setAdapter(arrayAdaptertitle);



        ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(this,R.array.Location,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        location.setAdapter(arrayAdapter);


        ArrayAdapter<CharSequence> arrayAdapter2=ArrayAdapter.createFromResource(this,R.array.IndustryType,android.R.layout.simple_spinner_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        industry.setAdapter(arrayAdapter2);

        ArrayAdapter<CharSequence> arrayAdapter3=ArrayAdapter.createFromResource(this,R.array.Job_Type,android.R.layout.simple_spinner_item);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jobtype.setAdapter(arrayAdapter3);
    }
}
