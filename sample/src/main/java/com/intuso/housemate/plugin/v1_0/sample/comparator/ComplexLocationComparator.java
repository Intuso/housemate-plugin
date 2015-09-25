package com.intuso.housemate.plugin.v1_0.sample.comparator;

import com.google.inject.Inject;
import com.intuso.housemate.plugin.v1_0.api.Comparator;
import com.intuso.housemate.plugin.v1_0.api.ComparisonType;
import com.intuso.housemate.plugin.v1_0.sample.CustomArg;
import com.intuso.housemate.plugin.v1_0.sample.type.Location;

public class ComplexLocationComparator implements Comparator<Location> {

    private final LocationType operator = new LocationType();

    @Inject
    public ComplexLocationComparator(CustomArg customArg) {
    }

    @Override
    public ComparisonType getComparisonType() {
        return operator;
    }

    @Override
    public String getTypeId() {
        return com.intuso.housemate.plugin.v1_0.sample.type.LocationType.ID;
    }

    @Override
    public boolean compare(Location first, Location second) {
        // do some comparison between locations here. Depends on what you're comparing ... eg Equal?
        return true;
    }
}
