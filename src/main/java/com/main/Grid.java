package com.main;

import java.io.*;

public class Grid {
    public FileManager myFileReader = new FileManager();

    private int xSize;
    private int ySize;

    private char[][] currentContainer;

    public void readDataFromFile() throws IOException {

        String strRead = myFileReader.readLine();
        String[] integerReadArray = strRead.split(" ");
        xSize = Integer.parseInt(integerReadArray[0]);
        ySize = Integer.parseInt(integerReadArray[1]);

        currentContainer = new char[xSize][ySize];

        for (int i = 0; i < ySize; i++) {
            strRead = myFileReader.readLine();
            for (int j = 0; j < xSize; j++) {
                currentContainer[j][i] = strRead.charAt(j);
            }
        }
    }

    public char getContainer(int x, int y) {
        return currentContainer[x][y];
    }

    public int getXSize() {
        return xSize;
    }

    public int getYSize() {
        return ySize;
    }
}
