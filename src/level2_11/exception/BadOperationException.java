package level2_11.exception;

// 가능하지 않은 연산 종류를 입력했을 때
// 연산 종류: 사칙연산, 원의 넓이
public class BadOperationException extends Exception{
    public BadOperationException(){
        super("가능한 연산 종류를 입력하세요.");
    }
}
