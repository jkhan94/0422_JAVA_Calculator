package level2_10_2.operator;

import level2_10_2.AdapterClass;
import level2_10_2.exception.DivisionException;

public class DivideOperator extends AdapterClass {

    public DivideOperator() {
    }

    @Override
    public double calculate(int a, int b) {
        try {
            if (b == 0) {
                throw new DivisionException();
            }
        } catch (DivisionException e) {
            System.out.println(e.getMessage());
        }
        return a / b;
    }

}
