package level2_10;

public class MultiplyOperator implements Operator {
    public MultiplyOperator() {
    }

    @Override
    public double operate(int a, int b) {
        return a * b;
    }

}
