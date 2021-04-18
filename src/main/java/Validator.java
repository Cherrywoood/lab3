import java.util.Scanner;

public class Validator {
    private static final int COUNT_FUNCTION = 5;
    public static double validateDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Не является числом!");
            }
        }
    }
    public static int validateBorder(double a, double b) {
        return Double.compare(b, a);
    }

    public static int validateNumberFunction(Scanner scanner){
       while (true) {
           try {
               int n = Integer.parseInt(scanner.nextLine());
               if (n < 1 || n > COUNT_FUNCTION) {
                   System.err.println("Нет функции с таким номером!");
               } else  return n;
           } catch (NumberFormatException e) {
               System.err.println("Не является целым числом!");
           }
       }
    }
}
