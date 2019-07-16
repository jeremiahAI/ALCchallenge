package com.jeremiah.alcchallenge;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aboutAlcButton = findViewById(R.id.about_alc_button);
        aboutAlcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAboutPage();
            }
        });

        MaterialButton myProfileButton = findViewById(R.id.my_profile_button);
        myProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToProfilePage();
            }
        });


    }

    private void goToProfilePage() {
        Intent i = new Intent(this, MyProfileActivity.class);
        startActivity(i);
    }

    private void goToAboutPage() {
        Intent i = new Intent(this, AboutAlcActivity.class);
        startActivity(i);
    }
}
