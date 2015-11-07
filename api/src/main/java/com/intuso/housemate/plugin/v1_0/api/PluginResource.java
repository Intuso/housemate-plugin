package com.intuso.housemate.plugin.v1_0.api;

/**
 * Created by tomc on 06/11/15.
 */
public interface PluginResource<RESOURCE> {
    TypeInfo getTypeInfo();
    RESOURCE getResource();
}
