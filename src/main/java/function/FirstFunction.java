package function;

public class FirstFunction implements Function {
    public double f(double x) {
        return Math.pow(x, 2);
    }
    public double derivative(double x) {return 2*x;}
}
