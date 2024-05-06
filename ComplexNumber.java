import acm.program.CommandLineProgram;

public class ComplexNumber extends CommandLineProgram {

    private double r; // numero real
    private double i; // numero complejo

    private double mod;
    private double arg;

    public void sum(ComplexNumber cn){
        i += cn.i;
        r += cn.r;

        this.setMod(r, i);
        this.setArg(r, i);
        println(this.toString());
    }
    public void sub(ComplexNumber cn){
        i -= cn.i;
        r -= cn.r;

        this.setMod(r, i);
        this.setArg(r, i);
        println(this.toString());
    }

    public void mlt(ComplexNumber cn){
        mod *= cn.mod;
        arg += cn.arg;

        this.setR(mod, arg);
        this.setI(mod, arg);
        println(this.toString());
    }

    public void div(ComplexNumber cn){
        if(cn.mod != 0){
            mod /= cn.mod;
            arg -= cn.arg;

            this.setR(mod, arg);
            this.setI(mod, arg);

            println(this.toString());
        }else println("Por algún motivo estoy dividiendo por 0, operación no valida ");
    }


    @Override
    public String toString() {
        r    = roundDecimals(r);
        i    = roundDecimals(i);
        arg  = roundDecimals(arg);
        mod  = roundDecimals(mod);

        return  ((r>0) ? r : (r<0) ? "- "+r*(-1):"")
                + (i>0.0 ? (" + "+(i)) : (i<0.0) ? " - "+(i*-1) : "")
                +("j  <=======>  ")+mod+" /__ "+arg+"º";
    }

    private double roundDecimals(double n){ // redondear decimales y limitarlos a 2.
        int d = 2; // decimales deseados
        return Math.round(n * Math.pow(10, d)) / Math.pow(10, d);
    }

    public ComplexNumber(double r, double i) {
        this.r = r;
        this.i = i;

        this.setMod(r, i);
        this.setArg(r, i);
    }

    public double getR() {
        return r;
    }

    public double getI() {
        return i;
    }

    public double getMod() {
        return mod;
    }

    public void setMod(double r, double i) {
        mod = Math.sqrt(r*r + i*i);
    }

    public void setR(double m, double a) {
        r = m * Math.cos(a);
    }

    public void setI(double m, double a) {
        i = m * Math.sin(a);
    }

    public double getArg() {
        return arg;
    }

    public void setArg(double r, double i) {
        arg = Math.toDegrees(Math.atan(i / r));
    }
}
