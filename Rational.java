import acm.program.CommandLineProgram;

public class Rational extends CommandLineProgram {
    private int x; //privat pq no vull que desde fora de la clase aquests atributs siguin accesibles de la clase
    private int y;

    public Rational(int x, int y) { //clase constructora -> rational
        this.x = x;
        this.y = y;
        normalize(); // una funcion para dejar que que el hecho de que los negativos los deje pal numerador asimismo que la simplificar
    }

    public Rational(int x){
        this(x, 1);
    }

    public Rational(){
        this(0,1);
    }

    private void normalize() {
        int mcd = mcd(x, y);

        this.x /= mcd;
        this.y /= mcd;
    }



    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void add(Rational r2) {
        x = (x * r2.y) + (r2.x * y);
        y = y * r2.y;
        normalize();
    }

    public void sub(Rational r) {
        this.x = (this.x * r.y) - (r.x * this.y);
        this.y = this.y * r.y;
    }

    public void mult(Rational r) {
        this.x *= r.x;
        this.y *= r.y;
    }

    public void div(Rational r) {
        this.x *= r.y;
        this.y *= r.x;
    }

    public static Rational add(Rational r1, Rational r2) {
        return new Rational((r1.x * r2.y) + (r2.x * r1.y), r1.y * r2.y);
    }

    public static Rational sub(Rational r1, Rational r2) {
        return new Rational((r1.x * r2.y) - (r2.x * r1.y), r1.y * r2.y);
    }

    public static Rational mult(Rational r1, Rational r2) {
        return new Rational(r1.x * r2.x, r1.y * r2.y);
    }

    public static Rational div(Rational r1, Rational r2) {
        return new Rational(r1.x * r2.y, r2.x * r1.y);
    }

    public static int mcd(int x, int y) {
        while (y != 0) {
            int aux = y;
            y = x % y;
            x = aux;
        }
        return x;
    }

    public String toString() {
        return "(" + x + "/" + y + ")";
    }
}
