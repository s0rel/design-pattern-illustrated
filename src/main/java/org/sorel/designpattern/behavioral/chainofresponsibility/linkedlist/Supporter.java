package org.sorel.designpattern.behavioral.chainofresponsibility.linkedlist;

public abstract class Supporter {
    private String name;

    private Supporter next;

    public Supporter(String name) {
        this.name = name;
    }

    public void setNext(Supporter next) {
        this.next = next;
    }

    public final void support(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    @Override
    public String toString() {
        return "Supporter{" +
                "name='" + name + '\'' +
                '}';
    }

    protected abstract boolean resolve(Trouble trouble);

    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    protected void fail(Trouble trouble) {
        System.out.println(trouble + " can't be resolved.");
    }
}
