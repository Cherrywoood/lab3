package function;

public interface Function {
    public double f(double x);
    public double derivative(double x);
    public default Double getBreakPoint(double a, double b) {
        for (double i = a; i <= b; i+=0.5) {
            if(Double.isInfinite(Math.abs(f(i))) || Double.isNaN(Math.abs(f(i)))) return i;
        }
        return null;
    }
    public default boolean isOddFunction(double a, double b) {
        for (double i = a; i <= b; i+=0.5) {
            if(f(-i) != - f(i)) return false;
        }
        return true;
    }
}
