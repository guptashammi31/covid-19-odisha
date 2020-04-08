package com.technogenr.ocovid.helper;

import android.content.Context;

import com.android.volley.VolleyError;
import com.technogenr.ocovid.listeners.HttpResponse;
import com.technogenr.ocovid.util.NetworkUtil;

public class APIHelper {
    private NetworkUtil networkUtil;

    public APIHelper(Context context){
        networkUtil=new NetworkUtil(context);
    }

    public void getIndiaData(final HttpResponse httpResponse){
        networkUtil.httpRequest(URLHelper.getIndiaData, new HttpResponse() {
            @Override
            public void httpResponseSuccess(String response) {
                httpResponse.httpResponseSuccess(response);
            }

            @Override
            public void httpResponseError(VolleyError error) {
                httpResponse.httpResponseError(error);
            }
        });
    }
    public void getOdishaData(final HttpResponse httpResponse){
        networkUtil.httpRequest(URLHelper.getOdishaData, new HttpResponse() {
            @Override
            public void httpResponseSuccess(String response) {
                httpResponse.httpResponseSuccess(response);
            }

            @Override
            public void httpResponseError(VolleyError error) {
                httpResponse.httpResponseError(error);
            }
        });
    }
}
