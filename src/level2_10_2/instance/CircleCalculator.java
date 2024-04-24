package level2_10_2.instance;

import level2_10_2.AdapterClass;
import level2_10_2.operator.CircleAreaOperator;

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

    @Override
    public double calculate(int a) {
        double area = new CircleAreaOperator().calculate(a);
        return area;
    }

    @Override
    public void inquiryResults() {
        System.out.println("저장된 연산 결과 출력 : " + operResult);
    }
}
