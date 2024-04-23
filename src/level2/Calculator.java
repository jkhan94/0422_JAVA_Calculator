package level2;

import java.util.LinkedList;

/*
* 2-1. Calculator 클래스를 생성
- 연산 결과를 저장하는 컬렉션 타입 필드.
- 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(+,-,*,/) 기능을 수행한 후 결과 값을 반환하는 메서드
- 나눗셈에서 분모에 0이 들어오거나 연산자 기호가 잘못 들어온 경우 적합한 Exception 클래스를 생성하여 throw 합니다. (매개변수로 해당 오류 내용을 전달.)
* */
public class Calculator {
    LinkedList<Double> operResult = new LinkedList<Double>();

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

}
