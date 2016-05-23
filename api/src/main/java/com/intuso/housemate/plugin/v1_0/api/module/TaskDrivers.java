package com.intuso.housemate.plugin.v1_0.api.module;

import com.intuso.housemate.plugin.v1_0.api.driver.TaskDriver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to list the task factories that the plugin provides
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TaskDrivers {

    /**
     * The list of the task factories the plugin provides
     * @return the list of the task factories the plugin provides
     */
    Class<? extends TaskDriver>[] value();
}
