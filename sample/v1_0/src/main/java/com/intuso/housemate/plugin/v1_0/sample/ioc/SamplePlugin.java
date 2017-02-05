package com.intuso.housemate.plugin.v1_0.sample.ioc;

import com.google.inject.Inject;
import com.intuso.housemate.client.v1_0.api.annotation.Id;
import com.intuso.housemate.client.v1_0.api.plugin.AnnotatedPlugin;
import com.intuso.housemate.client.v1_0.api.plugin.ConditionDrivers;
import com.intuso.housemate.client.v1_0.api.plugin.TaskDrivers;
import com.intuso.housemate.plugin.v1_0.sample.CustomArg;
import com.intuso.housemate.plugin.v1_0.sample.condition.DaylightCondition;
import com.intuso.housemate.plugin.v1_0.sample.task.DoYourThingTask;
import com.intuso.utilities.properties.api.WriteableMapPropertyRepository;

@Id(value = "sample-plugin",
        name = "Sample plugin",
        description = "Sample Plugin to show how to register new types etc")
@ConditionDrivers({DaylightCondition.class}) // conditions
@TaskDrivers({DoYourThingTask.class}) // tasks
public class SamplePlugin extends AnnotatedPlugin {

    @Inject
    public SamplePlugin(WriteableMapPropertyRepository properties) {
        // setup default prop values
        properties.set(CustomArg.PROP_KEY, "your value"); // value
    }
}
