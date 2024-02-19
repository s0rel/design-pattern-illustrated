package org.sorel.designpattern.structural.bridge;

public class Main {
    public static void main(String[] args) {
        String s = "Hello, China.";
        Display d1 = new Display(new StringDisplayImpl(s));
        Display d2 = new CountDisplay(new StringDisplayImpl(s));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl(s));
        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
        System.out.println();

        RandomCountDisplay d4 = new RandomCountDisplay(new StringDisplayImpl(s));
        d4.randomDisplay(5);
        System.out.println();

        CountDisplay d5 = new CountDisplay(new FileDisplayImpl("star.txt"));
        d5.multiDisplay(3);
        System.out.println();

        IncreaseDisplay d6 = new IncreaseDisplay(new CharDisplayImpl('<', '*', '>'), 1);
        IncreaseDisplay d7 = new IncreaseDisplay(new CharDisplayImpl('|', '#', '-'), 2);
        d6.increaseDisplay(4);
        d7.increaseDisplay(6);
    }
}
