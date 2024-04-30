package level2_10_2.operator.arithmetic;

import level2_10_2.AdapterClass;

// 사칙연산 - 나눗셈
public class DivideOperator extends AdapterClass {

    public DivideOperator() {
    }

    @Override
    public double calculate(int a, int b) {
        return a / b;
    }

}
