package function;

public class FourthFunction implements Function{
    public double f(double x) {
        return Math.sin(x)/x;
    }

    public double derivative(double x) {
        return (Math.cos(x)*x-Math.sin(x))/Math.pow(x,2);
    }
}
