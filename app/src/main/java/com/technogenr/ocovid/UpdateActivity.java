package com.technogenr.ocovid;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UpdateActivity extends AppCompatActivity {
    Button up1,up2,up3,up4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        up1=(Button)findViewById(R.id.up1);
        up2=(Button)findViewById(R.id.up2);
        up3=(Button)findViewById(R.id.up3);
        up4=(Button)findViewById(R.id.up4);

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
                Intent intent = new Intent(UpdateActivity.this, ThankYouActivity.class);
                // intent.putExtra("weburl", "https://twitter.com/HFWOdisha?s=03");
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
