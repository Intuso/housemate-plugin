package com.intuso.housemate.plugin.v1_0.api.feature;

import com.intuso.housemate.plugin.v1_0.api.annotations.Command;
import com.intuso.housemate.plugin.v1_0.api.annotations.Feature;
import com.intuso.housemate.plugin.v1_0.api.annotations.TypeInfo;

/**
 * Interface to mark real devices that provide power control
 */
@Feature
@TypeInfo(id = "run", name = "Run", description = "Run")
public interface RunControl {

    /**
     * Callback to turn the device on
     */
    @Command
    @TypeInfo(id = "start", name = "Start", description = "Start")
    void start();

    /**
     * Callback to turn the device off
     */
    @Command
    @TypeInfo(id = "stop", name = "Stop", description = "Stop")
    void stop();
}
