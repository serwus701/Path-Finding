package com.main;

import java.util.ArrayList;

public class MyPath {
    private ArrayList<Integer> xPath = new ArrayList<>();
    private ArrayList<Integer> yPath = new ArrayList<>();
    public float time = 0;
    public int steps = 0;

    MyPath() {
    }

    MyPath(MyPath pathToCopy) {
        clonePath(pathToCopy);
    }

    public void setTime(int myTime) {
        time = myTime;
    }

    public int getLastX() {
        if (xPath.size() > 0)
            return xPath.get(xPath.size() - 1);
        else return -1;
    }

    public int getLastY() {
        if (yPath.size() > 0)
            return yPath.get(yPath.size() - 1);
        else return -1;
    }

    public void clonePath(MyPath pathToCopy) {
        xPath = (ArrayList<Integer>) pathToCopy.xPath.clone();
        yPath = (ArrayList<Integer>) pathToCopy.yPath.clone();
        time = pathToCopy.time;
        steps = pathToCopy.steps;
    }

    public void addStep(int x, int y, float transitTime) {
        xPath.add(x);
        yPath.add(y);
        time += transitTime;
        steps++;
    }

    public void showPath() {
        for (int i = 0; i < xPath.size(); i++) {
            System.out.println(xPath.get(i) + " " + yPath.get(i));
        }
    }
}
