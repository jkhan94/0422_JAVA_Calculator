package level2_10_2.exception;

public class BadOperatorException extends Exception{
    public BadOperatorException(){
        super("연산자 기호가 잘못 입력됐습니다.");
    }
}
