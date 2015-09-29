package com.intuso.housemate.plugin.v1_0.sample.ioc;

import com.google.inject.Inject;
import com.intuso.housemate.plugin.v1_0.api.*;
import com.intuso.housemate.plugin.v1_0.sample.CustomArg;
import com.intuso.housemate.plugin.v1_0.sample.comparator.ComplexLocationComparator;
import com.intuso.housemate.plugin.v1_0.sample.comparator.LocationComparator;
import com.intuso.housemate.plugin.v1_0.sample.condition.DaylightCondition;
import com.intuso.housemate.plugin.v1_0.sample.device.CustomDevice;
import com.intuso.housemate.plugin.v1_0.sample.task.DoYourThingTask;
import com.intuso.housemate.plugin.v1_0.sample.type.LocationType;
import com.intuso.utilities.log.Log;
import com.intuso.utilities.properties.api.WriteableMapPropertyRepository;

@Types({LocationType.class}) // types
@Comparators({LocationComparator.class, ComplexLocationComparator.class}) // comparators
@Devices({CustomDevice.class}) // devices
@Conditions({DaylightCondition.class}) // conditions
@Tasks({DoYourThingTask.class}) // tasks
public class SampleAnnotatedPluginModule extends AnnotatedPluginModule {

    @Inject
    public SampleAnnotatedPluginModule(Log log, WriteableMapPropertyRepository properties) {
        super(log);
        // setup default prop values
        properties.set(CustomArg.PROP_KEY, "your value"); // value
    }

    @Override
    public void configure() {
        // bind plugin-specific things here
    }
}
