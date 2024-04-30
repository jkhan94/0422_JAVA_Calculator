package level2_10_2.operator.circle;

import level2_10_2.AdapterClass;

// 원의 넓이 구하는 메소드
public class CircleAreaOperator extends AdapterClass {
    @Override
    public double calculate(int a) {
        double area = Math.PI * Math.pow(a, 2);
        return area;
    }

}
