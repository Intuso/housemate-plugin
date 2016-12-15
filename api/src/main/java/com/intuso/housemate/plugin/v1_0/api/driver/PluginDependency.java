package com.intuso.housemate.plugin.v1_0.api.driver;

import com.intuso.utilities.listener.ListenerRegistration;

/**
 * Created by tomc on 29/10/15.
 */
public interface PluginDependency<DEPENDENCY> {

    DEPENDENCY getDependency();

    ListenerRegistration addListener(Listener<DEPENDENCY> listener);

    interface Listener<DEPENDENCY> extends com.intuso.utilities.listener.Listener {
        void dependencyAvailable(DEPENDENCY DEPENDENCY);
        void dependencyUnavailable();
    }
}
