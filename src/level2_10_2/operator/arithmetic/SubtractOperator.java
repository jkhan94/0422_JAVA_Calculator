package level2_10_2.operator.arithmetic;

import level2_10_2.AdapterClass;

public class SubtractOperator extends AdapterClass {
    public SubtractOperator() {
    }

    @Override
    public double calculate(int a, int b) {
        return a - b;
    }

}
