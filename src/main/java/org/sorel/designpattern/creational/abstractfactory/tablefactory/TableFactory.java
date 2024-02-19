package org.sorel.designpattern.creational.abstractfactory.tablefactory;

import org.sorel.designpattern.creational.abstractfactory.factory.Factory;
import org.sorel.designpattern.creational.abstractfactory.factory.Link;
import org.sorel.designpattern.creational.abstractfactory.factory.Page;
import org.sorel.designpattern.creational.abstractfactory.factory.Tray;

public class TableFactory extends Factory {
    public Link createLink(String caption, String url) {
        return new TableLink(caption, url);
    }

    public Tray createTray(String caption) {
        return new TableTray(caption);
    }

    public Page createPage(String title, String author) {
        return new TablePage(title, author);
    }
}
