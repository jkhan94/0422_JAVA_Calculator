package level2_11.instance;

import level2_11.AdapterClass;
import level2_11.operator.arithmetic.*;

import java.util.LinkedList;

public class ArithmeticCalculator extends AdapterClass {
    // 필드
    private LinkedList<Double> operResult = new LinkedList<Double>();

    //getter, setter
    public LinkedList<Double> getOperResult() {
        return operResult;
    }
    public void setOperResult(LinkedList<Double> operResult) {
        this.operResult = operResult;
    }

    // 생성자
    public ArithmeticCalculator() {
    }

    // 사칙연산 메소드
    public double add(int num1, int num2) {
        return new AddOperator().calculate(num1, num2);
    }
    public double sub(int num1, int num2) {
        return new SubtractOperator().calculate(num1, num2);
    }
    public double mul(int num1, int num2) {
        return new MultiplyOperator().calculate(num1, num2);
    }
    public double div(int num1, int num2) {
        return new DivideOperator().calculate(num1, num2);
    }
    public double mod(int num1, int num2) {
        return new ModOperator().calculate(num1, num2);
    }


    // 저장된지 가장 오래된 값 제거
    // 빈 리스트에서 삭제 시도 시 예외 처리
    @Override
    public void removeResult() {
        try {
            operResult.remove(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getClass().getName() + "예외 발생: 리스트가 비어 있습니다!");
        }
    }

    // 리스트에 저장된 값들 출력
    @Override
    public void inquiryResults() {
        System.out.println("저장된 연산 결과 출력 : " + operResult);
    }
}
