package org.sorel.designpattern.creational.prototype.framework;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private final Map<String, Product> showcase = new HashMap<>();

    public void register(String name, Product prototype) {
        showcase.put(name, prototype);
    }

    public Product create(String prototypeName) {
        Product product = showcase.get(prototypeName);
        return product.createClone();
    }
}
