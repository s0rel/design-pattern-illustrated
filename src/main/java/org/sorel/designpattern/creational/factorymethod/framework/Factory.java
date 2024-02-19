package org.sorel.designpattern.creational.factorymethod.framework;

public abstract class Factory {
    protected abstract Product createProduct(String owner);

    protected abstract void registerProduct(Product product);

    // 使用模板模式声明创建产品的流程
    public final Product create(String owner) {
        Product product = createProduct(owner);
        registerProduct(product);
        return product;
    }
}
