package org.sorel.designpattern.behavioral.command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame implements ActionListener {
    private final MacroCommand history = new MacroCommand();
    private final DrawCanvas canvas = new DrawCanvas(400, 400, history);
    private final JButton clearButton = new JButton("clear");
    private final JButton undoButton = new JButton("undo");
    private final JButton redButton = new JButton("red");
    private final JButton greenButton = new JButton("green");
    private final JButton blueButton = new JButton("blue");

    public Main(String title) {
        super(title);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Command command = new DrawCommand(canvas, e.getPoint());
                history.append(command);
                command.execute();
            }
        });
        clearButton.addActionListener(this);
        undoButton.addActionListener(this);
        redButton.addActionListener(this);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(undoButton);
        buttonBox.add(redButton);
        buttonBox.add(greenButton);
        buttonBox.add(blueButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            history.clear();
            canvas.init();
            canvas.repaint();
        } else if (e.getSource() == undoButton) {
            history.undo();
            canvas.repaint();
        } else if (e.getSource() == redButton) {
            Command command = new ColorCommand(canvas, Color.red);
            history.append(command);
            command.execute();
        } else if (e.getSource() == greenButton) {
            Command command = new ColorCommand(canvas, Color.green);
            history.append(command);
            command.execute();
        } else if (e.getSource() == blueButton) {
            Command command = new ColorCommand(canvas, Color.blue);
            history.append(command);
            command.execute();
        }
    }

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
