package com.intuso.housemate.plugin.v1_0.sample.comparator;

import com.intuso.housemate.plugin.v1_0.api.ComparisonType;

public class LocationType implements ComparisonType {
    @Override
    public String getId() {
        return "location-comparator";
    }

    @Override
    public String getName() {
        return "Location Comparator";
    }

    @Override
    public String getDescription() {
        return "Comparator of locations";
    }
}
