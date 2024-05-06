import acm.graphics.GArc;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.*;

public class PacMan extends  GraphicsProgram{
    private final double cordsY;
    private double cordsX;
    private double length;
    private double stArc;
    private double swArc;
    private GArc gArc;
    private GLabel label;


    RandomGenerator randGen = RandomGenerator.getInstance();

    // constants
    private static final int INITIAL_POSITION = 0;
    private static final double TIMEOUT = 52;


    public PacMan(double cordsY, double length, double stArc, double swArc,int label) {
        this.cordsY = cordsY;
        this.length = length;
        this.stArc = stArc;
        this.swArc = swArc;

        gArc = new GArc(INITIAL_POSITION, cordsY, this.length, this.length, this.stArc, this.swArc);
        gArc.setColor(Color.ORANGE);
        gArc.setFilled(true);
        gArc.setFillColor(Color.YELLOW);

        this.label = new GLabel(String.valueOf(label), INITIAL_POSITION+(length-23)/2, cordsY + (length+3)/2);
    }


    public static double getRightExtremos(PacMan[] gt){
        double longest = 0;
        for (int i = 0; i < gt.length ; i++) {
            if(longest < gt[i].cordsX) longest = gt[i].cordsX;
        }
        return longest;
    }


    /**
     * Select and declare the winner. It will be change his color to Red.
     * */
    public static void declareWinner(PacMan[] gts, double d){
        for (int i = 0; i < gts.length; i++) {
            if(gts[i].cordsX >= d){
                gts[i].gArc.setFillColor(Color.MAGENTA);
                gts[i].gArc.setColor(Color.RED);
            }
        }
    }

    public void addToCanvas(GraphicsProgram program){
        program.add(this.gArc);
        program.add(this.label);
    }

    private void openMouth(){
        gArc.setStartAngle(45);
        gArc.setSweepAngle(270);
    }

    private void closeMouth(){
        gArc.setStartAngle(0);
        gArc.setSweepAngle(360);
    }

    public void move(){
        cordsX += randGen.nextInt(1, 6);
        if(gArc.getStartAngle() == 0)
            this.openMouth();
        else this.closeMouth();

        gArc.setLocation(cordsX, cordsY);
        label.setLocation(cordsX+(length-23)/2, cordsY + (length+3)/2);
        pause(TIMEOUT);
    }
}
