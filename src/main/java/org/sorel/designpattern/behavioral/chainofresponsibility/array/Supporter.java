package org.sorel.designpattern.behavioral.chainofresponsibility.array;

public abstract class Supporter {
    private String name;

    public Supporter(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Supporter{" +
                "name='" + name + '\'' +
                '}';
    }

    public boolean support(Trouble trouble) {
        if (resolve(trouble)) {
            return true;
        } else {
            return false;
        }
    }

    protected abstract boolean resolve(Trouble trouble);
}
