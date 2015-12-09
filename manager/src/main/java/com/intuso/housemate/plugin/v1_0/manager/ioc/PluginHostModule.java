package com.intuso.housemate.plugin.v1_0.manager.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.intuso.housemate.plugin.manager.PluginManager;

/**
 * Created by tomc on 18/03/15.
 */
public class PluginHostModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(PluginManager.class).in(Scopes.SINGLETON);
    }
}
