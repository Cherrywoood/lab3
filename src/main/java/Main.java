import function.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private final static double EPSILON = 0.00001;

    public static void main(String[] args) {
        MethodInformation methodInformation = Input.input();
        Function function = methodInformation.getFunction();
        double a = methodInformation.getA();
        double b = methodInformation.getB();
        int flag = methodInformation.getFlag();
        int n = methodInformation.getN();
        double accuracy = methodInformation.getAccuracy();
        if (flag == 0) {
            System.out.println("integral = " + 0);
        } else {
            if (flag == -1) {
                double t = a;
                a = b;
                b = t;
            }
            Double breakPoint = function.getBreakPoint(a, b);
            System.out.println(breakPoint);
            if (breakPoint != null) {
                if (Arrays.asList(function.getClass().getInterfaces()).contains(InfiniteGapFunction.class)) {
                    System.out.println("Интеграл расходится");
                }
                if (breakPoint == a) a += EPSILON;
                else if (breakPoint == b) b -= EPSILON;
                else {
                    ResultInformation result_middle1 = RectanglesMethod.calculateMiddle(function, a, breakPoint - EPSILON, accuracy, flag, n);
                    ResultInformation result_middle2 = RectanglesMethod.calculateMiddle(function, breakPoint + EPSILON, b, accuracy, flag, n);
                    ResultInformation result_left1 = RectanglesMethod.calculateLeft(function, a, breakPoint - EPSILON, accuracy, flag, n);
                    ResultInformation result_left2 = RectanglesMethod.calculateLeft(function, breakPoint + EPSILON, b, accuracy, flag, n);
                    ResultInformation result_right1 = RectanglesMethod.calculateRight(function, a, breakPoint - EPSILON, accuracy, flag, n);
                    ResultInformation result_right2 = RectanglesMethod.calculateRight(function, breakPoint + EPSILON, b, accuracy, flag, n);
                    System.out.printf("Метод Средних: n = %d, интеграл = %.5f, погрешность = %.5f\n", result_middle1.getN() + result_middle2.getN(),
                            result_middle2.getIntegral() + result_middle2.getN(), result_middle1.getInaccuracy() + result_middle2.getInaccuracy());
                    System.out.printf("Метод левых: n = %d, интеграл = %.5f, погрешность = %.5f\n", result_left1.getN() + result_left2.getN(),
                            result_left1.getIntegral() + result_left2.getIntegral(), result_left1.getInaccuracy() + result_left2.getInaccuracy());
                    System.out.printf("Метод правых: n = %d, интеграл = %.5f, погрешность = %.5f\n", result_right1.getN() + result_right2.getN(),
                            result_right1.getIntegral() + result_right2.getIntegral(), result_right1.getInaccuracy() + result_right2.getInaccuracy());
                    System.exit(0);
                }

            }
            ResultInformation result_middle = RectanglesMethod.calculateMiddle(function, a, b, accuracy, flag, n);
            ResultInformation result_left = RectanglesMethod.calculateLeft(function, a, b, accuracy, flag, n);
            ResultInformation result_right = RectanglesMethod.calculateRight(function, a, b, accuracy, flag, n);
            System.out.printf("Метод Средних: n = %d, интеграл = %.5f, погрешность = %.5f\n", result_middle.getN(),
                    result_middle.getIntegral(), result_middle.getInaccuracy());
            System.out.printf("Метод левых: n = %d, интеграл = %.5f, погрешность = %.5f\n", result_left.getN(),
                    result_left.getIntegral(), result_left.getInaccuracy());
            System.out.printf("Метод правых: n = %d, интеграл = %.5f, погрешность = %.5f\n", result_right.getN(),
                    result_right.getIntegral(), result_right.getInaccuracy());

        }


    }
}


