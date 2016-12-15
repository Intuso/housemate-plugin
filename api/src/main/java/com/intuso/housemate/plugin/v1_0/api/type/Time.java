package com.intuso.housemate.plugin.v1_0.api.type;

import com.intuso.housemate.plugin.v1_0.api.annotations.Composite;
import com.intuso.housemate.plugin.v1_0.api.annotations.Id;
import com.intuso.housemate.plugin.v1_0.api.annotations.IntegerWrap;

/**
 * Simple representation of a time
 */
@Id(value = "time", name = "Time", description = "Time of day")
@Composite
public class Time implements Comparable<Time> {

    @Id(value = "hour", name = "Hour", description = "Hour of the day")
    private Hour hour;

    @Id(value = "minute", name = "Minute", description = "Minute of the hour")
    private Minute minute;

    @Id(value = "second", name = "Second", description = "Second of the day")
    private Second second;

    private Time() {}

    /**
     * @param hour the number of hours since midnight
     * @param minute the number of minutes since the beginning of the hour
     * @param second the number of seconds since the beginning of the minute
     */
    public Time(int hour, int minute, int second) {
        this(new Hour(hour), new Minute(minute), new Second(second));
    }

    /**
     * @param hour the number of hours since midnight
     * @param minute the number of minutes since the beginning of the hour
     * @param second the number of seconds since the beginning of the minute
     */
    public Time(Hour hour, Minute minute, Second second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /**
     * Gets the number of hours since midnight
     * @return the number of hours since midnight
     */
    public Hour getHour() {
        return hour;
    }

    /**
     * Gets the number of minutes since the beginning of the hour
     * @return the number of minutes since the beginning of the hour
     */
    public Minute getMinute() {
        return minute;
    }

    /**
     * Gets the number of seconds since the beginning of the minute
     * @return the number of seconds since the beginning of the minute
     */
    public Second getSecond() {
        return second;
    }

    /**
     * Calculates the different between this time and the given time
     * @param time the time to subtract
     * @return the number of milliseconds from the given time to this time
     */
    public long minus(Time time) {
        long result = 0;
        result += 60 * 60 * 1000 * (hour.get() - time.hour.get());
        result += 60 * 1000 * (minute.get() - time.minute.get());
        result += 1000 * (second.get() - time.second.get());
        return result;
    }

    @Override
    public String toString() {
        return hour + ":" + minute + ":" + second;
    }

    @Override
    public int compareTo(Time time) {
        if(time == null)
            return -1;
        if(hour.get() != time.hour.get())
            return hour.get() - time.hour.get();
        if(minute.get() != time.minute.get())
            return minute.get() - time.minute.get();
        return second.get() - time.second.get();
    }

    @IntegerWrap(min = 0, max = 23)
    public static class Hour {

        private int hour;

        public Hour() {}

        public Hour(int hour) {
            this.hour = hour;
        }

        public void set(int hour) {
            this.hour = hour;
        }

        public int get() {
            return hour;
        }
    }

    @IntegerWrap(min = 0, max = 59)
    public static class Minute {

        private int minute;

        public Minute() {}

        public Minute(int minute) {
            this.minute = minute;
        }

        public void set(int minute) {
            this.minute = minute;
        }

        public int get() {
            return minute;
        }
    }

    @IntegerWrap(min = 0, max = 59)
    public static class Second {

        private int second;

        public Second() {}

        public Second(int second) {
            this.second = second;
        }

        public void set(int hour) {
            this.second = hour;
        }

        public int get() {
            return second;
        }
    }
}
