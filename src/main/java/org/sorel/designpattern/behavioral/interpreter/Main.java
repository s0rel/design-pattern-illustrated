package org.sorel.designpattern.behavioral.interpreter;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends Frame implements ActionListener {
    private final TurtleCanvas canvas = new TurtleCanvas(400, 400);
    private final InterpreterFacade facade = new InterpreterFacade(canvas);
    private final TextField programTextField = new TextField("program repeat 3 go right go left end end");

    public Main(String title) {
        super(title);

        canvas.setExecutor(facade);

        setLayout(new BorderLayout());

        programTextField.addActionListener(this);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        add(programTextField, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        pack();
        parseAndExecute();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == programTextField) {
            parseAndExecute();
        }
    }

    private void parseAndExecute() {
        String programText = programTextField.getText();
        System.out.println("programText = " + programText);
        facade.parse(programText);
        canvas.repaint();
    }

    public static void main(String[] args) {
        new Main("Interpreter Pattern Sample");
    }
}
