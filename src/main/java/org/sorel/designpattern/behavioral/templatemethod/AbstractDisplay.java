package org.sorel.designpattern.behavioral.templatemethod;

public abstract class AbstractDisplay {
    public abstract void open();

    public abstract void print();

    public abstract void close();

    // 添加 final 修饰符保证子类无法重写该方法
    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }

}
