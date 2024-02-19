package org.sorel.designpattern.structural.adapter.classadapter;

public class PrintBanner extends Banner implements Print {
    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        showWithParenthesis();
    }

    @Override
    public void printStrong() {
        showWithAsterisk();
    }
}
