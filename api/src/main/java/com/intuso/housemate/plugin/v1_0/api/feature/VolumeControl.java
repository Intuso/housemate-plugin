package com.intuso.housemate.plugin.v1_0.api.feature;

import com.intuso.housemate.plugin.v1_0.api.annotations.Command;
import com.intuso.housemate.plugin.v1_0.api.annotations.Feature;
import com.intuso.housemate.plugin.v1_0.api.annotations.TypeInfo;

/**
 * Interface to mark real devices that provide volume control
 */
@Feature
@TypeInfo(id = "volume", name = "Volume", description = "Volume")
public interface VolumeControl {

    /**
     * Callback for when the volume should be muted
     */
    @Command
    @TypeInfo(id = "mute", name = "Mute", description = "Mute")
    void mute();

    /**
     * Callback for when the volume should be increased
     */
    @Command
    @TypeInfo(id = "volume-up", name = "Volume Up", description = "Volume up")
    void volumeUp();

    /**
     * Callback for when the volume should be decreased
     */
    @Command
    @TypeInfo(id = "volume-down", name = "Volume Down", description = "Volume down")
    void volumeDown();
}
