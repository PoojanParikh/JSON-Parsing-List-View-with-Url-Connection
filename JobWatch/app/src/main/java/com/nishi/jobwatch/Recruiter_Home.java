package com.nishi.jobwatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Recruiter_Home extends AppCompatActivity implements View.OnClickListener{
    private Button resume_search,jobseeker_detail,post_job,feedback,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruiter_home);

        resume_search = (Button)findViewById(R.id.btn_search);
        jobseeker_detail = (Button)findViewById(R.id.btn_jobseeker_detail);
        post_job = (Button)findViewById(R.id.btn_post_job);
        feedback = (Button)findViewById(R.id.btn_feedback);
        logout = (Button)findViewById(R.id.btn_logout);


        resume_search.setOnClickListener(this);
        jobseeker_detail.setOnClickListener(this);
        post_job.setOnClickListener(this);
        feedback.setOnClickListener(this);
        logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_search:
                Toast.makeText(this, "Searching...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_jobseeker_detail:
                Toast.makeText(this, "jobseeker details...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_post_job:
                Toast.makeText(this, "Job Post...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_feedback:
                Toast.makeText(this, "Feedback...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_logout:
                Intent i =new Intent(Recruiter_Home.this,Login.class);
                startActivity(i);
//                Toast.makeText(this, "Logout...", Toast.LENGTH_SHORT).show();
                break;
        }


    }
}
