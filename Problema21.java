import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import java.awt.*; // igual con import java.awt.Color;


public class Problema21 extends GraphicsProgram{
    public double TIMEOUT = 1000.0;

    public void run() {
        // Tamaño del rectángulo
        int rectWidth = 60;
        int rectHeight = 50;

        // Coordenadas para situar el rectángulo en el centro
        int x = (getWidth() - rectWidth) / 2;
        int y = (getHeight() - rectHeight) / 2;


        // RECTANGULO CREADO
        GRect rectangulo = new GRect(x, y, rectWidth, rectHeight);

        rectangulo.setFilled(true);
        rectangulo.setFillColor(Color.RED);
        rectangulo.setColor(Color.RED);

        add(rectangulo);
        int sentido = 1;
        while (true) {
            rectangulo.move(10 * sentido, 0);
            pause(50);

            if (rectangulo.getX() <= 0 || rectangulo.getX() + rectWidth >= getWidth()) {
                //rectangulo.getX() <= 0 verifica que este en extremo izqueirdo
                //rectangulo.getX() + rectWidth >= getWidth()) verifica esta en el extremo derecho
                // Cambiar la dirección para simular el rebote
                sentido *= -1; //(+ * - = - )( - * - = +)
            }

            pause(50);// Pequeña pausa para visualizar el movimiento
            }
        }

        public static void main (String[] args) {
        new Problema21().start(args);
        }
    }




