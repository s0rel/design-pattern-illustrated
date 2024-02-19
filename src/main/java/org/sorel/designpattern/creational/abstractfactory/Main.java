package org.sorel.designpattern.creational.abstractfactory;

import org.sorel.designpattern.creational.abstractfactory.factory.Factory;
import org.sorel.designpattern.creational.abstractfactory.factory.Link;
import org.sorel.designpattern.creational.abstractfactory.factory.Page;
import org.sorel.designpattern.creational.abstractfactory.factory.Tray;
import org.sorel.designpattern.creational.abstractfactory.listfactory.ListFactory;
import org.sorel.designpattern.creational.abstractfactory.tablefactory.TableFactory;

public class Main {
    public static void main(String[] args) {
        createListPage("ListPage");
        createTablePage("TablePage");
        createYahooListPage("YahooListPage");
        createYahooTablePage("YahooTablePage");
    }

    public static void createListPage(String caption) {
        Factory factory = Factory.getFactory(ListFactory.class);
        createPage(factory, caption);
    }

    public static void createTablePage(String caption) {
        Factory factory = Factory.getFactory(TableFactory.class);
        createPage(factory, caption);
    }

    public static void createYahooListPage(String caption) {
        Factory factory = Factory.getFactory(ListFactory.class);
        Page page = factory.createYahooPage(caption);
        page.output();
    }

    public static void createYahooTablePage(String caption) {
        Factory factory = Factory.getFactory(TableFactory.class);
        Page page = factory.createYahooPage(caption);
        page.output();
    }

    private static void createPage(Factory factory, String caption) {
        Link people = factory.createLink("人民日报", "http://www.people.com.cn/");
        Link gmw = factory.createLink("光明日报", "http://www.gmw.cn/");

        Link yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
        Link jpYahoo = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp/");
        Link excite = factory.createLink("Excite", "http://www.excite.com/");
        Link google = factory.createLink("Google", "http://www.google.com/");

        Tray trayNews = factory.createTray("日报");
        trayNews.add(people);
        trayNews.add(gmw);

        Tray trayYahoo = factory.createTray("Yahoo!");
        trayYahoo.add(yahoo);
        trayYahoo.add(jpYahoo);

        Tray traySearch = factory.createTray("检索引擎");
        traySearch.add(trayYahoo);
        traySearch.add(excite);
        traySearch.add(google);

        Page page = factory.createPage(caption, "杨文轩");
        page.add(trayNews);
        page.add(traySearch);
        page.output();
    }
}
