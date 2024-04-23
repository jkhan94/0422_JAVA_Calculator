package level2_10;

public class BadOperatorException extends Exception{
    public BadOperatorException(){
        super("연산자 기호가 잘못 입력됐습니다.");
    }
}
