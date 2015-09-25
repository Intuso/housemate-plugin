package com.intuso.housemate.plugin.v1_0.sample.type;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.intuso.housemate.client.v1_0.real.api.RealSubType;
import com.intuso.housemate.client.v1_0.real.api.impl.type.RealCompoundType;
import com.intuso.housemate.object.v1_0.api.TypeInstance;
import com.intuso.housemate.plugin.v1_0.sample.CustomArg;
import com.intuso.utilities.listener.ListenersFactory;
import com.intuso.utilities.log.Log;

public class ComplexLocationType extends RealCompoundType<Location> {

    public final static String ID = "complex-location-type";
    public final static String NAME = "Complex Location Type";
    public final static String DESCRIPTION = "A location type that is complex";

    @Inject
    public ComplexLocationType(Log log, ListenersFactory listenersFactory, CustomArg customArg) {
        super(log, listenersFactory, ID, NAME, DESCRIPTION, 1, 1, /* Add sub types here */ Lists.<RealSubType<?>>newArrayList());
    }

    @Override
    public TypeInstance serialise(Location o) {
        // this is not a real type, just a demo of how to include complex types in a plugin
        return null;
    }

    @Override
    public Location deserialise(TypeInstance instance) {
        // this is not a real type, just a demo of how to include complex types in a plugin
        return null;
    }
}
