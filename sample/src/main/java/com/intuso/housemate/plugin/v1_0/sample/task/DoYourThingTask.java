package com.intuso.housemate.plugin.v1_0.sample.task;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.intuso.housemate.client.v1_0.real.api.annotations.TypeInfo;
import com.intuso.housemate.client.v1_0.real.api.driver.TaskDriver;
import org.slf4j.Logger;

@TypeInfo(id = "do-your-thing", name = "Do Your Thing", description = "Special task that does your thing")
public class DoYourThingTask implements TaskDriver {

    @Inject
    public DoYourThingTask(@Assisted Logger logger, @Assisted TaskDriver.Callback callback) {}

    @Override
    public void execute() {
        // do whatever thing it is you do
    }
}
