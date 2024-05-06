import acm.graphics.GArc;
import acm.program.CommandLineProgram;
import acm.program.GraphicsProgram;

public class Problema11 extends GraphicsProgram {
    private  int PACMAN_LENGTH= 60;
    private  int INITIAL_POS_Y = 30;
    private  int COUNT_PACMANS = 5;
    private  int OFFSET = 80;
    private double START_ARC_OM = 45; // BOCA ABIERTA
    private double SWEET_ARC_OM = 270;

    private double START_ARC_CM = 0; // BOCA CERRADA
    private double SWEET_ARC_CM = 360;


    public void run() {

        PacMan[] gp = new PacMan[COUNT_PACMANS];
        int d = INITIAL_POS_Y;
        for (int i = 0; i < gp.length; i++) {
            gp[i] = new PacMan(d, PACMAN_LENGTH, START_ARC_OM, SWEET_ARC_OM, i+1);
            gp[i].addToCanvas(this);
            d += OFFSET;
        }

        double i = 0;
        while(i <= getWidth()-PACMAN_LENGTH){
            for (int j = 0; j <gp.length ; j++) gp[j].move();
            i = PacMan.getRightExtremos(gp);
        }
        PacMan.declareWinner(gp, i);
    }

    public static void main(String[] args) {
        new Problema11().start(args);
    }
}
