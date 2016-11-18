package com.intuso.housemate.plugin.v1_0.api.driver;

import org.slf4j.Logger;

/**
 * Created by tomc on 30/09/15.
 */
public interface DeviceDriver {

    void start();
    void stop();

    interface Callback {
        void setError(String error);
    }

    interface Factory<DRIVER extends DeviceDriver> {
        DRIVER create(Logger logger, Callback callback);
    }

    /**
     * Created by tomc on 30/08/16.
     */
    class DeviceException extends RuntimeException {
        private static final long serialVersionUID = -1L;

        public DeviceException() {}

        public DeviceException(String s) {
            super(s);
        }

        public DeviceException(String s, Throwable throwable) {
            super(s, throwable);
        }

        public DeviceException(Throwable throwable) {
            super(throwable);
        }
    }
}
