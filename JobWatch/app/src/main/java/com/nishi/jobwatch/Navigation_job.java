package com.nishi.jobwatch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Navigation_job extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_job);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_job, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if( id == R.id.nav_search){
            Intent i = new Intent(Navigation_job.this,sear_job.class);
            startActivity(i);
        }
        if( id == R.id.nav_save){
            Toast.makeText(this, "saved job", Toast.LENGTH_SHORT).show();
        }

        if( id == R.id.nav_applyjob){
            Toast.makeText(this, "apply job", Toast.LENGTH_SHORT).show();
        }

        if( id == R.id.nav_viewresult){
            Toast.makeText(this, "View previous test", Toast.LENGTH_SHORT).show();
        }

        if ( id == R.id.nav_testzone){
            Toast.makeText(this, "Test Zone", Toast.LENGTH_SHORT).show();
        }

        if( id == R.id.nav_testresult){
            Toast.makeText(this, "Test Result", Toast.LENGTH_SHORT).show();
        }

        if( id == R.id.nav_recruiteraction){
            Toast.makeText(this, "REcruiter Action", Toast.LENGTH_SHORT).show();
        }
        if( id == R.id.nav_setting){
            Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
        }

        if( id == R.id.nav_careerservice){
            Toast.makeText(this, "Career Service", Toast.LENGTH_SHORT).show();
        }
        if( id == R.id.nav_email){
            Toast.makeText(this, "Email", Toast.LENGTH_SHORT).show();
        }
        if( id == R.id.nav_logout){
            Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
        }




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
