package com.intuso.housemate.plugin.v1_0.sample.type;

import com.google.inject.Inject;
import com.intuso.housemate.client.v1_0.real.api.RealList;
import com.intuso.housemate.client.v1_0.real.api.RealSubType;
import com.intuso.housemate.client.v1_0.real.api.RealType;
import com.intuso.housemate.client.v1_0.real.api.impl.type.RealCompoundType;
import com.intuso.housemate.comms.v1_0.api.payload.SimpleTypeData;
import com.intuso.housemate.comms.v1_0.api.payload.TypeData;
import com.intuso.housemate.object.v1_0.api.TypeInstance;
import com.intuso.housemate.object.v1_0.api.TypeInstances;
import com.intuso.utilities.listener.ListenersFactory;
import com.intuso.utilities.log.Log;

public class LocationType extends RealCompoundType<Location> {

    public final static String ID = "location";
    public final static String NAME = "Location";
    public final static String DESCRIPTION = "A location specified by a latitude and longitude";

    public final static String LATITUDE_ID = "latitude";
    public final static String LATITUDE_NAME = "Latitude";
    public final static String LATITUDE_DESCRIPTION = "The location's latitude";

    public final static String LONGITUDE_ID = "longitude";
    public final static String LONGITUDE_NAME = "Longitude";
    public final static String LONGITUDE_DESCRIPTION = "The location's longitude";

    @Inject
    protected LocationType(Log log, ListenersFactory listenersFactory, RealList<TypeData<?>, RealType<?, ?, ?>> types) {
        super(log, listenersFactory, ID, NAME, DESCRIPTION, 1,
                1, makeLatitudeSubType(log, listenersFactory, types), makeLongitudeSubType(log, listenersFactory, types));
    }

    private static RealSubType<Double> makeLatitudeSubType(Log log, ListenersFactory listenersFactory,
                                                           RealList<TypeData<?>, RealType<?, ?, ?>> types) {
        return new RealSubType<>(log, listenersFactory, LATITUDE_ID, LATITUDE_NAME,
                LATITUDE_DESCRIPTION, SimpleTypeData.Type.Double.getId(), types);
    }

    private static RealSubType<Double> makeLongitudeSubType(Log log, ListenersFactory listenersFactory,
                                                            RealList<TypeData<?>, RealType<?, ?, ?>> types) {
        return new RealSubType<>(log, listenersFactory, LONGITUDE_ID, LONGITUDE_NAME,
                LONGITUDE_DESCRIPTION, SimpleTypeData.Type.Double.getId(), types);
    }

    @Override
    public TypeInstance serialise(Location location) {
        TypeInstance result = new TypeInstance();
        result.getChildValues().getChildren().put(LATITUDE_ID, new TypeInstances(new TypeInstance(Double.toString(location.getLatitiude()))));
        result.getChildValues().getChildren().put(LONGITUDE_ID, new TypeInstances(new TypeInstance(Double.toString(location.getLongitude()))));
        return result;
    }

    @Override
    public Location deserialise(TypeInstance instance) {
        if(instance == null
                || instance.getChildValues().getChildren().get(LATITUDE_ID) == null
                || instance.getChildValues().getChildren().get(LONGITUDE_ID) == null)
            return null;
        try {
            return new Location(Double.parseDouble(instance.getChildValues().getChildren().get(LATITUDE_ID).getFirstValue()),
                    Double.parseDouble(instance.getChildValues().getChildren().get(LONGITUDE_ID).getFirstValue()));
        } catch(NumberFormatException e) {
            getLog().e("Failed to deserialise location lat/long to double form");
            return null;
        }
    }
}
