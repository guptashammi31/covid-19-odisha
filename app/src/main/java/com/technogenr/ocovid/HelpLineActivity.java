package com.technogenr.ocovid;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class HelpLineActivity extends AppCompatActivity {
    Button b1,b2,b3;
    pl.droidsonroids.gif.GifImageView button,button1,button2;
    String n;
    DatabaseReference ref;
    String str="not found";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_line);
        b1=(Button)findViewById(R.id.helpb1);
        b2=(Button)findViewById(R.id.helpb2);
        button=(pl.droidsonroids.gif.GifImageView)findViewById(R.id.dancer);
        button1=(pl.droidsonroids.gif.GifImageView)findViewById(R.id.b2);
        button2=(pl.droidsonroids.gif.GifImageView)findViewById(R.id.b3);


        ref= FirebaseDatabase.getInstance().getReference("pdf");

        //  ref= FirebaseDatabase.getInstance().getReference(Database_Path);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {

                    str=((String) dataSnapshot.child("link").getValue());

//
                }
            }

            @Override
            public void onCancelled(DatabaseError dataSnapshot) {

            }
        });





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n="9439994859";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+n));
                startActivity(intent);            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n="1077";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+n));
                startActivity(intent);            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n="104";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+n));
                startActivity(intent);            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelpLineActivity.this, HelpWeb1Activity.class);
                //intent.putExtra("weburl", "https://twitter.com/HFWOdisha?s=03");
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelpLineActivity.this, HelpWeb2Activity.class);
                //intent.putExtra("weburl", "https://twitter.com/HFWOdisha?s=03");
                startActivity(intent);
            }
        });
//        b3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               // Intent intent = new Intent(HelpLineActivity.this, HelpWeb3Activity.class);
//
//            }
//        });


    }

    public void call(View v)
    {
        // TODO Auto-generated method stub
        n="104";
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+n));
        startActivity(intent);


    }
}
