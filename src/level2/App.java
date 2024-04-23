package level2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws DivisionException, BadOperatorException {
        /* 2-2. Level 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정.
        - 연산 수행 역할은 Calculator 클래스가 담당.
        - 연산 결과는 Calculator 클래스의 연산 결과를 저장하는 필드에 저장.*/
        int num1, num2;
        char operator;
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        // Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받음.
        while (true) {
            double result = 0.0;

            do {
                System.out.print("첫 번째 양의 정수를 입력하세요: ");
                num1 = sc.nextInt();
                System.out.print("두 번째 양의 정수를 입력하세요: ");
                num2 = sc.nextInt();
            } while (num1 < 0 || num2 < 0);

            // Scanner를 사용하여 사칙연산 기호를 전달 받음. (`charAt(0)`)
            System.out.print("사칙연산 기호를 입력하세요: ");
            operator = sc.next().charAt(0);

            calc.operResult.add(calc.calculate(num1, num2, operator));
            System.out.println(calc.operResult);

        }

    }
}
