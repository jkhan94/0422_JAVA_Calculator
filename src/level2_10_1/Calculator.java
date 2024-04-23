package level2_10_1;

public interface Calculator {
    // 매개변수가 달라서 함수 오버로딩(함수명 동일, 매개변수 다름, 리턴타입 상관 없음)
    // 각 자식 메서드에서 오버라이딩할 예정.
    // 사칙연산 메서드
    public double calculate(int num1, int num2, char operator) throws DivisionException, BadOperatorException;
    public int add(int a, int b);
    public int subtract(int a, int b);
    public int multiply(int a, int b);
    public double divide(int a, int b) throws DivisionException;
    public double mod(int a, int b);


    // 원의 넓이 메서드
    public double calculate(int radius);

    // 저장된 값 조회
    public void inquiryResults();
}
