package com.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

    private FileReader file;
    private BufferedReader br;

    public void openFile(String filePath) throws FileNotFoundException {
        file = new FileReader(filePath);
        br = new BufferedReader(file);
    }

    public void closeFile() throws IOException {
        file.close();
    }

    public String readLine() throws IOException {
        return br.readLine();
    }
}
