package com.intuso.housemate.plugin.v1_0.api.driver;

import org.slf4j.Logger;

/**
 * Created by tomc on 30/09/15.
 */
public interface TaskDriver {

    void start();
    void stop();
    void execute();

    interface Callback {
        void setError(String error);
    }

    interface Factory<DRIVER extends TaskDriver> {
        DRIVER create(Logger logger, Callback callback);
    }

    /**
     * Created by tomc on 30/08/16.
     */
    class TaskException extends RuntimeException {
        private static final long serialVersionUID = -1L;

        public TaskException() {}

        public TaskException(String s) {
            super(s);
        }

        public TaskException(String s, Throwable throwable) {
            super(s, throwable);
        }

        public TaskException(Throwable throwable) {
            super(throwable);
        }
    }
}
