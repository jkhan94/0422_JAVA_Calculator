package level2_10;

public class SubtractOperator implements Operator {
    public SubtractOperator() {
    }

    @Override
    public double operate(int a, int b) {
        return a - b;
    }

}
