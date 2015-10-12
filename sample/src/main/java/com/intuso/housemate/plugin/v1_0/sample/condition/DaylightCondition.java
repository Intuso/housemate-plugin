package com.intuso.housemate.plugin.v1_0.sample.condition;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.intuso.housemate.client.v1_0.real.api.driver.ConditionDriver;
import com.intuso.housemate.plugin.v1_0.api.TypeInfo;

@TypeInfo(id = "daylight-condition", name = "Daylight Condition", description = "Condition that is true when the sun is shining")
public class DaylightCondition implements ConditionDriver {

    @Inject
    public DaylightCondition(@Assisted ConditionDriver.Callback callback) {}

    @Override
    public boolean hasChildConditions() {
        return false;
    }

    @Override
    public void start() {
        // start checking for sunset/sunrise times, eg via a webservice or outdoor light sensor
    }

    @Override
    public void stop() {
        // stop checking sunset/sunrise times
    }
}
