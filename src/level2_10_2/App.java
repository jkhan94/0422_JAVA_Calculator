package level2_10_2;

import level2_10_1.BadOperatorException;
import level2_10_2.exception.DivisionException;
import level2_10_2.instance.ArithmeticCalculator;
import level2_10_2.instance.CircleCalculator;

import java.util.LinkedList;
import java.util.Scanner;

/*2-10. ArithmeticCalculator 클래스에 추가로 나머지 연산(%) 기능을 추가하기 위해 ModOperator 클래스를 만들어 추가.
- 추가하려고 하니 앞으로 계속 기능이 추가되면 여러 부분의 소스코드를 수정해야 한다는 생각이 들었고 “현재 비효율적인 구조가 아닌가?” 라는 의구심이 들었습니다.
- 따라서 소스 코드의 변경은 최소화하면서 기능을 쉽게 추가(확장)할 수 있는 방법을 고민 해봅니다. (OCP)
Interface & (다형성의 원리) 등을 활용*/

public class App {
    public static void main(String[] args) {
        int num1, num2;
        char operator;
        String repeat, removeVal, printResult, operType;
        String oper = "+-*/%";
        Scanner sc = new Scanner(System.in);

        ArithmeticCalculator ariCalc = new ArithmeticCalculator();
        LinkedList<Double> arithResult = new LinkedList<Double>();

        CircleCalculator cirCalc = new CircleCalculator();
        LinkedList<Double> circleResult = new LinkedList<Double>();

        // Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받음.
        while (true) {
            double result = 0.0;

            // 가능한 연산 종류가 입력될 때까지 반복
            System.out.println("수행할 연산의 종류를 입력하세요 (1.사칙연산 2.원의넓이) ");
            operType = sc.next();

// 사칙연산
            if (operType.equals("사칙연산")) {
                // 양의 정수를 입력받을 때까지 반복
                do {
                    System.out.print("첫 번째 양의 정수를 입력하세요: ");
                    num1 = sc.nextInt();
                    System.out.print("두 번째 양의 정수를 입력하세요: ");
                    num2 = sc.nextInt();
                } while (num1 < 0 || num2 < 0);

                // Scanner를 사용하여 사칙연산 기호를 전달 받음. (`charAt(0)`)
                System.out.print("사칙연산 기호를 입력하세요 (+ - * / %) : ");
                operator = sc.next().charAt(0);

                // 스트링.indexOf():  연산기호 문자열 oper에 입력된 연산기호가 없으면 -1을 리턴
                try {
                    if (oper.indexOf(operator) < 0) {
                        throw new BadOperatorException();
                    }
                } catch (BadOperatorException e) {
                    System.out.println(e.getMessage());
                }

                // 입력된 연산기호를 바탕으로 연산 수행
                switch (operator) {
                    case '+':
                        arithResult.add(ariCalc.add(num1, num2));
                        break;
                    case '-':
                        arithResult.add(ariCalc.sub(num1, num2));
                        break;
                    case '*':
                        arithResult.add(ariCalc.mul(num1, num2));
                        break;
                    case '/':
                        try {
                            if (num2 == 0) {
                                throw new DivisionException();
                            }
                            arithResult.add(ariCalc.div(num1, num2));
                        } catch (DivisionException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case '%':
                        arithResult.add(ariCalc.mod(num1, num2));
                        break;
                }
                ariCalc.setOperResult(arithResult);
//                System.out.println(ariCalc.getOperResult());

                // 가장 오래된 연산 결과 삭제
                System.out.println("가장 먼저 저장된 연산 결과를 삭제하려면 remove를 입력하세요. (삭제하지 않으려면 아무 키나 누르세요)");
                removeVal = sc.next();
                if (removeVal.equals("remove")) {
                    ariCalc.removeResult();
                }

                // 저장된 연산 결과 출력
                System.out.println("저장된 연산결과를 조회하시려면 inquiry를 입력하세요. (조회하지 않으려면 아무 키나 누르세요)");
                printResult = sc.next();
                if (printResult.equals("inquiry")) {
                    ariCalc.inquiryResults();
                }
            } else if (operType.equals("원의넓이")) {
                // 양의 정수 입력될 때까지 반복 (0 포함)
                do {
                    System.out.print("원의 반지름을 입력하세요: ");
                    num1 = sc.nextInt();
                } while (num1 < 0);
                // 원의 넓이 계산
                circleResult.add(cirCalc.getArea(num1));
                // 원의 넓이 저장
                cirCalc.setOperResult(circleResult);
//              System.out.println(cirCalc.getOperResult());
                // 저장된 연산 결과 출력
                cirCalc.inquiryResults();
            }

            // 가능한 연산 종류가 입력됐을 경우 계속 계산할 건지 결정.
            if (operType.equals("사칙연산") || operType.equals("원의넓이")) {
                System.out.println("더 계산하시려면 아무 키나 누르세요. (exit 입력 시 종료)");
                repeat = sc.next();
                if (repeat.equals("exit")) {
                    sc.close();
                    break;
                }
            }

        } // while 루프

    }
}
