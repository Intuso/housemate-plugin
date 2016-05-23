package com.intuso.housemate.plugin.v1_0.sample.device;

import com.intuso.housemate.plugin.v1_0.api.annotations.*;

/**
 * Created by tomc on 18/11/15.
 */
public interface CustomFeature {

    @Command
    @TypeInfo(id = "do-me", name = "Do Me", description = "Do me")
    void doMe(@Parameter("location") @TypeInfo(id = "param", name = "Some Param", description = "A parameter for something") String someValue);

    @Values
    interface CustomValues {
        @Value("integer")
        @TypeInfo(id = "myValue", name = "My Value", description = "Value to show the latest value of me")
        void myValue(int value);
    }
}
