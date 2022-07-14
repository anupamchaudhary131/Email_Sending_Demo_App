package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnComposeEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnComposeEmail = (Button)findViewById(R.id.btnComposeEmail);

        btnComposeEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendEmail();
            }
        });
    }

    private void sendEmail()
    {
        Log.v("Sending Email Logs", " ");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_VIEW);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Your Message will display here");

        try{
            startActivity(Intent.createChooser(emailIntent, "Sending emil from Application"));
            finish();
            Log.v("Finishing the process", "");
        }
        catch(android.content.ActivityNotFoundException e)
        {
            Toast.makeText(MainActivity.this, "There is no default application found in user device", Toast.LENGTH_LONG).show();
        }

    }

}