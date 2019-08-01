package com.example.ciyaagain.data;

import java.io.Serializable;

public class Coordinates implements Serializable {
    double lon = 3.0;
    double lat = 3.0;

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
