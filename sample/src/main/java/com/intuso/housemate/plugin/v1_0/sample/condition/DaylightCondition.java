package com.intuso.housemate.plugin.v1_0.sample.condition;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.intuso.housemate.client.v1_0.real.api.RealCondition;
import com.intuso.housemate.client.v1_0.real.api.factory.condition.RealConditionOwner;
import com.intuso.housemate.comms.v1_0.api.payload.ConditionData;
import com.intuso.housemate.plugin.v1_0.api.TypeInfo;
import com.intuso.utilities.listener.ListenersFactory;
import com.intuso.utilities.log.Log;

@TypeInfo(id = "daylight-condition", name = "Daylight Condition", description = "Condition that is true when the sun is shining")
public class DaylightCondition extends RealCondition {

    @Inject
    public DaylightCondition(Log log,
                             ListenersFactory listenersFactory,
                             @Assisted ConditionData data,
                             @Assisted RealConditionOwner owner) {
        super(log, listenersFactory, "daylight-condition", data, owner);
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
