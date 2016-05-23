package com.intuso.housemate.plugin.v1_0.api.module;

import com.intuso.housemate.plugin.v1_0.api.annotations.TypeInfo;

/**
 * Created by tomc on 06/11/15.
 */
public interface PluginResource<RESOURCE> {
    TypeInfo getTypeInfo();
    RESOURCE getResource();
}
