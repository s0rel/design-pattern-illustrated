package org.sorel.designpattern.behavioral.interpreter;


import java.awt.*;

public class TurtleCanvas extends Canvas implements ExecutorFactory {
    final static int UNIT_LENGTH = 30;
    final static int DIRECTION_UP = 0;
    final static int DIRECTION_RIGHT = 3;
    final static int DIRECTION_DOWN = 6;
    final static int DIRECTION_LEFT = 9;
    final static int RELATIVE_DIRECTION_RIGHT = 3;
    final static int RELATIVE_DIRECTION_LEFT = -3;
    final static int RADIUS = 3;
    private int direction = 0;
    private Point position;
    private Executor executor;

    public TurtleCanvas(int width, int height) {
        setSize(width, height);
        initialize();
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    void setRelativeDirection(int relativeDirection) {
        setDirection(direction + relativeDirection);
    }

    void setDirection(int direction) {
        if (direction < 0) {
            direction = 12 - (-direction) % 12;
        } else {
            direction = direction % 12;
        }
        this.direction = direction % 12;
    }

    void go(int length) {
        int newx = position.x;
        int newy = position.y;
        switch (direction) {
            case DIRECTION_UP:
                newy -= length;
                break;
            case DIRECTION_RIGHT:
                newx += length;
                break;
            case DIRECTION_DOWN:
                newy += length;
                break;
            case DIRECTION_LEFT:
                newx -= length;
                break;
            default:
                break;
        }
        Graphics graphics = getGraphics();
        if (graphics != null) {
            graphics.drawLine(position.x, position.y, newx, newy);
            graphics.fillOval(newx - RADIUS, newy - RADIUS, RADIUS * 2 + 1, RADIUS * 2 + 1);
        }
        position.x = newx;
        position.y = newy;
    }

    @Override
    public Executor createExecutor(String name) {
        switch (name) {
            case "go":
                return new GoExecutor(this);
            case "right":
                return new DirectionExecutor(this, RELATIVE_DIRECTION_RIGHT);
            case "left":
                return new DirectionExecutor(this, RELATIVE_DIRECTION_LEFT);
            default:
                return null;
        }
    }

    public void initialize() {
        Dimension size = getSize();
        position = new Point(size.width / 2, size.height / 2);
        direction = 0;
        setForeground(Color.red);
        setBackground(Color.white);
        Graphics graphics = getGraphics();
        if (graphics != null) {
            graphics.clearRect(0, 0, size.width, size.height);
        }
    }

    @Override
    public void paint(Graphics graphics) {
        initialize();
        if (executor != null) {
            try {
                executor.execute();
            } catch (ExecuteException e) {
            }
        }
    }
}

abstract class TurtleExecutor implements Executor {
    protected TurtleCanvas canvas;

    protected TurtleExecutor(TurtleCanvas canvas) {
        this.canvas = canvas;
    }

    public abstract void execute();
}

class GoExecutor extends TurtleExecutor {
    public GoExecutor(TurtleCanvas canvas) {
        super(canvas);
    }

    @Override
    public void execute() {
        canvas.go(TurtleCanvas.UNIT_LENGTH);
    }
}

class DirectionExecutor extends TurtleExecutor {
    private final int relativeDirection;

    public DirectionExecutor(TurtleCanvas canvas, int relativeDirection) {
        super(canvas);
        this.relativeDirection = relativeDirection;
    }

    @Override
    public void execute() {
        canvas.setRelativeDirection(relativeDirection);
    }
}
