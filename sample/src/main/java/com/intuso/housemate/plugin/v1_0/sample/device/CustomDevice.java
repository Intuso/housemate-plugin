package com.intuso.housemate.plugin.v1_0.sample.device;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.intuso.housemate.client.v1_0.real.api.annotations.*;
import com.intuso.housemate.client.v1_0.real.api.driver.DeviceDriver;

@TypeInfo(id = "custom-device", name = "Custom Device", description = "Device that does some custom thing")
public class CustomDevice implements DeviceDriver {

    @Values
    public MyValues values;

    @Property("double")
    @TypeInfo(id = "my-property", name = "My Property", description = "Property to control me")
    public double myProperty = 1.0;

    @Inject
    public CustomDevice(@Assisted DeviceDriver.Callback callback) {}

    @Command
    @TypeInfo(id = "do-me", name = "Do Me", description = "Do me")
    public void doMe(@Parameter("location") @TypeInfo(id = "param", name = "Some Param", description = "A parameter for something") String someValue) {
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
        @Value("integer")
        @TypeInfo(id = "myValue", name = "My Value", description = "Value to show the latest value of me")
        void myValue(int value);
    }
}
