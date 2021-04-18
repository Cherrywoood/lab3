import function.Function;

public class MethodInformation {
    private Function function;
    private double a;
    private double b;
    private double accuracy;
    private int flag;
    private int n;

    public MethodInformation(Function function, double a, double b, double accuracy, int flag, int n) {
        this.function = function;
        this.a = a;
        this.b = b;
        this.accuracy = accuracy;
        this.flag = flag;
        this.n = n;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
