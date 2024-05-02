package level2_11.operator.arithmetic;

import level2_11.AdapterClass;

// 사칙연산 - 뺄셈
public class SubtractOperator extends AdapterClass {
    public SubtractOperator() {
    }

    @Override
    public double calculate(int a, int b) {
        return a - b;
    }

}
