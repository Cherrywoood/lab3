package function;

import function.FirstFunction;
import function.Function;
import function.SecondFunction;
import function.ThirdFunction;

public class SelectionFunction {

    public static Function select(int num) {
        switch (num) {
            case 1:
                return new FirstFunction();
            case 2:
                return new SecondFunction();
            case 3:
                return new ThirdFunction();
            case 4:
                return new FourthFunction();
            case 5:
                return new FifthFunction();
            default:
                return null;
        }
    }
}
