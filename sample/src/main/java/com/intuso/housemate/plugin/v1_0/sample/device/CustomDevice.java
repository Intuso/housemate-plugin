package com.intuso.housemate.plugin.v1_0.sample.device;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.intuso.housemate.client.v1_0.real.api.RealDevice;
import com.intuso.housemate.client.v1_0.real.api.annotations.*;
import com.intuso.housemate.comms.v1_0.api.payload.DeviceData;
import com.intuso.housemate.plugin.v1_0.api.TypeInfo;
import com.intuso.housemate.plugin.v1_0.sample.type.Location;
import com.intuso.utilities.listener.ListenersFactory;
import com.intuso.utilities.log.Log;

import java.util.List;

@TypeInfo(id = "custom-device", name = "Custom Device", description = "Device that does some custom thing")
public class CustomDevice extends RealDevice {

    @Values
    public MyValues values;

    @Property(id = "my-property", name = "My Property", description = "Property to control me", typeId = "double")
    public double myProperty = 1.0;

    @Inject
    public CustomDevice(Log log,
                        ListenersFactory listenersFactory,
                        @Assisted DeviceData data) {
        super(log, listenersFactory, "custom-device", data);
        List<String> propertyIds = data.getCustomPropertyIds() == null ? Lists.<String>newArrayList() : Lists.newArrayList(data.getCustomPropertyIds());
        propertyIds.add("my-property");
        data.setCustomPropertyIds(propertyIds);
    }

    @Command(id = "do-me", name = "Do Me", description = "Do me")
    public void doMe(@Parameter(id = "where", name = "Where", description = "Where to do me", typeId = "location") Location where) {
        // do something meaningful and interesting here
        values.myValue((int)myProperty);
    }

    public interface MyValues {
        @Value(id = "myValue", name = "My Value", description = "Value to show the latest value of me", typeId = "integer")
        void myValue(int value);
    }
}
