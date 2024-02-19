package org.sorel.designpattern.behavioral.chainofresponsibility.linkedlist;


public class LimitSupporter extends Supporter {
    private int limit;

    public LimitSupporter(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() < limit;
    }
}
