package com.intuso.housemate.plugin.v1_0.sample.device;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.intuso.housemate.client.v1_0.real.api.annotations.*;
import com.intuso.housemate.client.v1_0.real.api.driver.DeviceDriver;
import com.intuso.housemate.plugin.v1_0.api.TypeInfo;

@TypeInfo(id = "custom-device", name = "Custom Device", description = "Device that does some custom thing")
public class CustomDevice implements DeviceDriver {

    @Values
    public MyValues values;

    @Property(id = "my-property", name = "My Property", description = "Property to control me", typeId = "double")
    public double myProperty = 1.0;

    @Inject
    public CustomDevice(@Assisted DeviceDriver.Callback callback) {}

    @Command(id = "do-me", name = "Do Me", description = "Do me")
    public void doMe(@Parameter(id = "param", name = "Some Param", description = "A parameter for something", typeId = "location") String someValue) {
        // do something meaningful and interesting here
        values.myValue((int)myProperty);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    public interface MyValues {
        @Value(id = "myValue", name = "My Value", description = "Value to show the latest value of me", typeId = "integer")
        void myValue(int value);
    }
}
