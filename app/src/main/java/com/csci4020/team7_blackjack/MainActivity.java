package com.csci4020.team7_blackjack;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.play_button);
        b.setOnClickListener(new View.OnClickListener() { //Opens up the game activity.
            @Override
            public void onClick(View view) {              //explicit intent
                Intent intent = new Intent(
                        getApplicationContext(),
                        GameActivity.class
                );
                startActivity(intent);
            }
        });

        b = (Button) findViewById(R.id.more_button);
        b.setOnClickListener(new View.OnClickListener() {   //Opens up the blackjack wikipedia page
            @Override                                       //in the default browser.
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.pagat.com/banking/blackjack.html"); //This website was used to base the rules.
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);                // so might as well give them some ad revenue.
                startActivity(intent);
            }
        });

        b = (Button) findViewById(R.id.about_button);
        b.setOnClickListener(new View.OnClickListener() {   //Opens up the about activity
            @Override
            public void onClick(View view) {                //explicit intent
                Intent intent = new Intent(
                        getApplicationContext(),
                        AboutActivity.class
                );
                startActivity(intent);
            }
        });
    }
}
