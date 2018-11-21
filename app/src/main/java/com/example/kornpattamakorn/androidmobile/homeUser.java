package com.example.kornpattamakorn.androidmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class homeUser extends AppCompatActivity {
    private ImageButton booking;
    private ImageButton checkqueue;
    private ImageButton editprofile;
    private ImageButton Detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);
        booking = findViewById(R.id.booking);
        checkqueue = findViewById(R.id.checkqueue);
        editprofile = findViewById(R.id.btnuser);
        Detail = findViewById(R.id.detail);
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeUser.this,booking.class);
                startActivity(intent);
            }
        });
        checkqueue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeUser.this,checkqueueUser.class);
                startActivity(intent);
            }
        });
        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeUser.this,editProfile.class);
                startActivity(intent);
            }
        });
        Detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeUser.this,Detail.class);
                startActivity(intent);
            }
        });
    }
}
