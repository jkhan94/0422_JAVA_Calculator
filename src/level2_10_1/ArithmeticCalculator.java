package level2_10_1;

import java.util.LinkedList;

public class ArithmeticCalculator extends AdapterClass {
    // 필드
    private LinkedList<Double> operResult = new LinkedList<Double>();

    public LinkedList<Double> getOperResult() {
        return operResult;
    }

    public void setOperResult(LinkedList<Double> operResult) {
        this.operResult = operResult;
    }

    // 생성자
    public ArithmeticCalculator() {
    }

    public ArithmeticCalculator(LinkedList<Double> operResult) {
        this.operResult = operResult;
    }

    @Override
    public double calculate(int num1, int num2, char operator) throws BadOperatorException, DivisionException {
        double result = 0.0;
        String oper = "+-*/%";

        // 스트링.indexOf():  연산기호 문자열 oper에 입력된 연산기호가 없으면 -1을 리턴
        if (oper.indexOf(operator) < 0) {
            throw new BadOperatorException();
        }

        switch (operator) {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                result = divide(num1, num2);
                break;
            case '%':
                result = mod(num1, num2);
                break;
        }
        return result;
    }

    public void removeResult() {
        operResult.remove(0);
    }

    @Override
    public void inquiryResults() {
        System.out.println("연산 결과 출력 : " + operResult);
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public double divide(int a, int b) throws DivisionException {
        if (b == 0) {
            throw new DivisionException();
        }
        return a / b;
    }

    @Override
    public double mod(int a, int b) {
        return a % b;
    }
}


