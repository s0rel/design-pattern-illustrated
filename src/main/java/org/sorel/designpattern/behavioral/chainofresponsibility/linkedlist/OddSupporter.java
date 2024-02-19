package org.sorel.designpattern.behavioral.chainofresponsibility.linkedlist;

public class OddSupporter extends Supporter {
    public OddSupporter(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() % 2 == 1;
    }
}
