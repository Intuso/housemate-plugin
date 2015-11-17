package com.intuso.housemate.plugin.v1_0.api;

import com.intuso.housemate.client.v1_0.real.api.annotations.TypeInfo;

/**
 * Created by tomc on 06/11/15.
 */
public interface PluginResource<RESOURCE> {
    TypeInfo getTypeInfo();
    RESOURCE getResource();
}
