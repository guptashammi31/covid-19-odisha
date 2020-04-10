package com.technogenr.ocovid;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateActivity extends AppCompatActivity {
    Button up1,up2,up3,up4;
    DatabaseReference ref;
    String temp="not available";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        up1=(Button)findViewById(R.id.up1);
        up2=(Button)findViewById(R.id.up2);
        up3=(Button)findViewById(R.id.up3);
        up4=(Button)findViewById(R.id.up4);

        ref= FirebaseDatabase.getInstance().getReference("TestCovid");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    temp=((String) dataSnapshot.child("AllIndia").getValue());
                    //Tag.setText((String) dataSnapshot.child("Tag").getValue());

                }
            }
            @Override
            public void onCancelled(DatabaseError dataSnapshot) {
            }
        });


        up1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateActivity.this, Up1WebActivity.class);
                // intent.putExtra("weburl", "https://twitter.com/HFWOdisha?s=03");
                startActivity(intent);
            }
        });
        up2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateActivity.this, Up2webActivity.class);
                // intent.putExtra("weburl", "https://twitter.com/HFWOdisha?s=03");
                startActivity(intent);
            }
        });
        up3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateActivity.this, Update3Activity.class);
                intent.putExtra("link",temp);
                startActivity(intent);
            }
        });
        up4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateActivity.this, HotspotAreaActivity.class);
                // intent.putExtra("weburl", "https://twitter.com/HFWOdisha?s=03");
                startActivity(intent);
            }
        });


    }
}
