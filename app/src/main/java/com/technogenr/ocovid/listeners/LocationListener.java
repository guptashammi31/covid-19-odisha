package com.technogenr.ocovid.listeners;

import com.google.android.gms.location.LocationResult;

public interface LocationListener {
    void locationResponse(LocationResult response);
}
