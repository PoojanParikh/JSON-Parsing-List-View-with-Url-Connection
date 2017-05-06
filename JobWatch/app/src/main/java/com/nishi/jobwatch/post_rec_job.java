package com.nishi.jobwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class post_rec_job extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_rec_job);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Spinner spinner = (Spinner) findViewById(R.id.spinner5);
        ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(this,R.array.Job_Type,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> arrayAdapter1=ArrayAdapter.createFromResource(this,R.array.Job_Title,android.R.layout.simple_spinner_item);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter1);
        Spinner spinner4 = (Spinner) findViewById(R.id.spinner6);
        ArrayAdapter<CharSequence> arrayAdapter4=ArrayAdapter.createFromResource(this,R.array.IndustryType,android.R.layout.simple_spinner_item);
        arrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(arrayAdapter4);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> arrayAdapter2=ArrayAdapter.createFromResource(this,R.array.Key_Skills,android.R.layout.simple_spinner_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner7);
        ArrayAdapter<CharSequence> arrayAdapter3=ArrayAdapter.createFromResource(this,R.array.Location,android.R.layout.simple_spinner_item);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(arrayAdapter3);

    }
}
