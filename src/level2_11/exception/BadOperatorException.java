package level2_11.exception;

// 사칙연산에서 연산자 기호가 +-*/% 가 아닌 경우 발생하는 예외
public class BadOperatorException extends Exception{
    public BadOperatorException(){
        super("연산자 기호가 잘못 입력됐습니다.");
    }
}
