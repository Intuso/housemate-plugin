package com.intuso.housemate.plugin.v1_0.sample.feature;

import com.intuso.housemate.client.v1_0.api.annotation.*;
import com.intuso.housemate.client.v1_0.api.type.Time;
import com.intuso.utilities.listener.ListenerRegistration;

/**
 * Created by tomc on 18/11/15.
 */
public interface CustomFeature {

    @Command
    @Id(value = "do-me", name = "Do Me", description = "Do me")
    void doMe(@Parameter @Id(value = "time", name = "A Time", description = "A time") Time time,
              @Parameter @Id(value = "int", name = "An Int", description = "An int") int anInt);

    @AddListener
    ListenerRegistration addListener(Listener listener);

    interface Listener {
        @Value
        @Id(value = "myValue", name = "My Value", description = "Value to show the latest value of me")
        void myValue(int value);
    }
}
