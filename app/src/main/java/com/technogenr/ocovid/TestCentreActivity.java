package com.technogenr.ocovid;

import android.app.ProgressDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCentreActivity extends AppCompatActivity {
    // Creating DatabaseReference.
    DatabaseReference databaseReference;

    private String url;
    String n;
    // Creating RecyclerView.
    RecyclerView recyclerView;

    // Creating RecyclerView.Adapter.
    RecyclerView.Adapter adapter;

    // Creating Progress dialog
    ProgressDialog progressDialog;

    // Creating List of ImageUploadInfo class.
    List<hospitalDetails> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_centre);

        // Assign id to RecyclerView.
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // Setting RecyclerView size true.
        recyclerView.setHasFixedSize(true);

        // Setting RecyclerView layout as LinearLayout.
        recyclerView.setLayoutManager(new LinearLayoutManager(TestCentreActivity.this));

        // Assign activity this to progress dialog.
        progressDialog = new ProgressDialog(TestCentreActivity.this);

        // Setting up message in Progress dialog.
        progressDialog.setMessage("Loading Information .");

        // Showing progress dialog.
        progressDialog.show();

        // Setting up Firebase image upload folder path in databaseReference.
        // The path is already defined in MainActivity.
        databaseReference = FirebaseDatabase.getInstance().getReference().child("hospital_details");

        // Adding Add Value Event Listener to databaseReference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                    hospitalDetails imageUploadInfo = postSnapshot.getValue(hospitalDetails.class);

                    list.add(imageUploadInfo);
                }
//to reverse the Data to dispaly into th screen
                Collections.reverse(list);

                adapter = new RecyclerViewCont(getApplicationContext(), list);

                recyclerView.setAdapter(adapter);
//
//                movieList.clear();
//                movieList.addAll(items);
//
//                // refreshing recycler view
//                mAdapter.notifyDataSetChanged()
//;
                // Hiding the progress dialog.
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                // Hiding the progress dialog.
                progressDialog.dismiss();

            }
        });

    }


}

