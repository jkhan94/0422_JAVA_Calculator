package level2_8;

import java.util.LinkedList;

public class CircleCalculator extends Calculator {
    // 필드
    private LinkedList<Double> operResult = new LinkedList<Double>();

    public LinkedList<Double> getOperResult() {
        return operResult;
    }
    public void setOperResult(LinkedList<Double> operResult) {
        this.operResult = operResult;
    }

    public CircleCalculator() {
    }

    public CircleCalculator(LinkedList<Double> operResult) {
        this.operResult = operResult;
    }

    @Override
    public double calculate(int radius) {
        double area = Math.PI * Math.pow(radius, 2);
        return area;
    }

    @Override
    public void inquiryResults() {
        System.out.println("원의 넓이 출력 : " + operResult);
    }
}
