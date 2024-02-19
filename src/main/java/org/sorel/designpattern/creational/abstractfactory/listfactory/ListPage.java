package org.sorel.designpattern.creational.abstractfactory.listfactory;

import org.sorel.designpattern.creational.abstractfactory.factory.Item;
import org.sorel.designpattern.creational.abstractfactory.factory.Page;

public class ListPage extends Page {
    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuilder builder = new StringBuilder();
        builder.append("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\"/>\n");
        builder.append("<html><head><title>" + title + "</title></head>\n");
        builder.append("<body>\n");
        builder.append("<h1>" + title + "</h1>\n");
        builder.append("<ul>\n");
        for (Item item : contents) {
            builder.append(item.makeHTML());
        }
        builder.append("</ul>\n");
        builder.append("<hr><address>" + author + "</address>");
        builder.append("</body></html>\n");
        return builder.toString();
    }
}
