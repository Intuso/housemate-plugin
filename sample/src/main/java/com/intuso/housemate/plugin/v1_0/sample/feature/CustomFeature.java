package com.intuso.housemate.plugin.v1_0.sample.feature;

import com.intuso.housemate.client.v1_0.real.api.annotations.*;

/**
 * Created by tomc on 18/11/15.
 */
public interface CustomFeature {

    @Command
    @Id(value = "do-me", name = "Do Me", description = "Do me")
    void doMe(@Parameter("location") @Id(value = "param", name = "Some Param", description = "A parameter for something") String someValue);

    @Values
    interface CustomValues {
        @Value("integer")
        @Id(value = "myValue", name = "My Value", description = "Value to show the latest value of me")
        void myValue(int value);
    }
}
