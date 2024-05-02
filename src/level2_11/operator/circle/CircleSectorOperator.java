package level2_11.operator.circle;

import level2_11.AdapterClass;

// 부채꼴 넓이 구하는 메소드
public class CircleSectorOperator extends AdapterClass {
    @Override
    public double calculate(int a, int b) {
        // @param a는 반지름, b는 각도
        // @return 부채꼴 넓이
        double sectorArea = Math.PI*Math.pow(a, 2)*(b*1.0/360);
        return sectorArea;
    }
}
