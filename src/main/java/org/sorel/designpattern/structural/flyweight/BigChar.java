package org.sorel.designpattern.structural.flyweight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BigChar {
    private char charName;
    private String fontData;

    public BigChar(char charName) {
        this.charName = charName;
        InputStreamReader inputStreamReader = new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("big" + charName + ".txt"));
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
            }
            this.fontData = builder.toString();
        } catch (IOException e) {
            this.fontData = charName + "?";
        }
    }

    public void print() {
        System.out.print(fontData);
    }
}
