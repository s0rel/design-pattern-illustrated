package org.sorel.designpattern.creational.abstractfactory.listfactory;

import org.sorel.designpattern.creational.abstractfactory.factory.Item;
import org.sorel.designpattern.creational.abstractfactory.factory.Tray;

public class ListTray extends Tray {
    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder builder = new StringBuilder();
        builder.append("<li>\n");
        builder.append(caption + "\n");
        builder.append("<ul>\n");
        for (Item item : super.getTrays()) {
            builder.append(item.makeHTML());
        }
        builder.append("</ul>\n");
        builder.append("</li>\n");
        return builder.toString();
    }
}
