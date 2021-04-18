import function.*;

import java.util.Scanner;

public class Input {

    public static MethodInformation input() {
        System.out.println("1. x^2\n" +
                "2. -x^3-x^2-2x+1\n" +
                "3. 4*x^3 - 5x^2 + 6x - 7\n" +
                "4. sin(x)/x\n" +
                "5. 1/x");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Выбирите подинтегральную функцию: ");
        int numberFunction = Validator.validateNumberFunction(scanner);
        Function function = SelectionFunction.select(numberFunction);
        System.out.println("Введите промежутки интегрирования [a,b]");
        System.out.print("a: ");
        double a = Validator.validateDouble(scanner);
        System.out.print("b: ");
        double b = Validator.validateDouble(scanner);
        int flag = Validator.validateBorder(a,b);
        System.out.print("Введите точность: ");
        double accuracy =  Validator.validateDouble(scanner);

        return new MethodInformation(function,a,b,accuracy,flag,5);
    }
}
