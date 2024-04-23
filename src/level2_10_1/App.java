package level2_10_1;

import java.util.LinkedList;
import java.util.Scanner;
/*2-10_1. ArithmeticCalculator 클래스에 추가로 나머지 연산(%) 기능을 추가하기 위해 ModOperator 클래스를 만들어 추가.
- 추가하려고 하니 앞으로 계속 기능이 추가되면 여러 부분의 소스코드를 수정해야 한다는 생각이 들었고 “현재 비효율적인 구조가 아닌가?” 라는 의구심이 들었습니다.
- 따라서 소스 코드의 변경은 최소화하면서 기능을 쉽게 추가(확장)할 수 있는 방법을 고민 해봅니다. (OCP)
Interface & (다형성의 원리) 등을 활용*/

public class App {
    public static void main(String[] args) throws DivisionException, BadOperatorException {
        int num1, num2;
        char operator;
        LinkedList<Double> areaResult = new LinkedList<Double>();
        LinkedList<Double> arithResult = new LinkedList<Double>();
        String repeat, removeVal, printResult, operType;
        Scanner sc = new Scanner(System.in);

        ArithmeticCalculator ariCalc = new ArithmeticCalculator();
        CircleCalculator cirCalc = new CircleCalculator();

        // Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받음.
        while (true) {
            double result = 0.0;

            System.out.println("수행할 연산의 종류를 입력하세요 (1.사칙연산 2.원의넓이) ");
            operType = sc.next();

            if (operType.equals("사칙연산")) {
                do {
                    System.out.print("첫 번째 양의 정수를 입력하세요: ");
                    num1 = sc.nextInt();
                    System.out.print("두 번째 양의 정수를 입력하세요: ");
                    num2 = sc.nextInt();
                } while (num1 < 0 || num2 < 0);

                // Scanner를 사용하여 사칙연산 기호를 전달 받음. (`charAt(0)`)
                System.out.print("사칙연산 기호를 입력하세요: ");
                operator = sc.next().charAt(0);

                arithResult.add(ariCalc.calculate(num1, num2, operator));
                ariCalc.setOperResult(arithResult);
//                System.out.println(ariCalc.getOperResult());

                System.out.println("가장 먼저 저장된 연산 결과를 삭제하려면 remove를 입력하세요. (삭제하지 않으려면 아무 키나 누르세요)");
                removeVal = sc.next();
                if (removeVal.equals("remove")) {
                    ariCalc.removeResult();
                }

                // 1-8. foreach(향상된 for문)을 활용하여 inquiry라는 문자열이 입력되면 저장된 연산 결과 전부를 출력.
                System.out.println("저장된 연산결과를 조회하시려면 inquiry를 입력하세요. (조회하지 않으려면 아무 키나 누르세요)");
                printResult = sc.next();
                if (printResult.equals("inquiry")) {
                    ariCalc.inquiryResults();
                }

                System.out.println("더 계산하시려면 아무 키나 누르세요. (exit 입력 시 종료)");
                repeat = sc.next();
                if (repeat.equals("exit")) {
                    sc.close();
                    break;
                }

            } else if (operType.equals("원의넓이")) {
                do {
                    System.out.print("원의 반지름을 입력하세요: ");
                    num1 = sc.nextInt();
                } while (num1 < 0);
                areaResult.add(cirCalc.calculate(num1));
                // 원의 넓이 저장
                cirCalc.setOperResult(areaResult);
//                System.out.println(cirCalc.getOperResult());
                cirCalc.inquiryResults();
            }

        } // while 루프

    }
}
