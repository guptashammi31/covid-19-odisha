package com.technogenr.ocovid.model;

public class HostpotLocation {
    private double lat, lng;

    public HostpotLocation() {
    }

    public HostpotLocation(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
