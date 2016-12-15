package com.intuso.housemate.plugin.v1_0.api.driver;

/**
 * Created by tomc on 08/12/16.
 */
public class ParameterDescription extends ObjectDescription {

    private int minValues;
    private int maxValues;

    public ParameterDescription() {}

    public ParameterDescription(String id, String name, String description, int minValues, int maxValues) {
        super(id, name, description);
        this.minValues = minValues;
        this.maxValues = maxValues;
    }

    public int getMinValues() {
        return minValues;
    }

    public void setMinValues(int minValues) {
        this.minValues = minValues;
    }

    public int getMaxValues() {
        return maxValues;
    }

    public void setMaxValues(int maxValues) {
        this.maxValues = maxValues;
    }
}
