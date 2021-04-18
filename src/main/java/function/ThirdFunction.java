package function;

public class ThirdFunction implements Function {
    public double f(double x) {
        return 4 * Math.pow(x, 3) - 5 * Math.pow(x, 2) + 6 * x - 7;
    }

    public double derivative(double x) {
        return 12 * Math.pow(x, 2) - 10 * x + 6;
    }
}
