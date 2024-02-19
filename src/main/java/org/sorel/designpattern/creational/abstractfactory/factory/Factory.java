package org.sorel.designpattern.creational.abstractfactory.factory;

public abstract class Factory {
    public static Factory getFactory(Class clazz) {
        Factory factory = null;
        try {
            factory = (Factory) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }

    public abstract Link createLink(String caption, String url);

    public abstract Tray createTray(String caption);

    public abstract Page createPage(String caption, String url);

    public Page createYahooPage(String caption) {
        Link link = createLink(caption, "http://www.yahoo.com/");
        Page page = createPage(caption, "Yahoo!");
        page.add(link);
        return page;
    }
}
