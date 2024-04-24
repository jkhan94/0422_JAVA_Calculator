package level2_10_2.operator;

import level2_10_2.AdapterClass;

public class MultiplyOperator extends AdapterClass {
    public MultiplyOperator() {
    }

    @Override
    public double calculate(int a, int b) {
        return a * b;
    }

}
