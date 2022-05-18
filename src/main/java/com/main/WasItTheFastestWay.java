package com.main;

import java.util.ArrayList;

public class WasItTheFastestWay {
    private final ArrayList<Integer> xCoordinates = new ArrayList<>();
    private final ArrayList<Integer> yCoordinates = new ArrayList<>();
    private final ArrayList<Float> minimalTimeToReach = new ArrayList<>();

    private void addNewPosition(int x, int y, float transitTime) {
        xCoordinates.add(x);
        yCoordinates.add(y);
        minimalTimeToReach.add(transitTime);
    }

    public boolean KeepGoing(MyPath myPath) {
        int x = myPath.getLastX();
        int y = myPath.getLastY();
        float distance = myPath.time;

        for (int i = 0; i < xCoordinates.size(); i++) {
            if ((xCoordinates.get(i) == x) && (yCoordinates.get(i) == y)) {
                if (minimalTimeToReach.get(i) > distance) {
                    minimalTimeToReach.set(i, distance);
                    return true;
                }
                return false;
            }
        }
        addNewPosition(x, y, distance);
        return true;
    }
}
