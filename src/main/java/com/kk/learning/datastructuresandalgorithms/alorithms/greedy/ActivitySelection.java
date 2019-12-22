package com.kk.learning.datastructuresandalgorithms.alorithms.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {

    public List<Activity> select(List<Activity> activities){

        activities.sort(Comparator.comparingInt(Activity::getEndTime));
        List<Activity> result = new ArrayList<>();
        Activity previousActivity = activities.get(0);
        result.add(previousActivity);
        for(int i =1; i < activities.size(); i++){
            Activity currentActivity = activities.get(i);
            if(currentActivity.getStartTime() >= previousActivity.getEndTime()){
                result.add(currentActivity);
                previousActivity = currentActivity;
            }
        }
        return result;
    }
}
