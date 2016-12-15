package com.intuso.housemate.plugin.v1_0.api.driver;

/**
 * Created by tomc on 08/12/16.
 */
public class ObjectDescription {

    private String id;
    private String name;
    private String description;

    public ObjectDescription() {}

    public ObjectDescription(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
