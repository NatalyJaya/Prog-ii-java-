import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
import acm.graphics.GArc;
import java.awt.*;

public class prob10  extends GraphicsProgram{
    final static double TIMEOUT = 10.0;
    final static double MOUTH_TIMEOUT = 90.0;
    final static double PADDING = 0.3;
    final static int NUM_PACMANS = 1;
    double startAngle = 45;
    double sweepAngle = 270;

    public int rollDie(){
        RandomGenerator rgen = RandomGenerator.getInstance();
        return rgen.nextInt(1, 15);
    }

    public void run() {
    GArc[] PacMans = createPacMans();
    GArc winner = executeRace(PacMans);
    //showWinner(winner);
    }


    private GArc createPacMan (int i) {
        double laneHeight = (double) getHeight() / NUM_PACMANS;
        double diameter = laneHeight * (1 - PADDING);
        double y = (laneHeight - diameter) / 2 + i * laneHeight;
        GArc PacMan = new GArc(0.0,y, diameter, diameter, 45, 270);
        PacMan.setColor(Color.BLACK);
        PacMan.setFilled(true);
        PacMan.setFillColor(Color.YELLOW);
        return PacMan;
    }
    public GArc[] createPacMans() {
        GArc[] PacMans = new GArc [NUM_PACMANS];
        for (int i = 0; i < PacMans.length; i++) {
            PacMans[i] = createPacMan(i);
            add(PacMans[i]);


        }
        return PacMans;
    }

    public GArc executeRace(GArc[] PacMans) {
       GArc winner = null;
        waitForClick();
        while (winner == null) {
            movePacMans(PacMans);
            updateMouthState(PacMans);
            pause(TIMEOUT);

       }
        return winner;
    }

    public void movePacMans(GArc[] PacMans) {

        for (int i = 0; i < PacMans.length; i++) {
            double step = rollDie();
            double newX = PacMans[i].getX() + step;

            // Verificar si ha alcanzado el extremo derecho o izquierdo

            PacMans[i].move(step, 0.0);
        }

    }

    public void updateMouthState(GArc[] PacMans) {
        for (GArc pacman : PacMans) {
            if (startAngle == 45) {

                startAngle = 0;
                sweepAngle = 360;
            } else {

                startAngle = 45;
                sweepAngle = 270;
            }
            pause(MOUTH_TIMEOUT);
            pacman.setStartAngle(startAngle);
            pacman.setSweepAngle(sweepAngle);
        }
    }


    public static void main(String[] args) {
        new prob10().start(args);
    }

}

