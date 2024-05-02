package level2_11.operator.circle;

import level2_11.AdapterClass;

// 호의 길이 구하는 메소드
public class CircleArcOperator extends AdapterClass {
    @Override
    public double calculate(int a, int b) {
        // @param a는 반지름, b는 각도
        // @return 호 길이
        double arc = 2*Math.PI*a*(b*1.0/360);
        return arc;
    }
}
