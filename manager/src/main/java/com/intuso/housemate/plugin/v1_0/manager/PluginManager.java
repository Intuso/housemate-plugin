package com.intuso.housemate.plugin.v1_0.manager;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.intuso.housemate.client.v1_0.real.api.annotations.TypeInfo;
import com.intuso.housemate.comms.v1_0.api.HousemateCommsException;
import com.intuso.housemate.plugin.v1_0.api.PluginListener;
import com.intuso.utilities.listener.ListenerRegistration;
import com.intuso.utilities.listener.Listeners;
import com.intuso.utilities.listener.ListenersFactory;
import org.slf4j.Logger;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: tomc
 * Date: 12/11/13
 * Time: 09:13
 * To change this template use File | Settings | File Templates.
 */
public class PluginManager {

    private final Logger logger;

    private final Map<String, Injector> pluginInjectors = Maps.newHashMap();
    private final Listeners<PluginListener> pluginListeners;

    @Inject
    public PluginManager(Logger logger, ListenersFactory listenersFactory) {
        this.logger = logger;
        this.pluginListeners = listenersFactory.create();
    }

    public String addPlugin(Injector pluginInjector) {

        logger.debug("Adding plugin");

        Version version = detectVersion(pluginInjector);
        pluginInjector = version.createChildInjector(pluginInjector);

        TypeInfo typeInfo = pluginInjector.getInstance(TypeInfo.class);

        // some plugins add more plugin listeners, so need prevent concurrent modification
        for(PluginListener listener : Lists.newArrayList(pluginListeners))
            listener.pluginAdded(pluginInjector);

        pluginInjectors.put(typeInfo.id(), pluginInjector);
        return typeInfo.id();
    }

    public void removePlugin(String id) {
        logger.debug("Removing plugin : " + id);
        Injector pluginInjector = pluginInjectors.remove(id);
        if(pluginInjector != null)
            for(PluginListener listener : pluginListeners)
                listener.pluginRemoved(pluginInjector);
    }

    public ListenerRegistration addPluginListener(PluginListener listener, boolean callForExisting) {
        ListenerRegistration result = pluginListeners.addListener(listener);
        if(callForExisting)
            for(Injector pluginInjector : pluginInjectors.values())
                listener.pluginAdded(pluginInjector);
        return result;
    }

    private Version detectVersion(Injector pluginInjector) {
        try {
            pluginInjector.getInstance(com.intuso.housemate.client.v1_0.real.api.annotations.TypeInfo.class);
            return Version.V1_0;
        } catch(Throwable t) {}
        throw new HousemateCommsException("Could not detect plugin api version");
    }

    enum Version {
        V1_0 {
            @Override
            public Injector createChildInjector(Injector injector) {
                return injector;
            }
        };

        public abstract Injector createChildInjector(Injector injector);
    }
}
