package org.sorel.designpattern.behavioral.strategy;

public interface Strategy {
    Hand nextHand();

    void study(boolean win);
}
