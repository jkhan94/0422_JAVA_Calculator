package level2_11.instance;

import level2_11.AdapterClass;
import level2_11.operator.circle.CircleArcOperator;
import level2_11.operator.circle.CircleAreaOperator;
import level2_11.operator.circle.CircleSectorOperator;

import java.util.LinkedList;

public class CircleCalculator extends AdapterClass {
    // 필드
    private LinkedList<Double> operResult = new LinkedList<Double>();

    // getter, setter
    public LinkedList<Double> getOperResult() {
        return operResult;
    }
    public void setOperResult(LinkedList<Double> operResult) {
        this.operResult = operResult;
    }

    // 생성자
    public CircleCalculator() {
    }

    // 원의 넓이 구하기
    public double getArea(int a) {
        return new CircleAreaOperator().calculate(a);
    }

    // 원의 호 길이 구하기
    public double getArc(int radius, int angle) { return new CircleArcOperator().calculate(radius, angle); }

    //부채꼴 넓이 구하기
    public double getSectorArea(int radius, int angle) { return new CircleSectorOperator().calculate(radius, angle); }

    // 저장된 결과값 출력
    @Override
    public void inquiryResults() {
        System.out.println("저장된 연산 결과 출력 : " + operResult);
    }
}
