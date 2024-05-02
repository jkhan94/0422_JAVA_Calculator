package level2_11.operator.arithmetic;

import level2_11.AdapterClass;

// 사칙연산 - 나눗셈
public class DivideOperator extends AdapterClass {

    public DivideOperator() {
    }

    @Override
    public double calculate(int a, int b) {
        return a / b;
    }

}
