public class ResultInformation {
    private double integral;
    private int n;
    private double inaccuracy;

    public ResultInformation(double integral, int n, double inaccuracy) {
        this.integral = integral;
        this.n = n;
        this.inaccuracy = inaccuracy;
    }

    public double getIntegral() {
        return integral;
    }

    public void setIntegral(double integral) {
        this.integral = integral;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getInaccuracy() {
        return inaccuracy;
    }

    public void setInaccuracy(double inaccuracy) {
        this.inaccuracy = inaccuracy;
    }
}
