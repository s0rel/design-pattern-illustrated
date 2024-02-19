package org.sorel.designpattern.structural.adapter.objectadapter;

public class PrintBanner extends Print {
    private Banner banner;

    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParenthesis();
    }

    @Override
    public void printStrong() {
        banner.showWithAsterisk();
    }
}
