package com.rehan.androidinterviewquestionsandanswers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.rehan.androidinterviewquestionsandanswers.R;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    ExpandableListView expandableListView;
    List<String> questions;
    HashMap<String, List<String>> answers;
    ExpandableListAdapter expandableListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView=findViewById(R.id.expandableListView);
        fillData();
        expandableListAdapter=new MyExpandableListAdapter(this,questions,answers);
        expandableListView.setAdapter(expandableListAdapter);

        drawerLayout=findViewById(R.id.drawerLayout);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Android Interview FAQ");
        actionBarDrawerToggle=new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView=findViewById(R.id.navigationView);
        navigationView.bringToFront();
        navigationView.setCheckedItem(R.id.nav_home);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_home:
                        Toast.makeText(MainActivity.this, "This is the Home Page of this app.", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_download_app:
                        String download_app="https://play.google.com/store/apps/details?id=com.rehan.interviewcrackathon";
                        Uri uri_download= Uri.parse(download_app);
                        Intent rate=new Intent(Intent.ACTION_VIEW, uri_download);
                        try {
                            startActivity(rate);
                        } catch (Exception e) {
                            Toast.makeText(MainActivity.this, "Unable to open", Toast.LENGTH_LONG).show();
                        }
                        break;

                    case R.id.nav_about_developer:
                        Intent intent1=new Intent(MainActivity.this, AboutDeveloper.class);
                        startActivity(intent1);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_rate_app:
                        String app_link="https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName();
                        Uri uri= Uri.parse(app_link);
                        Intent intent2=new Intent(Intent.ACTION_VIEW, uri);
                        try {
                            startActivity(intent2);
                        } catch (Exception e) {
                            Toast.makeText(MainActivity.this, "Unable to open", Toast.LENGTH_LONG).show();
                        }
                        break;

                    case R.id.nav_share_app:
                        try {
                            Intent share=new Intent(Intent.ACTION_SEND);
                            share.setType("text/plain");
                            share.putExtra(Intent.EXTRA_SUBJECT, "Android Interview FAQ App" + "\n");
                            share.putExtra(Intent.EXTRA_TEXT, "Download this app from Google PlayStore by clicking this below link. Please do share this app info with your friends and tell them to give feedback about this app. Your feedback is mostly appreciated and delighted to hear." + "\n\n" + "https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName() + "\n\n" + "Best of Luck for your Interview!!!");
                            startActivity(Intent.createChooser(share, "Share App Info With :"));
                        } catch (Exception e) {
                            Toast.makeText(MainActivity.this, "Unable to share", Toast.LENGTH_LONG).show();
                        }
                        break;
                }
                return true;
            }
        });
    }

    public void fillData()
    {
        questions=new ArrayList<>();
        answers=new HashMap<>();

        questions.add(getString(R.string.android_q1));
        questions.add(getString(R.string.android_q2));
        questions.add(getString(R.string.android_q3));
        questions.add(getString(R.string.android_q4));
        questions.add(getString(R.string.android_q5));
        questions.add(getString(R.string.android_q6));
        questions.add(getString(R.string.android_q7));
        questions.add(getString(R.string.android_q8));
        questions.add(getString(R.string.android_q9));
        questions.add(getString(R.string.android_q10));
        questions.add(getString(R.string.android_q11));
        questions.add(getString(R.string.android_q12));
        questions.add(getString(R.string.android_q13));
        questions.add(getString(R.string.android_q14));
        questions.add(getString(R.string.android_q15));
        questions.add(getString(R.string.android_q16));
        questions.add(getString(R.string.android_q17));
        questions.add(getString(R.string.android_q18));
        questions.add(getString(R.string.android_q19));
        questions.add(getString(R.string.android_q20));
        questions.add(getString(R.string.android_q21));
        questions.add(getString(R.string.android_q22));
        questions.add(getString(R.string.android_q23));
        questions.add(getString(R.string.android_q24));
        questions.add(getString(R.string.android_q25));
        questions.add(getString(R.string.android_q26));
        questions.add(getString(R.string.android_q27));
        questions.add(getString(R.string.android_q28));
        questions.add(getString(R.string.android_q29));
        questions.add(getString(R.string.android_q30));
        questions.add(getString(R.string.android_q31));
        questions.add(getString(R.string.android_q32));
        questions.add(getString(R.string.android_q33));
        questions.add(getString(R.string.android_q34));
        questions.add(getString(R.string.android_q35));
        questions.add(getString(R.string.android_q36));
        questions.add(getString(R.string.android_q37));
        questions.add(getString(R.string.android_q38));
        questions.add(getString(R.string.android_q39));
        questions.add(getString(R.string.android_q40));
        questions.add(getString(R.string.android_q41));
        questions.add(getString(R.string.android_q42));
        questions.add(getString(R.string.android_q43));
        questions.add(getString(R.string.android_q44));
        questions.add(getString(R.string.android_q45));
        questions.add(getString(R.string.android_q46));
        questions.add(getString(R.string.android_q47));
        questions.add(getString(R.string.android_q48));
        questions.add(getString(R.string.android_q49));
        questions.add(getString(R.string.android_q50));

        List<String> answer1=new ArrayList<>();
        List<String> answer2=new ArrayList<>();
        List<String> answer3=new ArrayList<>();
        List<String> answer4=new ArrayList<>();
        List<String> answer5=new ArrayList<>();
        List<String> answer6=new ArrayList<>();
        List<String> answer7=new ArrayList<>();
        List<String> answer8=new ArrayList<>();
        List<String> answer9=new ArrayList<>();
        List<String> answer10=new ArrayList<>();
        List<String> answer11=new ArrayList<>();
        List<String> answer12=new ArrayList<>();
        List<String> answer13=new ArrayList<>();
        List<String> answer14=new ArrayList<>();
        List<String> answer15=new ArrayList<>();
        List<String> answer16=new ArrayList<>();
        List<String> answer17=new ArrayList<>();
        List<String> answer18=new ArrayList<>();
        List<String> answer19=new ArrayList<>();
        List<String> answer20=new ArrayList<>();
        List<String> answer21=new ArrayList<>();
        List<String> answer22=new ArrayList<>();
        List<String> answer23=new ArrayList<>();
        List<String> answer24=new ArrayList<>();
        List<String> answer25=new ArrayList<>();
        List<String> answer26=new ArrayList<>();
        List<String> answer27=new ArrayList<>();
        List<String> answer28=new ArrayList<>();
        List<String> answer29=new ArrayList<>();
        List<String> answer30=new ArrayList<>();
        List<String> answer31=new ArrayList<>();
        List<String> answer32=new ArrayList<>();
        List<String> answer33=new ArrayList<>();
        List<String> answer34=new ArrayList<>();
        List<String> answer35=new ArrayList<>();
        List<String> answer36=new ArrayList<>();
        List<String> answer37=new ArrayList<>();
        List<String> answer38=new ArrayList<>();
        List<String> answer39=new ArrayList<>();
        List<String> answer40=new ArrayList<>();
        List<String> answer41=new ArrayList<>();
        List<String> answer42=new ArrayList<>();
        List<String> answer43=new ArrayList<>();
        List<String> answer44=new ArrayList<>();
        List<String> answer45=new ArrayList<>();
        List<String> answer46=new ArrayList<>();
        List<String> answer47=new ArrayList<>();
        List<String> answer48=new ArrayList<>();
        List<String> answer49=new ArrayList<>();
        List<String> answer50=new ArrayList<>();

        answer1.add(getString(R.string.android_a1));
        answer2.add(getString(R.string.android_a2));
        answer3.add(getString(R.string.android_a3));
        answer4.add(getString(R.string.android_a4));
        answer5.add(getString(R.string.android_a5));
        answer6.add(getString(R.string.android_a6));
        answer7.add(getString(R.string.android_a7));
        answer8.add(getString(R.string.android_a8));
        answer9.add(getString(R.string.android_a9));
        answer10.add(getString(R.string.android_a10));
        answer11.add(getString(R.string.android_a11));
        answer12.add(getString(R.string.android_a12));
        answer13.add(getString(R.string.android_a13));
        answer14.add(getString(R.string.android_a14));
        answer15.add(getString(R.string.android_a15));
        answer16.add(getString(R.string.android_a16));
        answer17.add(getString(R.string.android_a17));
        answer18.add(getString(R.string.android_a18));
        answer19.add(getString(R.string.android_a19));
        answer20.add(getString(R.string.android_a20));
        answer21.add(getString(R.string.android_a21));
        answer22.add(getString(R.string.android_a22));
        answer23.add(getString(R.string.android_a23));
        answer24.add(getString(R.string.android_a24));
        answer25.add(getString(R.string.android_a25));
        answer26.add(getString(R.string.android_a26));
        answer27.add(getString(R.string.android_a27));
        answer28.add(getString(R.string.android_a28));
        answer29.add(getString(R.string.android_a29));
        answer30.add(getString(R.string.android_a30));
        answer31.add(getString(R.string.android_a31));
        answer32.add(getString(R.string.android_a32));
        answer33.add(getString(R.string.android_a33));
        answer34.add(getString(R.string.android_a34));
        answer35.add(getString(R.string.android_a35));
        answer36.add(getString(R.string.android_a36));
        answer37.add(getString(R.string.android_a37));
        answer38.add(getString(R.string.android_a38));
        answer39.add(getString(R.string.android_a39));
        answer40.add(getString(R.string.android_a40));
        answer41.add(getString(R.string.android_a41));
        answer42.add(getString(R.string.android_a42));
        answer43.add(getString(R.string.android_a43));
        answer44.add(getString(R.string.android_a44));
        answer45.add(getString(R.string.android_a45));
        answer46.add(getString(R.string.android_a46));
        answer47.add(getString(R.string.android_a47));
        answer48.add(getString(R.string.android_a48));
        answer49.add(getString(R.string.android_a49));
        answer50.add(getString(R.string.android_a50));

        answers.put(questions.get(0), answer1);
        answers.put(questions.get(1), answer2);
        answers.put(questions.get(2), answer3);
        answers.put(questions.get(3), answer4);
        answers.put(questions.get(4), answer5);
        answers.put(questions.get(5), answer6);
        answers.put(questions.get(6), answer7);
        answers.put(questions.get(7), answer8);
        answers.put(questions.get(8), answer9);
        answers.put(questions.get(9), answer10);
        answers.put(questions.get(10), answer11);
        answers.put(questions.get(11), answer12);
        answers.put(questions.get(12), answer13);
        answers.put(questions.get(13), answer14);
        answers.put(questions.get(14), answer15);
        answers.put(questions.get(15), answer16);
        answers.put(questions.get(16), answer17);
        answers.put(questions.get(17), answer18);
        answers.put(questions.get(18), answer19);
        answers.put(questions.get(19), answer20);
        answers.put(questions.get(20), answer21);
        answers.put(questions.get(21), answer22);
        answers.put(questions.get(22), answer23);
        answers.put(questions.get(23), answer24);
        answers.put(questions.get(24), answer25);
        answers.put(questions.get(25), answer26);
        answers.put(questions.get(26), answer27);
        answers.put(questions.get(27), answer28);
        answers.put(questions.get(28), answer29);
        answers.put(questions.get(29), answer30);
        answers.put(questions.get(30), answer31);
        answers.put(questions.get(31), answer32);
        answers.put(questions.get(32), answer33);
        answers.put(questions.get(33), answer34);
        answers.put(questions.get(34), answer35);
        answers.put(questions.get(35), answer36);
        answers.put(questions.get(36), answer37);
        answers.put(questions.get(37), answer38);
        answers.put(questions.get(38), answer39);
        answers.put(questions.get(39), answer40);
        answers.put(questions.get(40), answer41);
        answers.put(questions.get(41), answer42);
        answers.put(questions.get(42), answer43);
        answers.put(questions.get(43), answer44);
        answers.put(questions.get(44), answer45);
        answers.put(questions.get(45), answer46);
        answers.put(questions.get(46), answer47);
        answers.put(questions.get(47), answer48);
        answers.put(questions.get(48), answer49);
        answers.put(questions.get(49), answer50);

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder obj=new AlertDialog.Builder(MainActivity.this);

        obj.setTitle("This Application Says:");
        obj.setMessage("Do you really want to close this app?");
        obj.setCancelable(true);

        obj.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        obj.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog=obj.create();
        alertDialog.show();
    }
}
