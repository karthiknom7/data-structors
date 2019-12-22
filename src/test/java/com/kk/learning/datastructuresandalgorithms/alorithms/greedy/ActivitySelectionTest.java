package com.kk.learning.datastructuresandalgorithms.alorithms.greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ActivitySelectionTest {

    @Test
    public void shouldSelectMoreActivity() {
        ActivitySelection activitySelection = new ActivitySelection();
        List<Activity> activities = Arrays.asList(new Activity(0,6), new Activity(1,2), new Activity(5,7), new Activity(3,5));
        List<Activity> expectedActivitess = Arrays.asList(new Activity(1,2), new Activity(3,5), new Activity(5,7));
        List<Activity> selectedActivities = activitySelection.select(activities);
        assertEquals(expectedActivitess, selectedActivities);
    }
}