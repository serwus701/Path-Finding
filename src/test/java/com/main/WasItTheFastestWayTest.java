package com.main;

import org.junit.Assert;
import org.junit.Test;

public class WasItTheFastestWayTest {
    @Test
    public void addingPositionWith3SecondsAndTryingToAddSamePositionWith5Seconds() {
        //arrange
        WasItTheFastestWay wasItTheFastestWayTest = new WasItTheFastestWay();
        MyPath pathOne = new MyPath();
        MyPath pathTwo = new MyPath();
        pathOne.addStep(0, 0, 3);
        pathTwo.addStep(0, 0, 5);

        //act
        wasItTheFastestWayTest.KeepGoing(pathOne);

        //assert
        Assert.assertFalse(wasItTheFastestWayTest.KeepGoing(pathTwo));
    }

    @Test
    public void addingPositionWith3SecondsAndTryingToAddSamePositionWith3Seconds() {
        //arrange
        WasItTheFastestWay wasItTheFastestWayTest = new WasItTheFastestWay();
        MyPath pathOne = new MyPath();
        MyPath pathTwo = new MyPath();
        pathOne.addStep(0, 0, 3);
        pathTwo.addStep(0, 0, 3);

        //act
        wasItTheFastestWayTest.KeepGoing(pathOne);

        //assert
        Assert.assertFalse(wasItTheFastestWayTest.KeepGoing(pathTwo));
    }

    @Test
    public void addingPositionWith3SecondsAndTryingToAddSamePositionWith1Seconds() {
        //arrange
        WasItTheFastestWay wasItTheFastestWayTest = new WasItTheFastestWay();
        MyPath pathOne = new MyPath();
        MyPath pathTwo = new MyPath();
        pathOne.addStep(0, 0, 3);
        pathTwo.addStep(0, 0, 1);

        //act
        wasItTheFastestWayTest.KeepGoing(pathOne);

        //assert
        Assert.assertTrue(wasItTheFastestWayTest.KeepGoing(pathTwo));
    }
}
