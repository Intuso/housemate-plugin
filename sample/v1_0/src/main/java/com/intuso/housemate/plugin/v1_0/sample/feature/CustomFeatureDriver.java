package com.intuso.housemate.plugin.v1_0.sample.feature;

import com.google.inject.Inject;
import com.intuso.housemate.client.v1_0.api.HousemateException;
import com.intuso.housemate.client.v1_0.api.annotation.Id;
import com.intuso.housemate.client.v1_0.api.annotation.Property;
import com.intuso.housemate.client.v1_0.api.driver.FeatureDriver;
import com.intuso.housemate.client.v1_0.api.type.Time;
import com.intuso.utilities.listener.ManagedCollection;
import com.intuso.utilities.listener.ManagedCollectionFactory;
import org.slf4j.Logger;

@Id(value = "custom-feature", name = "Custom Feature", description = "Feature that does some custom thing")
public class CustomFeatureDriver implements FeatureDriver, CustomFeature {

    private final ManagedCollection<Listener> listeners;
    public Listener values;

    @Property
    @Id(value = "my-property", name = "My Property", description = "Property to control me")
    public double myProperty = 1.0;

    @Inject
    public CustomFeatureDriver(ManagedCollectionFactory managedCollectionFactory) {
        this.listeners = managedCollectionFactory.create();
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
    public ManagedCollection.Registration addListener(Listener listener) {
        return listeners.add(listener);
    }

    @Override
    public void init(Logger logger, Callback callback) {

    }

    @Override
    public void uninit() {

    }
}
