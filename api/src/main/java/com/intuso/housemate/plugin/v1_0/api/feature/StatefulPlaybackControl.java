package com.intuso.housemate.plugin.v1_0.api.feature;

import com.intuso.housemate.plugin.v1_0.api.annotations.Feature;
import com.intuso.housemate.plugin.v1_0.api.annotations.TypeInfo;
import com.intuso.housemate.plugin.v1_0.api.annotations.Value;
import com.intuso.housemate.plugin.v1_0.api.annotations.Values;

/**
 * Interface to mark real devices that provide stateful playback control
 */
@Feature
@TypeInfo(id = "playback-stateful", name = "Playback", description = "Playback")
public interface StatefulPlaybackControl extends PlaybackControl {

    @Values
    interface PlaybackValues {

        /**
         * Callback to set the current playing value
         * @param isPlaying true if the device is currently playing
         */
        @Value("boolean")
        @TypeInfo(id = "is-playing", name = "Is Playing", description = "True if the device is currently playing")
        void isPlaying(boolean isPlaying);
    }
}
