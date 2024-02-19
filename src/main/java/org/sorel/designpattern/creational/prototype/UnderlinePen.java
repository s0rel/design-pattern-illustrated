package org.sorel.designpattern.creational.prototype;

import org.sorel.designpattern.creational.prototype.framework.Product;

public class UnderlinePen extends Product {
    private char underlineChar;

    public UnderlinePen(char underlineChar) {
        this.underlineChar = underlineChar;
    }

    @Override
    public void use(String s) {
        int length = s.length();
        System.out.println("\"" + s + "\"");
        for (int i = 0; i < length + 4; i++) {
            System.out.print(underlineChar);
        }
        System.out.println();
    }
}
