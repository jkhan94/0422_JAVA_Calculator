package level2_10_2.operator;

import level2_10_2.AdapterClass;

public class CircleAreaOperator extends AdapterClass {
    @Override
    public double calculate(int a) {
        double area = Math.PI * Math.pow(a, 2);
        return area;
    }

}
