package level2_10_2.operator.arithmetic;

import level2_10_2.AdapterClass;

// 사칙연산 - 곱셈
public class MultiplyOperator extends AdapterClass {
    public MultiplyOperator() {
    }

    @Override
    public double calculate(int a, int b) {
        return a * b;
    }

}
