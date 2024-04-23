package level2_9;

public class DivideOperator {

    public double divide(int a, int b) throws DivisionException {
        if (b == 0) {
            throw new DivisionException();
        }
        return a / b;
    }
}
