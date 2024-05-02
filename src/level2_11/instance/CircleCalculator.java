package level2_11.instance;

import level2_11.AdapterClass;
import level2_11.operator.circle.CircleArcOperator;
import level2_11.operator.circle.CircleAreaOperator;
import level2_11.operator.circle.CircleSectorOperator;

import java.util.LinkedList;

public class CircleCalculator extends AdapterClass {
    // 필드
    private LinkedList<Double> operResult = new LinkedList<Double>();

    LinkedList<Double> circleResult = new LinkedList<Double>(); // 원의넓이
    LinkedList<Double> circleArc = new LinkedList<Double>(); //호의길이
    LinkedList<Double> circleSector = new LinkedList<Double>(); //부채꼴넓이

    // getter, setter
    public LinkedList<Double> getOperResult() {
        return operResult;
    }

    // 연산에 맞는 리스트로 세팅
    public void setOperResult(double result, String methodName) {
        this.operResult = setList(methodName);
        this.operResult.add(result);
    }

    // 생성자
    public CircleCalculator() {
    }

    // 연산에 따른 리스트 사용
    private LinkedList<Double> setList(String methodName) {
        switch (methodName) {
            case "circleAreaCalculation":
                operResult = circleResult;
                break;
            case "circleArcCalculation":
                operResult = circleArc;
                break;
            case "circleSectorCalculation":
                operResult = circleSector;
                break;
        }
        return operResult;
    }

    // 원의 넓이 구하기
    public double getArea(int a) {
        return new CircleAreaOperator().calculate(a);
    }

    // 원의 호 길이 구하기
    public double getArc(int radius, int angle) {
        return new CircleArcOperator().calculate(radius, angle);
    }

    //부채꼴 넓이 구하기
    public double getSectorArea(int radius, int angle) {
        return new CircleSectorOperator().calculate(radius, angle);
    }

    // 저장된 결과값 출력
    @Override
    public void inquiryResults(String methodName) {
        operResult = setList(methodName);
        System.out.println("저장된 연산 결과 출력 : " + operResult);
    }
}
