package org.sorel.designpattern.behavioral.visitor;

public interface Element {
    void accept(Visitor visitor);
}
