package level2_10;

public class DivideOperator implements Operator {

    public DivideOperator() {
    }

    @Override
    public double operate(int a, int b) {
        try {
            if (b == 0) {
                throw new DivisionException();
            }
        } catch (DivisionException e) {
            System.out.println(e.getMessage());
        }
        return a / b;
    }
}
