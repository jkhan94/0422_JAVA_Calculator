package level2;

import java.util.LinkedList;

/*
* 2-1. Calculator 클래스를 생성
- 연산 결과를 저장하는 컬렉션 타입 필드.
- 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(+,-,*,/) 기능을 수행한 후 결과 값을 반환하는 메서드
- 나눗셈에서 분모에 0이 들어오거나 연산자 기호가 잘못 들어온 경우 적합한 Exception 클래스를 생성하여 throw 합니다. (매개변수로 해당 오류 내용을 전달.)
* */
public class Calculator {
    /* 2-3. App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정합니다. (캡슐화)
    - 간접 접근을 통해 필드에 접근하여 가져올 수 있도록 구현합니다. (Getter 메서드)
    - 간접 접근을 통해 필드에 접근하여 수정할 수 있도록 구현합니다. (Setter 메서드) */
    private LinkedList<Double> operResult = new LinkedList<Double>();

    public LinkedList<Double> getOperResult() {
        return operResult;
    }
    public void setOperResult(LinkedList<Double> operResult) {
        this.operResult = operResult;
    }

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
