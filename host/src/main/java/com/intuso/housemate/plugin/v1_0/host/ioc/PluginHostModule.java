package com.intuso.housemate.plugin.v1_0.host.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.intuso.housemate.plugin.v1_0.host.PluginHost;

/**
 * Created by tomc on 18/03/15.
 */
public class PluginHostModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(PluginHost.class).in(Scopes.SINGLETON);
    }
}
