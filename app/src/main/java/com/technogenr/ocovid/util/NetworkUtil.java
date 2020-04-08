package com.technogenr.ocovid.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.technogenr.ocovid.listeners.HttpResponse;

import java.util.Map;

public class NetworkUtil{
    Context activity;

    public NetworkUtil(Context activity){
        this.activity=activity;
    }

    public Boolean availableNetwok(){
        ConnectivityManager connectivityManager=(ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        return networkInfo!=null && networkInfo.isConnected();
    }

    public void httpRequest(String url, final HttpResponse httpResponse){
        if(availableNetwok()){
            RequestQueue queue= Volley.newRequestQueue(activity);

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            httpResponse.httpResponseSuccess(response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    httpResponse.httpResponseError(error);
                }
            });
            queue.add(stringRequest);
        }
    }

    public void httpPOSTRequest(final Map<String, String> postMap, String url, final HttpResponse httpResponse){
        if(availableNetwok()){
            RequestQueue queue=Volley.newRequestQueue(activity);

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("SUCCESS_HTTP", response);
                            httpResponse.httpResponseSuccess(response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("HTTP_REQUEST_ERROR", error.toString());
                    httpResponse.httpResponseError(error);
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    return postMap;
                }
            };
            stringRequest.setRetryPolicy(new RetryPolicy() {
                @Override
                public int getCurrentTimeout() {
                    return 50000;
                }

                @Override
                public int getCurrentRetryCount() {
                    return 50000;
                }

                @Override
                public void retry(VolleyError error) throws VolleyError {
                    httpResponse.httpResponseError(error);
                }
            });

            queue.add(stringRequest);
        }
    }
}
