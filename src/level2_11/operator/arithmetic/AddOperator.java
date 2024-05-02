package level2_11.operator.arithmetic;

import level2_11.AdapterClass;

// 사칙연산 - 덧셈
public class AddOperator extends AdapterClass {
    public AddOperator() {
    }

    @Override
    public double calculate(int a, int b) {
        return a + b;
    }

}
