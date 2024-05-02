package level2_11.operator.arithmetic;

import level2_11.AdapterClass;

// 사칙연산 - 곱셈
public class MultiplyOperator extends AdapterClass {
    public MultiplyOperator() {
    }

    @Override
    public double calculate(int a, int b) {
        return a * b;
    }

}
