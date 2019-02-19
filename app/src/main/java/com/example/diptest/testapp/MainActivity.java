package com.example.diptest.testapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();

        TextView tv = (TextView) findViewById(R.id.tetxtview);
        tv.setText(action + "\n\n\n");
        if(data!= null) {
            String text = data.getQueryParameter("key");

            tv.setText("TOTAL CHAR:" + text.length() + "\n\n" + text);
        }


        findViewById(R.id.launchapp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.microsoft.d365.fs.mobile");
                if (launchIntent != null) {
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }
            }
        });
    }
}
