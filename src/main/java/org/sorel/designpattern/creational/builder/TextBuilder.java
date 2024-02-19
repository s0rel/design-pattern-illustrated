package org.sorel.designpattern.creational.builder;

public class TextBuilder extends Builder {
    private final StringBuilder builder = new StringBuilder();

    @Override
    protected void buildTitle(String title) {
        builder.append("==============================\n");
        builder.append("『" + title + "』\n");
        builder.append("\n");
    }

    @Override
    protected void buildString(String string) {
        builder.append('■' + string + "\n");
        builder.append("\n");
    }

    @Override
    protected void buildItems(String[] items) {
        for (String item : items) {
            builder.append("　・" + item + "\n");
        }
        builder.append("\n");
    }

    @Override
    protected void buildDone() {
        builder.append("==============================\n");
    }

    public String getResult() {
        return builder.toString();
    }
}
