package com.intuso.housemate.plugin.v1_0.api.module;

import com.intuso.housemate.plugin.v1_0.api.annotations.TypeInfo;

/**
 * Created by tomc on 06/11/15.
 */
public class PluginResourceImpl<RESOURCE> implements PluginResource<RESOURCE> {

    private final TypeInfo typeInfo;
    private final RESOURCE resource;

    public PluginResourceImpl(TypeInfo typeInfo, RESOURCE resource) {
        this.typeInfo = typeInfo;
        this.resource = resource;
    }

    @Override
    public TypeInfo getTypeInfo() {
        return typeInfo;
    }

    @Override
    public RESOURCE getResource() {
        return resource;
    }
}
