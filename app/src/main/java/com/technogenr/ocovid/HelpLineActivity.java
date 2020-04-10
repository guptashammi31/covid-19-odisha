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
    pl.droidsonroids.gif.GifImageView button3,button1,button2,button4,button5,button6;
    String n;
   // DatabaseReference ref;
  //  String str="not found";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_line);
        b1=(Button)findViewById(R.id.helpb1);
        b2=(Button)findViewById(R.id.helpb2);
        button1=(pl.droidsonroids.gif.GifImageView)findViewById(R.id.call1);
        button2=(pl.droidsonroids.gif.GifImageView)findViewById(R.id.call2);
        button3=(pl.droidsonroids.gif.GifImageView)findViewById(R.id.call3);
        button4=(pl.droidsonroids.gif.GifImageView)findViewById(R.id.call4);
        button5=(pl.droidsonroids.gif.GifImageView)findViewById(R.id.call5);
        button6=(pl.droidsonroids.gif.GifImageView)findViewById(R.id.call6);

//
//
//        ref= FirebaseDatabase.getInstance().getReference("pdf");
//
//        //  ref= FirebaseDatabase.getInstance().getReference(Database_Path);
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if(dataSnapshot.exists())
//                {
//
//                    str=((String) dataSnapshot.child("link").getValue());
//
////
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError dataSnapshot) {
//
//            }
//        });
//
//
//



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n="104";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+n));
                startActivity(intent);            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n="0674-2620200";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+n));
                startActivity(intent);            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n="0674-2392115";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+n));
                startActivity(intent);            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n="1800 34567 03";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+n));
                startActivity(intent);            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n="155335";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+n));
                startActivity(intent);            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n="1075";
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
