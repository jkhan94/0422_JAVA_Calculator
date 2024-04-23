package level2_8;

public class BadOperatorException extends Exception{
    public BadOperatorException(){
        super("연산자 기호가 잘못 입력됐습니다.");
    }
}
