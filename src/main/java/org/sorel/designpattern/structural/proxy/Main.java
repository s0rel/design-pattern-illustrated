package org.sorel.designpattern.structural.proxy;

public class Main {
    public static void main(String[] args) {
        Printable printerProxy = new PrinterProxy("Alice", "org.sorel.designpattern.structural.proxy.Printer");
        System.out.println("现在的名字是" + printerProxy.getPrinterName() + "。");
        printerProxy.setPrinterName("Bob");
        System.out.println("现在的名字是" + printerProxy.getPrinterName() + "。");
        printerProxy.print("Hello, world.");
    }
}
