package com.intuso.housemate.plugin.v1_0.sample.task;

import com.intuso.housemate.client.v1_0.api.annotation.Id;
import com.intuso.housemate.client.v1_0.api.driver.TaskDriver;
import org.slf4j.Logger;

@Id(value = "do-your-thing", name = "Do Your Thing", description = "Special task that does your thing")
public class DoYourThingTask implements TaskDriver {

    @Override
    public void init(Logger logger, Callback callback) {

    }

    @Override
    public void uninit() {

    }

    @Override
    public void execute() {
        // do whatever thing it is you do
    }
}
