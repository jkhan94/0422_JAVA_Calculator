package level2_8;

import java.util.LinkedList;

public class ArithmeticCalculator extends Calculator {
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
    public double calculate(int num1, int num2, char operator) throws DivisionException, BadOperatorException {
        double result = 0.0;
        String oper = "+-*/";

        // 스트링.indexOf():  연산기호 문자열 oper에 입력된 연산기호가 없으면 0을 리턴
        if (oper.indexOf(operator) < 0) {
            throw new BadOperatorException();
        }

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new DivisionException();
                }

                result = num1 / num2;
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
}


/*    *//* 2-4. Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 메서드 구현
App 클래스의 main 메서드에 삭제 메서드가 활용될 수 있도록 수정. *//*
    public void removeResult() {
        operResult.remove(0);
    }*/


