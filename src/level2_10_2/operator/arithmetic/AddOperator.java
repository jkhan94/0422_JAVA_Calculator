package level2_10_2.operator.arithmetic;

import level2_10_2.AdapterClass;

public class AddOperator extends AdapterClass {
    public AddOperator() {
    }

    @Override
    public double calculate(int a, int b) {
        return a + b;
    }

}
