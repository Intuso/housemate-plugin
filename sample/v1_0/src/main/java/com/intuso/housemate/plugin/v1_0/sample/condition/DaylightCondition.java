package com.intuso.housemate.plugin.v1_0.sample.condition;

import com.intuso.housemate.client.v1_0.api.annotation.Id;
import com.intuso.housemate.client.v1_0.api.driver.ConditionDriver;
import org.slf4j.Logger;

@Id(value = "daylight-condition", name = "Daylight Condition", description = "Condition that is true when the sun is shining")
public class DaylightCondition implements ConditionDriver {

    @Override
    public boolean hasChildConditions() {
        return false;
    }

    @Override
    public void init(Logger logger, ConditionDriver.Callback callback) {
        // start checking for sunset/sunrise times, eg via a webservice or outdoor light sensor
    }

    @Override
    public void uninit() {
        // stop checking sunset/sunrise times
    }
}
