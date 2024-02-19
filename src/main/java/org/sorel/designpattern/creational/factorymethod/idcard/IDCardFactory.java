package org.sorel.designpattern.creational.factorymethod.idcard;

import org.sorel.designpattern.creational.factorymethod.framework.Factory;
import org.sorel.designpattern.creational.factorymethod.framework.Product;

import java.util.HashMap;
import java.util.Map;

public class IDCardFactory extends Factory {
    private Map<Integer, String> database = new HashMap<>();
    private int serial = 100;

    @Override
    protected synchronized Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }

    @Override
    protected void registerProduct(Product product) {
        IDCard card = (IDCard) product;
        database.put(card.getSerial(), card.getOwner());
    }

    public Map<Integer, String> getDatabase() {
        return database;
    }
}
