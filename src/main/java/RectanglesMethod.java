import function.Function;

public class RectanglesMethod {
//погрешность модуль???
    //определен интеграл или нет
    private static double maxDerivative;
    public static ResultInformation calculateLeft(Function function, double a, double b, double accuracy, int flag, int n) {
        double res_1 = calculateIntegralLeft(function, a, b, flag, n);
        double res_2 = 0;
        double inaccuracy = 0;
        while (true) {
            n *= 2;
            res_2 = calculateIntegralLeft(function, a, b, flag, n);
            inaccuracy = (b-a)/2*(b-a)/n*Math.max(maxDerivative,Math.abs(function.derivative(b)));
            if (Math.abs(res_2 - res_1) <= accuracy) break;
            res_1 = res_2;
        }
        return new ResultInformation(res_2, n, inaccuracy);
    }

    public static ResultInformation calculateRight(Function function, double a, double b, double accuracy, int flag, int n) {
        double res_1 = calculateIntegralRight(function, a, b, flag, n);
        double res_2 = 0;
        double inaccuracy = 0;
        while (true) {
            n *= 2;
            res_2 = calculateIntegralRight(function, a, b, flag, n);
            inaccuracy = (b-a)/2*(b-a)/n*Math.max(maxDerivative,Math.abs(function.derivative(a)));
            if (Math.abs(res_2 - res_1) <= accuracy) break;
            res_1 = res_2;
        }
        return new ResultInformation(res_2, n, inaccuracy);
    }

    public static ResultInformation calculateMiddle(Function function, double a, double b, double accuracy, int flag, int n) {
        double res_1 = calculateIntegralMiddle(function, a, b, flag, n);
        double res_2 = 0;
        double inaccuracy = 0;
        while (true) {
            n *= 2;
            res_2 = calculateIntegralMiddle(function, a, b, flag, n);
            inaccuracy = (res_2 - res_1)/(Math.pow(2,2) - 1);
            if (Math.abs(res_2 - res_1) <= accuracy) break;
            res_1 = res_2;
        }
        return new ResultInformation(res_2, n, inaccuracy);
    }

    private static double calculateIntegralMiddle(Function function, double a, double b, int flag, int n) {
        double result = 0;
        double h = (b - a) / n;
        for (int i = 0; i < n; i++) {
            result += function.f((a + h * i) + h / 2);
        }
        result *= h;
        return result * flag;
    }

    private static double calculateIntegralLeft(Function function, double a, double b, int flag, int n) {
        double result = 0;
        double h = (b - a) / n;

        for (int i = 0; i < n; ++i) {
            maxDerivative = Math.max(maxDerivative,Math.abs(function.derivative(a+h*i)));
            result += function.f(a + h * i);
        }
        result *= h;
        return result * flag;
    }

    private static double calculateIntegralRight(Function function, double a, double b, int flag, int n) {
        double result = 0;
        double h = (b - a) / n;
        for (int i = 1; i < n + 1; ++i) {
            maxDerivative = Math.max(maxDerivative,Math.abs(function.derivative(a+h*i)));
            result += function.f(a + h * i);
        }
        result *= h;
        return result * flag;
    }


}
