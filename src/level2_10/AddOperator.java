package level2_10;

public class AddOperator implements Operator {
    public AddOperator() {
    }

    @Override
    public double operate(int a, int b) {
        return a + b;
    }
}
