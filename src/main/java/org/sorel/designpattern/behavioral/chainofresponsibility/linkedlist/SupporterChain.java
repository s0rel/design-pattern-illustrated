package org.sorel.designpattern.behavioral.chainofresponsibility.linkedlist;

public class SupporterChain {
    private Supporter head = null;
    private Supporter tail = null;

    public void addSupport(Supporter support) {
        support.setNext(null);

        if (head == null) {
            head = support;
            tail = support;
            return;
        }

        tail.setNext(support);
        tail = support;
    }

    public void support(Trouble trouble) {
        if (head != null) {
            head.support(trouble);
        }
    }

    protected void done(Trouble trouble, Supporter supporter) {
        System.out.println(trouble + " is resolved by " + supporter + ".");
    }

    protected void fail(Trouble trouble) {
        System.out.println(trouble + " can't be resolved.");
    }
}
