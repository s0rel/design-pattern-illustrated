package org.sorel.designpattern.creational.prototype;

import org.sorel.designpattern.creational.prototype.framework.Manager;
import org.sorel.designpattern.creational.prototype.framework.Product;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen underlinePen = new UnderlinePen('~');
        MessageBox warningBox = new MessageBox('*');
        MessageBox slashBox = new MessageBox('/');
        manager.register("strong message", underlinePen);
        manager.register("warning box", warningBox);
        manager.register("slash box", slashBox);

        Product p1 = manager.create("strong message");
        p1.use("Hello, world.");
        Product p2 = manager.create("warning box");
        p2.use("Hello, world.");
        Product p3 = manager.create("slash box");
        p3.use("Hello, world.");
    }
}
