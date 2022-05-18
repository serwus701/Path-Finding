package com.main;

import java.io.IOException;
import java.util.ArrayList;


public class WhichProductDecision {
    private int xWhereIStarted;
    private int yWhereIStarted;

    private int xExitStation;
    private int yExitStation;

    private String productIAmLookingFor;

    private final ArrayList<Integer> xPositions = new ArrayList<>();
    private final ArrayList<Integer> yPositions = new ArrayList<>();
    private final ArrayList<Integer> depths = new ArrayList<>();

    FastestPathFinder timeCountingMachine = new FastestPathFinder();

    private void readRobotData() throws IOException {
        String coordinatesStr = timeCountingMachine.myGrid.myFileReader.readLine();
        String[] coordinatesArr = coordinatesStr.split(" ");
        xWhereIStarted = Integer.parseInt(coordinatesArr[0]);
        yWhereIStarted = Integer.parseInt(coordinatesArr[1]);

        coordinatesStr = timeCountingMachine.myGrid.myFileReader.readLine();
        coordinatesArr = coordinatesStr.split(" ");
        xExitStation = Integer.parseInt(coordinatesArr[0]);
        yExitStation = Integer.parseInt(coordinatesArr[1]);

        productIAmLookingFor = timeCountingMachine.myGrid.myFileReader.readLine();
    }

    private void readProductData() throws IOException {
        String read = timeCountingMachine.myGrid.myFileReader.readLine();
        while (read != null) {
            String[] readArray = read.split(" ");
            if (readArray[0].equals(productIAmLookingFor)) {
                xPositions.add(Integer.valueOf(readArray[1]));
                yPositions.add(Integer.valueOf(readArray[2]));
                depths.add(Integer.valueOf(readArray[3]));
            }
            read = timeCountingMachine.myGrid.myFileReader.readLine();
        }
    }

    private float getExtractingTime(int position) {
        char containerType = timeCountingMachine.myGrid.getContainer(xPositions.get(position), yPositions.get(position));
        return switch (containerType) {
            case 'H' -> 3 * depths.get(position) + 4;
            case 'B' -> 2 * depths.get(position) + 2;
            case 'S' -> depths.get(position) + 1;
            default -> 9999;
        };
    }

    private void startPreparations(String jobFileName, String gridFileName) {
        try {
            timeCountingMachine.myGrid.myFileReader.openFile(jobFileName);
            readRobotData();
            timeCountingMachine.myGrid.myFileReader.closeFile();

            timeCountingMachine.myGrid.myFileReader.openFile(gridFileName);
            timeCountingMachine.myGrid.readDataFromFile();
            readProductData();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printOutput(int bestTargetPosition, float bestExtractionTime, MyPath bestFirstPath, MyPath bestSecondPath) {
        System.out.println(bestTargetPosition);
        System.out.println((bestFirstPath.steps + bestSecondPath.steps));
        System.out.println((bestFirstPath.time + bestSecondPath.time + bestExtractionTime));
        System.out.println(xWhereIStarted + " " + yWhereIStarted);
        bestFirstPath.showPath();
        bestSecondPath.showPath();
    }

    public void start(String gridFileName, String jobFileName) {
        startPreparations(jobFileName, gridFileName);

        float bestTargetTime = Integer.MAX_VALUE;
        int bestTargetPosition = -1;
        MyPath bestFirstPath = new MyPath();
        MyPath bestSecondPath = new MyPath();
        float bestExtractionTime = -1;

        for (int i = 0; i < xPositions.size(); i++) {
            MyPath firstPath = new MyPath(timeCountingMachine.research(xWhereIStarted, yWhereIStarted, xPositions.get(i), yPositions.get(i)));
            float extractionTime = getExtractingTime(i);
            MyPath secondPath = new MyPath(timeCountingMachine.research(xPositions.get(i), yPositions.get(i), xExitStation, yExitStation));

            if (firstPath.time + secondPath.time + extractionTime < bestTargetTime) {
                bestTargetTime = firstPath.time + secondPath.time + extractionTime;
                bestTargetPosition = i;
                bestFirstPath = firstPath;
                bestSecondPath = secondPath;
                bestExtractionTime = extractionTime;
            }
        }
        printOutput(bestTargetPosition, bestExtractionTime, bestFirstPath, bestSecondPath);
    }
}
