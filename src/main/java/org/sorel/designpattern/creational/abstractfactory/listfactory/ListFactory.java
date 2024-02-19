package org.sorel.designpattern.creational.abstractfactory.listfactory;

import org.sorel.designpattern.creational.abstractfactory.factory.Factory;
import org.sorel.designpattern.creational.abstractfactory.factory.Link;
import org.sorel.designpattern.creational.abstractfactory.factory.Page;
import org.sorel.designpattern.creational.abstractfactory.factory.Tray;

public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
