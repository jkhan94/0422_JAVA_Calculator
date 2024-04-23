package level2_8;

import java.util.LinkedList;


public class Calculator {
    // 생성자
    public Calculator() {
    }

    // 매개변수가 달라서 함수 오버로딩(함수명 동일, 매개변수 다름, 리턴타입 상관 없음)
    // 각 자식 메서드에서 오버라이딩할 예정.
    // 사칙연산 메서드
    public double calculate(int num1, int num2, char operator) throws DivisionException, BadOperatorException {
        return 0.0;
    }

    // 원의 넓이 메서드
    public double calculate(int radius) {
        return 0.0;
    }

    // 저장된 값 조회
    public void inquiryResults() {
        System.out.println("결과 출력 ");
    }
}




