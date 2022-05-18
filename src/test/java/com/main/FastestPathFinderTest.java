package com.main;

import org.junit.Test;

import org.junit.Assert;

import java.io.IOException;

public class FastestPathFinderTest {
    @Test
    public void timeBetween00And02InGrid1ShouldBe2point5() throws IOException {
        //arrange
        FastestPathFinder fastestPathFinder = new FastestPathFinder();

        fastestPathFinder.myGrid.myFileReader.openFile("grid-1.txt");
        fastestPathFinder.myGrid.readDataFromFile();

        //act
        float myTime = fastestPathFinder.research(0, 0, 2, 0).time;

        //assert
        Assert.assertEquals(2.5, myTime, 0.1);
    }

    @Test
    public void timeBetween00And32InGrid1ShouldBe5() throws IOException {
        //arrange
        FastestPathFinder fastestPathFinder = new FastestPathFinder();

        fastestPathFinder.myGrid.myFileReader.openFile("grid-1.txt");
        fastestPathFinder.myGrid.readDataFromFile();

        //act
        float myTime = fastestPathFinder.research(0, 0, 3, 2).time;

        //assert
        Assert.assertEquals(5, myTime, 0.1);
    }

    @Test
    public void timeBetween32And30InGrid1ShouldBe2point5() throws IOException {
        //arrange
        FastestPathFinder fastestPathFinder = new FastestPathFinder();

        fastestPathFinder.myGrid.myFileReader.openFile("grid-1.txt");
        fastestPathFinder.myGrid.readDataFromFile();

        //act
        float myTime = fastestPathFinder.research(3, 2, 3, 0).time;

        //assert
        Assert.assertEquals(2.5, myTime, 0.1);
    }

    @Test
    public void timeBetween00And00InGrid1ShouldBe0() throws IOException {
        //arrange
        FastestPathFinder fastestPathFinder = new FastestPathFinder();

        fastestPathFinder.myGrid.myFileReader.openFile("grid-1.txt");
        fastestPathFinder.myGrid.readDataFromFile();

        //act
        float myTime = fastestPathFinder.research(0, 0, 0, 0).time;

        //assert
        Assert.assertEquals(0, myTime, 0.1);
    }
}
