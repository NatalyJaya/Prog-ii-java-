import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import java.awt.Color;
import acm.util.RandomGenerator;

public class Problema22 extends GraphicsProgram {
   // public double FIN1 = 1000.0, FIN2 = 1000000.0;
   double TIMEOUT = 10.0;
    double PADDING = 0.3;
    int NUM_TURTLES = 10;
    public int rollDie(){
        RandomGenerator rgen = RandomGenerator.getInstance();
        return rgen.nextInt(1, 6);
    }


public void run () {
        GOval[] turtles = createTurtles();
        GOval winner = executeRace(turtles);
        showWinner(winner);

}
    private GOval createTurtle(int i) {
        double laneHeight = (double) getHeight() / NUM_TURTLES;
        double diameter = laneHeight * (1 - PADDING);
        double y = (laneHeight - diameter) / 2 + i * laneHeight;
        GOval turtle = new GOval(0.0, y, diameter, diameter);
        turtle.setColor(Color.ORANGE);
        turtle.setFilled(true);
        turtle.setFillColor(Color.GREEN);
        return turtle;
    }
public GOval[] createTurtles() {
GOval[] turtles = new GOval[NUM_TURTLES];
for (int i = 0; i < turtles.length; i++) {
    turtles[i] = createTurtle(i);
    add(turtles[i]);
}
return turtles;
}


public GOval executeRace(GOval[] turtles){
    GOval winner = null;
    waitForClick();
    while (winner == null) {
        moveTurtles(turtles);
        pause(TIMEOUT);
        winner = getWinnerIfAny(turtles);
    }
    return winner;
}

public void moveTurtles(GOval[] turtles) {
    for ( int i = 0; i < turtles.length; i++) {
        double step = rollDie();
        turtles[i].move(step, 0.0);
    }
}
public GOval getWinnerIfAny(GOval[] turtles) {
    GOval rightmostTurtle = rightmostTurtle(turtles);
    if (rightmostTurtle != null && hasFinished(rightmostTurtle)) {
        return rightmostTurtle;
    } else {
        return null;
    }
}
public GOval rightmostTurtle(GOval[] turtles) {
    GOval rightmostTurtle = null;
    double rightmostPosition = 0;
    for (int i = 0; i < turtles.length; i++) {
        double position = turtles[i].getX();
        if (position >= rightmostPosition) {
            rightmostPosition = position;
            rightmostTurtle = turtles[i];
        }
    }
    return rightmostTurtle;
}
public boolean hasFinished(GOval turtle) {
    return turtle.getX() + turtle.getWidth() >= getWidth();
}
private void showWinner(GOval winner){
    winner.setFillColor(Color.RED);
}
    public static void main(String[] args) {
        new Problema22().start(args);
    }

}




