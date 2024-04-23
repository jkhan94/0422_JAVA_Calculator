package level2_10;

public class ModOperator implements Operator {
    public ModOperator() {
    }

    @Override
    public double operate(int a, int b) {
        return a % b;
    }

}
