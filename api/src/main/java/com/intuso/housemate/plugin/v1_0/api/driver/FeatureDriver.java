package com.intuso.housemate.plugin.v1_0.api.driver;

import org.slf4j.Logger;

/**
 * Created by tomc on 30/09/15.
 */
public interface FeatureDriver {

    void start();
    void stop();

    interface Callback {
        void setError(String error);
    }

    interface Factory<DRIVER extends FeatureDriver> {
        DRIVER create(Logger logger, Callback callback);
    }

    /**
     * Created by tomc on 30/08/16.
     */
    class FeatureException extends RuntimeException {
        private static final long serialVersionUID = -1L;

        public FeatureException() {}

        public FeatureException(String s) {
            super(s);
        }

        public FeatureException(String s, Throwable throwable) {
            super(s, throwable);
        }

        public FeatureException(Throwable throwable) {
            super(throwable);
        }
    }
}
