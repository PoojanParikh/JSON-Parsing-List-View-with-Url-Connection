package com.nishi.jobwatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private EditText edtpass;
    private ImageView showpassword;
    private int passwordNotVisible = 1;
    private TextView forgotpassword;
    private Button recruiter,signin,jobseeker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtpass = (EditText)findViewById(R.id.edtpass);
        showpassword = (ImageView) findViewById(R.id.showpassword);
        forgotpassword = (TextView)findViewById(R.id.forgetpassword);
        recruiter = (Button)findViewById(R.id.recruiter);
        signin = (Button)findViewById(R.id.signin);
        jobseeker = (Button) findViewById(R.id.jobseeker);

        //show or hide password ( eye )
        showpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passwordNotVisible ==1) {
                    edtpass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordNotVisible = 0;
                }else{
                    edtpass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordNotVisible = 1;
                }
                edtpass.setSelection(edtpass.length());

            }
        });

        //forgot password
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this,Forgot_pwd.class);
                startActivity(i);

            }
        });

        //Recruiter_Home
        recruiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Login.this,Register_Recruiter1.class);
                startActivity(i);
            }
        });


        //Signin
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Login.this,Navigation_job.class);
                startActivity(i);
            }
        });

        //jobseeker
        jobseeker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this,Register_jobseeker1.class);
                startActivity(i);
            }
        });





    }
}
