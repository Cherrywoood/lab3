package function;

public class FifthFunction implements Function, InfiniteGapFunction{
    public double f(double x) {
        return 1/x;
    }

    public double derivative(double x) {
        return -1/Math.pow(x,2);
    }
}
