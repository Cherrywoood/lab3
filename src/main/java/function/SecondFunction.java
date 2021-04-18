package function;

public class SecondFunction implements Function {
    public double f(double x) {
        return -Math.pow(x, 3) - Math.pow(x, 2) - 2 * x + 1;
    }

    public double derivative(double x) {
        return -3*Math.pow(x,2) - 2*x - 2;
    }
}
