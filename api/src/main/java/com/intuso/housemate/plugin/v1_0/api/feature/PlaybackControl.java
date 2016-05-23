package com.intuso.housemate.plugin.v1_0.api.feature;

import com.intuso.housemate.plugin.v1_0.api.annotations.Command;
import com.intuso.housemate.plugin.v1_0.api.annotations.Feature;
import com.intuso.housemate.plugin.v1_0.api.annotations.TypeInfo;

/**
 * Interface to mark real devices that provide playback control
 */
@Feature
@TypeInfo(id = "playback", name = "Playback", description = "Playback")
public interface PlaybackControl {

    /**
     * Callback to start playback
     */
    @Command
    @TypeInfo(id = "play", name = "Play", description = "Play")
    void play();

    /**
     * Callback to pause playback
     */
    @Command
    @TypeInfo(id = "pause", name = "Pause", description = "Pause")
    void pause();

    /**
     * Callback to stop playback
     */
    @Command
    @TypeInfo(id = "stop", name = "Stop", description = "Stop")
    void stopPlayback();

    /**
     * Callback to skip the playback forwards
     */
    @Command
    @TypeInfo(id = "forward", name = "Forward", description = "Forward")
    void forward();

    /**
     * Callback to skip the playback backwards
     */
    @Command
    @TypeInfo(id = "rewind", name = "Rewind", description = "Rewind")
    void rewind();
}
