package level2_10_2;

public interface Operation {
    // 매개변수가 2개인 계산
    public double calculate(int a, int b);

    // 매개변수가 1개인 계산
    public double calculate(int a);

    // 저장된 결과값 출력
    public void inquiryResults();

    // 저장된 결과값 중 가장 오래된 값 제거
    public void removeResult();
}
