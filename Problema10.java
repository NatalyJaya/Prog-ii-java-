import acm.graphics.GArc;
import acm.program.GraphicsProgram;

import java.awt.*;

public class Problema10 extends GraphicsProgram {

    public void run() {
        GArc ga = new GArc(0, 140,140, 140, 45, 270);
        ga.setFillColor(Color.YELLOW);
        ga.setFilled(true);
        ga.setColor(Color.ORANGE);

        add(ga);



        int i = 0;
        while(i < getWidth()-140){
            ga.setLocation(i, 80);
            pause(350);
            if(ga.getStartAngle() == 0){
                ga.setStartAngle(45);
                ga.setSweepAngle(270);
            }else{
                ga.setStartAngle(0);
                ga.setSweepAngle(360);
            }
            i+=70;
        }
        while(i >= 0){
            ga.setLocation(i, 80);
            pause(350);
            if(ga.getStartAngle() == -180){
                ga.setStartAngle(-135);
                ga.setSweepAngle(270);
            }else{
                ga.setStartAngle(-180);
                ga.setSweepAngle(360);
            }

            i-=70;
        }

    }

    public static void main(String[] args) {
        new Problema10().start(args);
    }
}
