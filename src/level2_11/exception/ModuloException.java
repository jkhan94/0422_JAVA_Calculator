package level2_11.exception;

// Arithmetic Exception
// 나머지 연산에서 분모가 0인 경우 발생하는 예외
public class ModuloException extends Exception {
    public ModuloException() {
        super("나머지 연산에서 분모가 0일 수 없습니다!");
    }
}
