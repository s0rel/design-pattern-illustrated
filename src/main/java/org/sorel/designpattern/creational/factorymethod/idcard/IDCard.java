package org.sorel.designpattern.creational.factorymethod.idcard;

import org.sorel.designpattern.creational.factorymethod.framework.Product;

public class IDCard extends Product {
    private String owner;
    private int serial;

    // IDCard 的构造函数访问控制不是 public，这样可以强迫包外必须通过 IDCardFactory 来生成 IDCard 的实例
    IDCard(String owner, int serial) {
        System.out.println("制作" + owner + "(" + serial + ")" + "的ID卡。");
        this.owner = owner;
        this.serial = serial;
    }

    public String getOwner() {
        return owner;
    }

    public int getSerial() {
        return serial;
    }

    @Override
    public void use() {
        System.out.println("使用" + owner + "(" + serial + ")" + "的ID卡。");
    }
}
