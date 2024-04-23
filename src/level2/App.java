package level2;

import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws DivisionException, BadOperatorException {
        /* 2-2. Level 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정.
        - 연산 수행 역할은 Calculator 클래스가 담당.
        - 연산 결과는 Calculator 클래스의 연산 결과를 저장하는 필드에 저장. */
        int num1, num2;
        char operator;
        LinkedList<Double> Result = new LinkedList<Double>();
        String repeat, removeVal, printResult;
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

            Result.add(calc.calculate(num1, num2, operator));
            calc.setOperResult(Result);
            System.out.println(calc.getOperResult());

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하려면 remove를 입력하세요. (삭제하지 않으려면 아무 키나 누르세요)");
            removeVal = sc.next();
            if (removeVal.equals("remove")) {
                calc.removeResult();
            }

            // 1-8. foreach(향상된 for문)을 활용하여 inquiry라는 문자열이 입력되면 저장된 연산 결과 전부를 출력.
            System.out.println("저장된 연산결과를 조회하시려면 inquiry를 입력하세요. (조회하지 않으려면 아무 키나 누르세요)");
            printResult = sc.next();
            if (printResult.equals("inquiry")) {
                System.out.print("연산 결과 출력 : ");
                System.out.println(calc.getOperResult());
            }

            System.out.println("더 계산하시려면 아무 키나 누르세요. (exit 입력 시 종료)");
            repeat = sc.next();
            if (repeat.equals("exit")) {
                sc.close();
                break;
            }

        }

    }
}
