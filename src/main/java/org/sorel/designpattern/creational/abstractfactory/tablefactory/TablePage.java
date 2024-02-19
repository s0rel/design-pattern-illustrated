package org.sorel.designpattern.creational.abstractfactory.tablefactory;

import org.sorel.designpattern.creational.abstractfactory.factory.Item;
import org.sorel.designpattern.creational.abstractfactory.factory.Page;

public class TablePage extends Page {
    public TablePage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuilder builder = new StringBuilder();
        builder.append("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\"/>\n");
        builder.append("<html><head><title>" + title + "</title></head>\n");
        builder.append("<body>\n");
        builder.append("<h1>" + title + "</h1>\n");
        builder.append("<table width=\"80%\" border=\"3\">\n");
        for (Item item : contents) {
            builder.append("<tr>" + item.makeHTML() + "</tr>");
        }
        builder.append("</table>\n");
        builder.append("<hr><address>" + author + "</address>");
        builder.append("</body></html>\n");
        return builder.toString();
    }
}
