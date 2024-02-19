package org.sorel.designpattern.behavioral.observer;

public class IncrementalNumberGenerator extends NumberGenerator {
    private int number;
    private int end;
    private int increment;

    public IncrementalNumberGenerator(int start, int end, int increment) {
        this.number = start;
        this.end = end;
        this.increment = increment;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        while (number < end) {
            notifyObservers();
            number += increment;
        }
    }
}
