package level2_10_2.exception;

public class BadOperationException extends Exception{
    public BadOperationException(){
        super("가능한 연산 종류를 입력하세요.");
    }
}
