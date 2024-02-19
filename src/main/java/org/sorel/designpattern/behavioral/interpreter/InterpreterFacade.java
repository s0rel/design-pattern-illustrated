package org.sorel.designpattern.behavioral.interpreter;

public class InterpreterFacade implements Executor {
    private final ExecutorFactory factory;
    private Context context;
    private Node programNode;

    public InterpreterFacade(ExecutorFactory factory) {
        this.factory = factory;
    }

    public boolean parse(String text) {
        boolean status = true;
        this.context = new Context(text);
        this.context.setExecutorFactory(factory);
        this.programNode = new ProgramNode();
        try {
            programNode.parse(context);
            System.out.println(programNode.toString());
        } catch (ParseException e) {
            e.printStackTrace();
            status = false;
        }
        return status;
    }

    @Override
    public void execute() throws ExecuteException {
        try {
            programNode.execute();
        } catch (ExecuteException e) {
            e.printStackTrace();
        }
    }
}