package level2_10_2.operator.arithmetic;

import level2_10_2.AdapterClass;

// 사칙연산 - 나머지 연산
public class ModOperator extends AdapterClass {
    public ModOperator() {
    }

    @Override
    public double calculate(int a, int b) {
        return a % b;
    }

}
