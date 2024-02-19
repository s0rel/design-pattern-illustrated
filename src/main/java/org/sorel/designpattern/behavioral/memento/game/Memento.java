package org.sorel.designpattern.behavioral.memento.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Memento implements Serializable {
    private int money;
    private List<String> fruits;

    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    public int getMoney() {
        return money;
    }

    List<String> getFruits() {
        return new ArrayList<>(fruits);
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }
}
