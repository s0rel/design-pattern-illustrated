package org.sorel.designpattern.creational.abstractfactory.tablefactory;

import org.sorel.designpattern.creational.abstractfactory.factory.Item;
import org.sorel.designpattern.creational.abstractfactory.factory.Tray;

public class TableTray extends Tray {
    public TableTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<td>");
        sb.append("<table width=\"100%\" border=\"1\"><tr>");
        sb.append("<td bgcolor=\"#cccccc\" align=\"center\" colspan=\"" + super.getTraySize() + "\"><b>" + caption + "</b></td>");
        sb.append("</tr>\n");
        sb.append("<tr>\n");
        for (Item item : super.getTrays()) {
            sb.append(item.makeHTML());
        }
        sb.append("</tr></table>");
        sb.append("</td>");
        return sb.toString();
    }
}
