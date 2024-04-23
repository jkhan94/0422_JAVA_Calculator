package level2_10_1;

public class AdapterClass implements Calculator {
    @Override
    public double calculate(int num1, int num2, char operator) throws DivisionException, BadOperatorException {
        return 0;
    }

    @Override
    public int add(int a, int b) {
        return 0;
    }

    @Override
    public int subtract(int a, int b) {
        return 0;
    }

    @Override
    public int multiply(int a, int b) {
        return 0;
    }

    @Override
    public double divide(int a, int b) throws DivisionException {
        return 0.0;
    }

    @Override
    public double mod(int a, int b) {
        return 0;
    }

    @Override
    public double calculate(int radius) {
        return 0.0;
    }

    @Override
    public void inquiryResults() {
    }
}
