package org.sorel.designpattern.behavioral.chainofresponsibility.array;


public class NoSupporter extends Supporter {
    public NoSupporter(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
