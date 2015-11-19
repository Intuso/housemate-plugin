package com.intuso.housemate.plugin.v1_0.sample.device;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.intuso.housemate.client.v1_0.real.api.annotations.Property;
import com.intuso.housemate.client.v1_0.real.api.annotations.TypeInfo;
import com.intuso.housemate.client.v1_0.real.api.driver.DeviceDriver;

@TypeInfo(id = "custom-device", name = "Custom Device", description = "Device that does some custom thing")
public class CustomDeviceDriver implements DeviceDriver, CustomFeature {

    public CustomValues values;

    @Property("double")
    @TypeInfo(id = "my-property", name = "My Property", description = "Property to control me")
    public double myProperty = 1.0;

    @Inject
    public CustomDeviceDriver(@Assisted DeviceDriver.Callback callback) {}

    @Override
    public void doMe(String someValue) {
        // do something meaningful and interesting here
        values.myValue((int)myProperty);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
