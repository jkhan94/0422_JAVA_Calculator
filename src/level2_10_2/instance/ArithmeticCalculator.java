package level2_10_2.instance;

import level2_10_2.AdapterClass;
import level2_10_2.exception.BadOperatorException;
import level2_10_2.exception.DivisionException;
import level2_10_2.operator.*;

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

    // 입력된 연산기호를 바탕으로 연산 수행
    public double calculate(int num1, int num2, char operator) throws BadOperatorException, DivisionException {
        double result = 0.0;
        String oper = "+-*/%";

        // 스트링.indexOf():  연산기호 문자열 oper에 입력된 연산기호가 없으면 -1을 리턴
        if (oper.indexOf(operator) < 0) {
            throw new BadOperatorException();
        }

        switch (operator) {
            case '+':
                result = new AddOperator().calculate(num1, num2);
                break;
            case '-':
                result = new SubtractOperator().calculate(num1, num2);
                break;
            case '*':
                result = new MultiplyOperator().calculate(num1, num2);
                break;
            case '/':
                result = new DivideOperator().calculate(num1, num2);
                break;
            case '%':
                result = new ModOperator().calculate(num1, num2);
                break;
        }
        return result;
    }

    @Override
    public void removeResult() {
        operResult.remove(0);
    }

    @Override
    public void inquiryResults() {
        System.out.println("저장된 연산 결과 출력 : " + operResult);
    }
}
