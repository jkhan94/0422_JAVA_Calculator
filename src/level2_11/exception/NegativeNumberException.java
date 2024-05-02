package level2_11.exception;

// 음수 입력 시 예외 처리
public class NegativeNumberException extends Exception{
    public NegativeNumberException(){
        super("음수가 입력됐습니다!");
    }
}
