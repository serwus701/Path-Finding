package com.main;

public class FastestPathFinder {
    public Grid myGrid = new Grid();
    private WasItTheFastestWay distanceChecking = new WasItTheFastestWay();

    private int xExitCoordinate;
    private int yExitCoordinate;


    public MyPath bestPath = new MyPath();

    public MyPath research(int xFrom, int yFrom, int xTo, int yTo) {
        xExitCoordinate = xTo;
        yExitCoordinate = yTo;

        distanceChecking = new WasItTheFastestWay();
        bestPath.setTime(Integer.MAX_VALUE);
        MyPath newPath = new MyPath();

        recurrentResearch(xFrom, yFrom, newPath);

        return bestPath;
    }

    private float typeToTime(char type) {
        return switch (type) {
            case 'H' -> 0.5F;
            case 'B' -> 1;
            case 'S' -> 2;
            default -> 999;
        };
    }

    private float getGreaterTime(char firstType, char secondType) {
        return Math.max(typeToTime(firstType), typeToTime(secondType));
    }

    private void recurrentResearch(int x, int y, MyPath myPath) {
        if ((xExitCoordinate == x) && (yExitCoordinate == y)) {
            if (bestPath.time > myPath.time) {
                bestPath.clonePath(myPath);
            }
        } else {

            if (x + 1 < myGrid.getXSize()) {
                MyPath anotherPath = new MyPath(myPath);
                float transitTime = getGreaterTime(myGrid.getContainer(x, y), myGrid.getContainer(x + 1, y));
                anotherPath.addStep(x + 1, y, transitTime);

                if (distanceChecking.KeepGoing(anotherPath) && (myGrid.getContainer(x + 1, y) != 'O'))
                    recurrentResearch(x + 1, y, anotherPath);
            }

            if (x - 1 >= 0) {
                MyPath anotherPath = new MyPath(myPath);
                float transitTime = getGreaterTime(myGrid.getContainer(x, y), myGrid.getContainer(x - 1, y));
                anotherPath.addStep(x - 1, y, transitTime);

                if (distanceChecking.KeepGoing(anotherPath) && (myGrid.getContainer(x - 1, y) != 'O'))
                    recurrentResearch(x - 1, y, anotherPath);
            }

            if (y + 1 < myGrid.getYSize()) {
                MyPath anotherPath = new MyPath(myPath);
                float transitTime = getGreaterTime(myGrid.getContainer(x, y), myGrid.getContainer(x, y + 1));
                anotherPath.addStep(x, y + 1, transitTime);

                if (distanceChecking.KeepGoing(anotherPath) && (myGrid.getContainer(x, y + 1) != 'O'))
                    recurrentResearch(x, y + 1, anotherPath);
            }

            if (y - 1 >= 0) {
                MyPath anotherPath = new MyPath(myPath);
                float transitTime = getGreaterTime(myGrid.getContainer(x, y), myGrid.getContainer(x, y - 1));
                anotherPath.addStep(x, y - 1, transitTime);

                if (distanceChecking.KeepGoing(anotherPath) && (myGrid.getContainer(x, y - 1) != 'O'))
                    recurrentResearch(x, y - 1, anotherPath);
            }
        }
    }


}
