package com.technogenr.ocovid;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ComplainActivity extends AppCompatActivity {
    EditText sub,mess;
    Button button11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
        sub = (EditText) findViewById(R.id.title);
        mess = (EditText) findViewById(R.id.edit_text);
        button11 = (Button) findViewById(R.id.btn);

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = sub.getText().toString().trim();
                String message = mess.getText().toString().trim();

                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "orhealth@nic.in", null));
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));

            }
        });
    }}
