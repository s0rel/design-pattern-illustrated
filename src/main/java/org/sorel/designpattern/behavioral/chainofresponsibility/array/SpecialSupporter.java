package org.sorel.designpattern.behavioral.chainofresponsibility.array;


public class SpecialSupporter extends Supporter {
    private int number;

    public SpecialSupporter(String name, int number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() == number;
    }
}
