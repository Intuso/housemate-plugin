package com.intuso.housemate.plugin.v1_0.sample.type;

public class Location {

    private final double latitiude;
    private final double longitude;

    public Location(double latitiude, double longitude) {
        this.latitiude = latitiude;
        this.longitude = longitude;
    }

    public double getLatitiude() {
        return latitiude;
    }

    public double getLongitude() {
        return longitude;
    }
}
