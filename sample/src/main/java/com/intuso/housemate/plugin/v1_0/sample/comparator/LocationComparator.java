package com.intuso.housemate.plugin.v1_0.sample.comparator;

import com.intuso.housemate.client.v1_0.real.api.RealValue;
import com.intuso.housemate.plugin.v1_0.api.Comparator;
import com.intuso.housemate.plugin.v1_0.api.ComparisonType;
import com.intuso.housemate.plugin.v1_0.sample.type.Location;

public class LocationComparator implements Comparator<RealValue<Location>> {

    private final LocationType operator = new LocationType();

    @Override
    public ComparisonType getComparisonType() {
        return operator;
    }

    @Override
    public String getTypeId() {
        return com.intuso.housemate.plugin.v1_0.sample.type.LocationType.ID;
    }

    @Override
    public boolean compare(RealValue<Location> first, RealValue<Location> second) {
        // do some comparison between locations here. Depends on what you're comparing ... eg Equal?
        return true;
    }
}
