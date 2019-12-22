package com.kk.learning.datastructuresandalgorithms.alorithms.greedy;

import java.util.Objects;

public class Activity {
    private int startTime;
    private int endTime;

    public Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return startTime == activity.startTime &&
                endTime == activity.endTime;
    }

    @Override
    public int hashCode() {

        return Objects.hash(startTime, endTime);
    }
}
