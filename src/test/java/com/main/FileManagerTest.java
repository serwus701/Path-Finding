package com.main;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileManagerTest {
    @Test
    public void openingAndClosingFileShouldNotBeProblematic() throws IOException {
        //arrange
        FileManager fileManagerTest = new FileManager();
        int i = 1;

        //act
        fileManagerTest.openFile("grid-1.txt");
        fileManagerTest.closeFile();
        i = 0;

        //assert
        assertEquals(0, i);
    }

    @Test
    public void firstLineOfGrid1ShouldBe4_3_3() throws IOException {
        //arrange
        FileManager fileManagerTest = new FileManager();
        String read;
        fileManagerTest.openFile("grid-1.txt");

        //act
        read = fileManagerTest.readLine();

        //assert
        assertEquals("4 3 3", read);
    }
}
