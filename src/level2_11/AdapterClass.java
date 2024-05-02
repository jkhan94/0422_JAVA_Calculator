package level2_11;

// 인터페이스 Operation을 구현한 AdapterClass
// 본 클래스를 상속받은 자식 클래스에서 기능 구현
// 자식 클래스들은 operator 패키지에 있음.
public class AdapterClass implements Operation {
    @Override
    public double calculate(int a, int b) {
        return 0;
    }

    @Override
    public double calculate(int a) {
        return 0;
    }

    @Override
    public void inquiryResults() {

    }

    @Override
    public void inquiryResults(String methodName) {

    }

    @Override
    public void removeResult() {

    }
}
