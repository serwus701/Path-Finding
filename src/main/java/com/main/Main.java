package com.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String gridFileName;
        String jobFileName;

        System.out.println("Input grid file name");
        gridFileName = myObj.nextLine();
        System.out.println("Input job file name");
        jobFileName = myObj.nextLine();
        WhichProductDecision myDecision = new WhichProductDecision();
        myDecision.start(gridFileName, jobFileName);
    }
}
