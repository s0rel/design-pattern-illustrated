package org.sorel.designpattern.structural.composite;

public abstract class Entry {
    protected Entry parent;

    public abstract String getName();

    public abstract int getSize();

    protected abstract void printList(String prefix);

    public void printList() {
        printList("");
    }

    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    @Override
    public String toString() {
        return getName() + "(" + getSize() + ")";
    }

    public String getFullName() {
        StringBuilder fullName = new StringBuilder();
        Entry entry = this;
        do {
            fullName.insert(0, "/" + entry.getName());
            entry = entry.parent;
        } while (entry != null);
        return fullName.toString();
    }
}
