package com.poh.base;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.ValueEventListener;

public class Hero_BlueBeard extends AppCompatActivity {
    Firebase myFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_layout);

        final TextView heroText = (TextView) findViewById(R.id.heroText);

        Firebase.setAndroidContext(getApplicationContext());

        myFirebase = new Firebase("https://planet-of-heroes-base.firebaseio.com/Text");

        myFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String myChildText = dataSnapshot.getValue(String.class);
                heroText.setText(myChildText);
            }

            @Override
            public void onCancelled(com.firebase.client.FirebaseError firebaseError) {
                heroText.setText("Error found");
            }
        });
    }


    public void backBtnClick(View v){
        this.finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        }, 0);
    }
}