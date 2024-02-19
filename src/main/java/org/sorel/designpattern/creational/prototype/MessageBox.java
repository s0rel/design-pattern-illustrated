package org.sorel.designpattern.creational.prototype;

import org.sorel.designpattern.creational.prototype.framework.Product;

public class MessageBox extends Product {
    private char decorativeChar;

    public MessageBox(char decorativeChar) {
        this.decorativeChar = decorativeChar;
    }

    @Override
    public void use(String s) {
        int length = s.length();
        for (int i = 0; i < length + 4; i++) {
            System.out.print(decorativeChar);
        }
        System.out.println();
        System.out.println(decorativeChar + " " + s + " " + decorativeChar);
        for (int i = 0; i < length + 4; i++) {
            System.out.print(decorativeChar);
        }
        System.out.println();
    }
}
