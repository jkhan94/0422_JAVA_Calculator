package level2_10_2.operator;

import level2_10_2.AdapterClass;

public class ModOperator extends AdapterClass {
    public ModOperator() {
    }

    @Override
    public double calculate(int a, int b) {
        return a % b;
    }

}
