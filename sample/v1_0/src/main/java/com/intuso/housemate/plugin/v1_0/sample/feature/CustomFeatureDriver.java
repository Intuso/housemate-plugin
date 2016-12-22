package com.intuso.housemate.plugin.v1_0.sample.feature;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.intuso.housemate.client.v1_0.api.HousemateException;
import com.intuso.housemate.client.v1_0.api.annotation.Id;
import com.intuso.housemate.client.v1_0.api.annotation.Property;
import com.intuso.housemate.client.v1_0.api.driver.FeatureDriver;
import com.intuso.housemate.client.v1_0.api.type.Time;
import com.intuso.utilities.listener.ListenerRegistration;
import com.intuso.utilities.listener.Listeners;
import com.intuso.utilities.listener.ListenersFactory;
import org.slf4j.Logger;

@Id(value = "custom-feature", name = "Custom Feature", description = "Feature that does some custom thing")
public class CustomFeatureDriver implements FeatureDriver, CustomFeature {

    private final Listeners<Listener> listeners;
    public Listener values;

    @Property("double")
    @Id(value = "my-property", name = "My Property", description = "Property to control me")
    public double myProperty = 1.0;

    @Inject
    public CustomFeatureDriver(@Assisted Logger logger, @Assisted Callback callback, ListenersFactory listenersFactory) {
        this.listeners = listenersFactory.create();
    }

    @Override
    public void doMe(Time time, int anInt) {
        // do something meaningful and interesting here
        int hours = time.getHour();
        int minutes = (hours * 60) + time.getMinute();
        int seconds = (minutes * 60) + time.getSecond();
        int millis = seconds * 1000;
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new HousemateException("Failed to wait required amount of time");
        }
        values.myValue(anInt);
    }

    @Override
    public ListenerRegistration addListener(Listener listener) {
        return null;
    }

    @Override
    public void startFeature() {

    }

    @Override
    public void stopFeature() {

    }
}
