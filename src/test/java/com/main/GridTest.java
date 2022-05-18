package com.main;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class GridTest {
    @Test
    public void afterReadingDataFromFileGrid1Container00ShouldBeH() throws IOException {
        //arrange
        Grid gridTest = new Grid();
        gridTest.myFileReader.openFile("grid-1.txt");

        //act
        gridTest.readDataFromFile();

        //assert
        Assert.assertEquals(gridTest.getContainer(0, 0), 'H');

    }

    @Test
    public void afterReadingDataFromFileGrid1Container32ShouldBeS() throws IOException {
        //arrange
        Grid gridTest = new Grid();
        gridTest.myFileReader.openFile("grid-1.txt");

        //act
        gridTest.readDataFromFile();

        //assert
        Assert.assertEquals(gridTest.getContainer(3, 2), 'S');

    }

    @Test
    public void afterReadingDataFromFileGrid1XSizeShouldBe4() throws IOException {
        //arrange
        Grid gridTest = new Grid();
        gridTest.myFileReader.openFile("grid-1.txt");

        //act
        gridTest.readDataFromFile();

        //assert
        Assert.assertEquals(gridTest.getXSize(), 4);

    }

    @Test
    public void afterReadingDataFromFileGrid1YSizeShouldBe3() throws IOException {
        //arrange
        Grid gridTest = new Grid();
        gridTest.myFileReader.openFile("grid-1.txt");

        //act
        gridTest.readDataFromFile();

        //assert
        Assert.assertEquals(gridTest.getYSize(), 3);

    }
}
