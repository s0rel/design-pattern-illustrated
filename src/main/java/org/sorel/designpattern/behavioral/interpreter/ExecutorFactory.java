package org.sorel.designpattern.behavioral.interpreter;

public interface ExecutorFactory {
    Executor createExecutor(String name);
}
