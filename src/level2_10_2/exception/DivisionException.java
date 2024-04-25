package level2_10_2.exception;

// Arithmetic Exception과 동일
public class DivisionException extends Exception {
    public DivisionException() {
        super("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
    }
}
