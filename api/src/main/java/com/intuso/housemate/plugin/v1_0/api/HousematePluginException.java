package com.intuso.housemate.plugin.v1_0.api;

/**
 * Created by tomc on 16/05/16.
 */
public class HousematePluginException extends RuntimeException {

    public HousematePluginException() {}

    public HousematePluginException(Throwable cause) {
        super(cause);
    }

    public HousematePluginException(String message) {
        super(message);
    }

    public HousematePluginException(String message, Throwable cause) {
        super(message, cause);
    }
}
