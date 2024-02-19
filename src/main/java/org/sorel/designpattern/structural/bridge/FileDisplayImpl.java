package org.sorel.designpattern.structural.bridge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileDisplayImpl extends DisplayImpl {
    private final int MAX_READAHEAD_LIMIT = 4096;
    private String fileName;
    private BufferedReader reader;

    public FileDisplayImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void rawOpen() {
        try {
            reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(fileName)));
            reader.mark(MAX_READAHEAD_LIMIT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("=-=-=-=-=-= " + fileName + " =-=-=-=-=-=");
    }

    @Override
    public void rawPrint() {
        try {
            String line;
            reader.reset(); // 回到mark的位置
            while ((line = reader.readLine()) != null) {
                System.out.println("> " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rawClose() {
        System.out.println("=-=-=-=-=-= ");
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
