package level2_9;

import java.util.LinkedList;

/*2-9. 사칙연산 각각의 기능을 담당하는 AddOperator, SubtractOperator, MultiplyOperator, DivideOperator 클래스를 만들어
       연산 메서드의 책임을 분리 (SRP 단일 책임 원칙)
- 생성자로 사칙연산 클래스들을 초기화.
- 참고1: https://inpa.tistory.com/entry/OOP-%F0%9F%92%A0-%EC%95%84%EC%A3%BC-%EC%89%BD%EA%B2%8C-%EC%9D%B4%ED%95%B4%ED%95%98%EB%8A%94-SRP-%EB%8B%A8%EC%9D%BC-%EC%B1%85%EC%9E%84-%EC%9B%90%EC%B9%99
-참고2: https://yoongrammer.tistory.com/96
*/
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
    public double calculate(int num1, int num2, char operator) throws BadOperatorException, DivisionException {
        double result = 0.0;
        String oper = "+-*/";

        // 스트링.indexOf():  연산기호 문자열 oper에 입력된 연산기호가 없으면 0을 리턴
        if (oper.indexOf(operator) < 0) {
            throw new BadOperatorException();
        }

        switch (operator) {
            case '+':
                result = new AddOperator().add(num1, num2);
                break;
            case '-':
                result = new SubtractOperator().subtract(num1, num2);
                break;
            case '*':
                result = new MultiplyOperator().multiply(num1, num2);
                break;
            case '/':
                result = new DivideOperator().divide(num1, num2);
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


