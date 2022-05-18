package com.main;

import org.junit.Assert;
import org.junit.Test;

public class MyPathTest {
    @Test
    public void addingFourPathStepsCheckingIfLengthIsFourAndTimeTwo() {
        //arrange
        MyPath myPathTester = new MyPath();

        //act
        myPathTester.addStep(0, 1, 0.5F);
        myPathTester.addStep(1, 1, 0.5F);
        myPathTester.addStep(2, 1, 0.5F);
        myPathTester.addStep(2, 2, 0.5F);

        //assert
        Assert.assertEquals(4, myPathTester.steps);
        Assert.assertEquals(2, myPathTester.time, 0.1);
    }

    @Test
    public void addingFourPathStepsCheckingIfLengthIsFourAndTimeZero() {
        //arrange
        MyPath myPathTester = new MyPath();

        //act
        myPathTester.addStep(0, 1, 0);
        myPathTester.addStep(1, 1, 0);
        myPathTester.addStep(2, 1, 0);
        myPathTester.addStep(2, 2, 0);

        //assert
        Assert.assertEquals(4, myPathTester.steps);
        Assert.assertEquals(0, myPathTester.time, 0.1);
    }

    @Test
    public void addingFourElementsAndReachingLastOnesThatMustEqualTwoAndTwo() {
        //arrange
        MyPath myPathTester = new MyPath();

        //act
        myPathTester.addStep(0, 1, 0);
        myPathTester.addStep(1, 1, 0);
        myPathTester.addStep(2, 1, 0);
        myPathTester.addStep(2, 2, 0);

        //assert
        Assert.assertEquals(2, myPathTester.getLastX());
        Assert.assertEquals(2, myPathTester.getLastY());
    }

    @Test
    public void reachingLastElementInEmptyArrayMustEqualMinusOne() {
        //arrange
        MyPath myPathTester = new MyPath();

        //assert
        Assert.assertEquals(-1, myPathTester.getLastX());
        Assert.assertEquals(-1, myPathTester.getLastY());
    }

    @Test
    public void cloningPathCheckingLastElementInClone() {
        //arrange
        MyPath myPathTester = new MyPath();

        myPathTester.addStep(0, 1, 0);
        myPathTester.addStep(1, 1, 0);
        myPathTester.addStep(2, 1, 0);
        myPathTester.addStep(2, 2, 0);

        //act
        MyPath cloneTestPath = new MyPath();
        cloneTestPath.clonePath(myPathTester);

        //assert
        Assert.assertEquals(2, cloneTestPath.getLastX());
        Assert.assertEquals(2, cloneTestPath.getLastY());
    }

    @Test
    public void cloningPathAddingNewElementInOriginalCheckingLastElementInClone() {
        //arrange
        MyPath myPathTester = new MyPath();
        MyPath cloneTestPath = new MyPath();

        myPathTester.addStep(0, 1, 0);
        myPathTester.addStep(1, 1, 0);
        myPathTester.addStep(2, 1, 0);
        myPathTester.addStep(2, 2, 0);

        //act
        cloneTestPath.clonePath(myPathTester);

        myPathTester.addStep(3, 3, 0);

        //assert
        Assert.assertEquals(2, cloneTestPath.getLastX());
        Assert.assertEquals(2, cloneTestPath.getLastY());
    }

    @Test
    public void setTimeMustEqualTwo() {
        //arrange
        MyPath myPathTester = new MyPath();

        //act
        myPathTester.setTime(2);

        //assert
        Assert.assertEquals(2, myPathTester.time, 0.1);
    }
}