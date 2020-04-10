package com.technogenr.ocovid;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.technogenr.ocovid.helper.APIHelper;
import com.technogenr.ocovid.listeners.HttpResponse;
import com.technogenr.ocovid.model.StatusIndiaResponse;
import com.technogenr.ocovid.model.StatusOdishaResponse;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6;
    LinearLayout l1,l2,l3,l4,l5,l6,l7,l8,l9;
    TextView t1,t2,t3,t4,t5,t6,la,Tag;
    LinearLayout testyourself,linearLayout43,linearLayout44;
    Animation atg, atgtwo, atgthree;
    DatabaseReference ref;
    String temp="not available",temp2="notfound";
    private APIHelper apiHelper;
    private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQueue = Volley.newRequestQueue(this);
        apiHelper=new APIHelper(this);
      //  loadData();

        l1=(LinearLayout)findViewById(R.id.l1);
        l2=(LinearLayout)findViewById(R.id.l2);
        l3=(LinearLayout)findViewById(R.id.l3);
        l4=(LinearLayout)findViewById(R.id.l4);
        l5=(LinearLayout)findViewById(R.id.l5);
        l6=(LinearLayout)findViewById(R.id.l6);
        l7=(LinearLayout)findViewById(R.id.l7);
        l8=(LinearLayout)findViewById(R.id.l8);
        l9=(LinearLayout)findViewById(R.id.l9);

        Tag=(TextView)findViewById(R.id.tag2) ;


        t1=(TextView)findViewById(R.id.ia) ;
        t2=(TextView)findViewById(R.id.id) ;
        t3=(TextView)findViewById(R.id.ide) ;
        t4=(TextView)findViewById(R.id.oa) ;
        t5=(TextView)findViewById(R.id.od) ;
        t6=(TextView)findViewById(R.id.ode) ;
        la=(TextView)findViewById(R.id.la) ;
//loadData();
       jsonParse();
       jsonParse2();

        ref= FirebaseDatabase.getInstance().getReference("TestCovid");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    temp=((String) dataSnapshot.child("link").getValue());
                    Tag.setText((String) dataSnapshot.child("Tag").getValue());
                  temp2=((String) dataSnapshot.child("linkb3").getValue());
//                    t4.setText((String) dataSnapshot.child("odisha").child("active").getValue());
//                    t5.setText((String) dataSnapshot.child("odisha").child("discharge").getValue());
//                    t6.setText((String) dataSnapshot.child("odisha").child("death").getValue());
//

//
                }
            }



            @Override
            public void onCancelled(DatabaseError dataSnapshot) {

            }
        });



        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NeedToDoActivity.class);
                startActivity(intent);
            }
        });

        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HelpLineActivity.class);
                startActivity(intent);
            }
        });

        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SendDetailsActivity.class);
                intent.putExtra("link",temp2);

                startActivity(intent);
            }
        });
        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(intent);
            }
        });
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestCentreActivity.class);
                startActivity(intent);
            }
        });
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, HostpotsActivity.class);
                startActivity(intent);
            }
        });
        l7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ComplainActivity.class);
                startActivity(intent);
            }
        });
        l8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TwitterWebActivity.class);
                intent.putExtra("link",temp);
                startActivity(intent);
            }
        });
        l9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideoMainActivity.class);
                startActivity(intent);
            }
        });

        linearLayout43 = (LinearLayout) findViewById(R.id.linearLayout43);
        linearLayout44 = (LinearLayout) findViewById(R.id.linearLayout44);

//        testyourself = (LinearLayout) findViewById(R.id.testyourself);
//        testyourself.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent intent = new Intent(MainActivity.this,WebviewActivity.class);
////                startActivity(intent);
//            }
//        });

        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        atgtwo = AnimationUtils.loadAnimation(this, R.anim.atgtwo);
        atgthree = AnimationUtils.loadAnimation(this, R.anim.atgthree);



        // pass an animation
        linearLayout43.startAnimation(atg);

        linearLayout44.startAnimation(atgtwo);
//        // pagesubtitle.startAnimation(atgtwo);
//
//        linearLayout5.startAnimation(atgthree);
//        return linearLayout;
    }

    //    private void loadData() {
//        apiHelper.getIndiaData(new HttpResponse() {
//            @Override
//            public void httpResponseSuccess(String response) {
//                Gson gson=new Gson();
//                StatusIndiaResponse responseObject=gson.fromJson(response, StatusIndiaResponse.class);
//                t1.setText(responseObject.getActive_Cases());
//                t2.setText(responseObject.getCured_Discharged());
//                t3.setText(responseObject.getDeaths());
//            }
//
//            @Override
//            public void httpResponseError(VolleyError error) {
//
//            }
//        });
//        apiHelper.getOdishaData(new HttpResponse() {
//            @Override
//            public void httpResponseSuccess(String response) {
//                Gson gson=new Gson();
//                StatusOdishaResponse responseObject=gson.fromJson(response, StatusOdishaResponse.class);
//                t4.setText(responseObject.getTotal_Confirmed());
//                t5.setText(responseObject.getCured_Discharged_Migrated());
//                t6.setText(responseObject.getDeath());
//            }
//
//            @Override
//            public void httpResponseError(VolleyError error) {
//
//            }
//        });
//    }
    private void jsonParse() {

        String url = "https://api.covid19india.org/data.json";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("statewise");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject odisha = jsonArray.getJSONObject(i);

                                if (odisha.getString("state").equals("Total")){
                                    int active = odisha.getInt("active");
                                    int confirmed = odisha.getInt("confirmed");
                                    int deaths = odisha.getInt("deaths");
                                    int deltaconfirmed = odisha.getInt("deltaconfirmed");
                                    int deltadeaths = odisha.getInt("deltadeaths");
                                    int deltarecovered = odisha.getInt("deltarecovered");
                                    String lastupdatedtime = odisha.getString("lastupdatedtime");
                                    int recovered = odisha.getInt("recovered");
                                    String state = odisha.getString("state");
                                    String statecode = odisha.getString("statecode");
                                    //String sub=lastupdatedtime.substring(0, 9);
                                    t1.setText(String.valueOf(active));
                                    t2.setText(String.valueOf(recovered));
                                    t3.setText(String.valueOf(deaths));
                                    la.append(lastupdatedtime);


//                                        + "\n confirmed :  " + String.valueOf(confirmed)
//                                        + "\n deaths :  " + String.valueOf(deaths)
//                                        + "\n deltaconfirmed :  " + String.valueOf(deltaconfirmed)
//                                        + "\n deltadeaths :  " + String.valueOf(deltadeaths)
//                                        + "\n deltarecovered  :  " + String.valueOf(deltarecovered)
//                                        + "\n lastupdatedtime :  " + lastupdatedtime
//                                        + "\n recovered :  " + String.valueOf(recovered)
//                                        + "\n state :  " + state
//                                        + "\n statecode :  " + statecode
//                                        + "\n\n");
                                }
//                                mTextViewResult.append(firstName + ", " + String.valueOf(age) + ", " + mail + "\n\n");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }
    private void jsonParse2() {

        String url = "https://api.covid19india.org/data.json";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("statewise");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject odisha = jsonArray.getJSONObject(i);

                                if (odisha.getString("state").equals("Odisha")){
                                    int active = odisha.getInt("active");
                                    int confirmed = odisha.getInt("confirmed");
                                    int deaths = odisha.getInt("deaths");
                                    int deltaconfirmed = odisha.getInt("deltaconfirmed");
                                    int deltadeaths = odisha.getInt("deltadeaths");
                                    int deltarecovered = odisha.getInt("deltarecovered");
                                    String lastupdatedtime = odisha.getString("lastupdatedtime");
                                    int recovered = odisha.getInt("recovered");
                                    String state = odisha.getString("state");
                                    String statecode = odisha.getString("statecode");

                                    t4.setText(String.valueOf(active));
                                    t5.setText(String.valueOf(recovered));
                                    t6.setText(String.valueOf(deaths));
                                    //  t4.setText(String.valueOf(recovered));


//                                        + "\n confirmed :  " + String.valueOf(confirmed)
//                                        + "\n deaths :  " + String.valueOf(deaths)
//                                        + "\n deltaconfirmed :  " + String.valueOf(deltaconfirmed)
//                                        + "\n deltadeaths :  " + String.valueOf(deltadeaths)
//                                        + "\n deltarecovered  :  " + String.valueOf(deltarecovered)
//                                        + "\n lastupdatedtime :  " + lastupdatedtime
//                                        + "\n recovered :  " + String.valueOf(recovered)
//                                        + "\n state :  " + state
//                                        + "\n statecode :  " + statecode
//                                        + "\n\n");
                                }
//                                mTextViewResult.append(firstName + ", " + String.valueOf(age) + ", " + mail + "\n\n");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }
    private void loadData() {
        apiHelper.getIndiaData(new HttpResponse() {
            @Override
            public void httpResponseSuccess(String response) {
                Gson gson=new Gson();
                StatusIndiaResponse responseObject=gson.fromJson(response, StatusIndiaResponse.class);
                t1.setText(responseObject.getActive_Cases());
                t2.setText(responseObject.getCured_Discharged());
                t3.setText(responseObject.getDeaths());
                la.setText(responseObject.getTime());
            }

            @Override
            public void httpResponseError(VolleyError error) {

            }
        });
        apiHelper.getOdishaData(new HttpResponse() {
            @Override
            public void httpResponseSuccess(String response) {
                Gson gson=new Gson();
                StatusOdishaResponse responseObject=gson.fromJson(response, StatusOdishaResponse.class);
                t4.setText(responseObject.getTotal_Confirmed());
                t5.setText(responseObject.getCured_Discharged_Migrated());
                t6.setText(responseObject.getDeath());
            }

            @Override
            public void httpResponseError(VolleyError error) {

            }
        });
    }



}