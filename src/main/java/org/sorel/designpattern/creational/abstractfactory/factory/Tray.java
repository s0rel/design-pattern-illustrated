package org.sorel.designpattern.creational.abstractfactory.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Tray extends Item {
    private List<Item> trays = new ArrayList<>();

    public Tray(String caption) {
        super(caption);
    }

    public List<Item> getTrays() {
        return trays;
    }

    public int getTraySize() {
        return trays.size();
    }

    public void add(Item item) {
        trays.add(item);
    }
}
