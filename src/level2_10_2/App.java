package level2_10_2;

import level2_10_2.exception.BadOperationException;
import level2_10_2.exception.BadOperatorException;
import level2_10_2.exception.DivisionException;
import level2_10_2.exception.ModuloException;
import level2_10_2.instance.ArithmeticCalculator;
import level2_10_2.instance.CircleCalculator;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

/*2-10. ArithmeticCalculator 클래스에 추가로 나머지 연산(%) 기능을 추가하기 위해 ModOperator 클래스를 만들어 추가.
- 추가하려고 하니 앞으로 계속 기능이 추가되면 여러 부분의 소스코드를 수정해야 한다는 생각이 들었고 “현재 비효율적인 구조가 아닌가?” 라는 의구심이 들었습니다.
- 따라서 소스 코드의 변경은 최소화하면서 기능을 쉽게 추가(확장)할 수 있는 방법을 고민 해봅니다. (OCP)
Interface & (다형성의 원리) 등을 활용*/

/*
연산 종류 추가 시 
1. 파일 사용: resource 폴더의 opertypes.txt에 추가. 엔터로 구분.
2. 배열 사용: OperationTypes클래스의 opertypes에 저장.

AdapterClass 상속받는 클래스 생성해서 연산 기능 구현.
operator 패키지 내 클래스들이 연산 담당.
*매개변수가 3개 필요한 연산은 인터페이스 Operation에 선언, AdapterClass에서 오버라이딩 한 후 별도의 클래스를 생성해서 구현.

새로운 형태의 객체가 필요할 경우 instance 패키지에 생성.
instance 패키지 내 클래스에서 메소드를 통해 기능을 구현한 클래스를 불러와서 사용.
기능은 각 operator 클래스에서 정의되지만 instance 클래스는 이를 호출만 함.
따라서 기능 변경이 필요할 경우 operator 클래스만 수정하면 됨.
만약 덧셈 연산을 두 가지로 구현하고 싶을 경우 이름만 다른 클래스를 생성해서 구현하면 됨.
*/

public class App {
    public static void main(String[] args) {
        int num1 = 0;
        String repeat = " "; // 연산 반복 여부
        String operType = " "; // 연산 종류 저장

        Scanner sc = new Scanner(System.in);

        OperationTypes operationTypes = new OperationTypes();

        ArithmeticCalculator ariCalc = new ArithmeticCalculator();
        LinkedList<Double> arithResult = new LinkedList<Double>();

        CircleCalculator cirCalc = new CircleCalculator();
        LinkedList<Double> circleResult = new LinkedList<Double>();

        while (true) {
            // 가능한 연산 종류가 입력될 때까지 반복
            while (true) {
                try {
                    System.out.print("수행할 연산의 종류를 입력하세요: ");
                    operationTypes.printOperTypes(); // 가능한 연산 종류 출력
                    operType = sc.next(); // 연산 종류 입력 받음
                    // 가능한 연산 종류가 입력되지 않았을 경우 예외처리
                    if (!operationTypes.operations.contains(operType)) {
                        throw new BadOperationException();
                    }
                    break;
                } catch (BadOperationException e) {
                    // 입력이 잘못 됐을 경우 스캐너 초기화
                    sc = new Scanner(System.in);
//                        e.printStackTrace(); // 예외에 대한 상세 내용 출력
                    System.out.println(e.getClass().getName() + "예외 발생: " + e.getMessage());
                }
            }

            // switch~case 안에 코드를 작성하니 가독성이 떨어져서 메소드로 분리
            switch (operType) {
                case "사칙연산":
                    arithCalculation(ariCalc, arithResult);
                    break;
                case "원의넓이":
                    circleAreaCalculation(cirCalc, circleResult);
                    break;
            }

            // 가능한 연산 종류가 입력됐을 때 계속 계산할 건지 결정.
            if (operationTypes.operations.contains(operType)) {
                System.out.println("더 계산하시려면 아무 키나 누르세요. (exit 입력 시 종료)");
                repeat = sc.next();
                if (repeat.equals("exit")) {
                    sc.close();
                    break;
                }
            }

        } // while 루프

        sc.close();
    }


// 사칙연산 수행 함수
// static: 프로그램 실행 시 메모리에 먼저 올리는 함수
// main보다 먼저 실행되어야 하므로 static으로 생성.
    public static void arithCalculation(ArithmeticCalculator ariCalc, LinkedList<Double> arithResult) {
        int num1 = -1, num2 = -1;
        char operator = ' ';
        String removeVal, printResult;

        Scanner sc = new Scanner(System.in);
        CheckInput checkInput = new CheckInput();

        // 양의 정수를 입력받을 때까지 반복
        while (num1 < 0 || num2 < 0) {
            try {
                System.out.print("첫 번째 양의 정수를 입력하세요: ");
                num1 = sc.nextInt();
                System.out.print("두 번째 양의 정수를 입력하세요: ");
                num2 = sc.nextInt();
                break;
            }
            // 숫자가 아닌 다른 게 입력됐을 경우 예외처리
            catch (InputMismatchException e) {
                // 입력이 잘못 됐을 경우 스캐너 초기화
                sc = new Scanner(System.in);
//              e.printStackTrace(); // 예외에 대한 상세 내용 출력
                System.out.println(e.getClass().getName() + "예외 발생: 양의 정수를 입력하세요.");
            }
        }

        // Scanner를 사용하여 사칙연산 기호를 전달 받음. (`charAt(0)`)
        while (true) {
            try {
                System.out.print("사칙연산 기호를 입력하세요: ");
                operator = sc.next().charAt(0);
                if (!checkInput.checkOperator(operator)) {
                    throw new BadOperatorException();
                }
                break;
            } catch (BadOperatorException e) {
                sc = new Scanner(System.in);
                System.out.println(e.getClass().getName() + "예외 발생: 연산자를 입력하세요.");
            }
        }

        // 입력된 두 정수와 연산자로 연산 수행
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
                    System.out.println(e.getClass().getName() + "예외 발생: " + e.getMessage());
                }
                break;
            case '%':
                try {
                    if (num2 == 0) {
                        throw new ModuloException();
                    }
                    arithResult.add(ariCalc.mod(num1, num2));
                } catch (ModuloException e) {
                    System.out.println(e.getClass().getName() + "예외 발생: " + e.getMessage());
                }
                break;
        }
        ariCalc.setOperResult(arithResult);
//                System.out.println(ariCalc.getOperResult()); // 저장됐는지 확인

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
    }


// 원의 넓이 구하는 함수
    public static void circleAreaCalculation(CircleCalculator cirCalc, LinkedList<Double> circleResult) {
        int num1 = -1;
        Scanner sc = new Scanner(System.in);

        // 양의 정수 입력될 때까지 반복 (0 포함)
        while (num1 < 0) {
            try {
                System.out.print("원의 반지름을 입력하세요: ");
                num1 = sc.nextInt();
            } catch (InputMismatchException e) {
                // 입력이 잘못 됐을 경우 스캐너 초기화
                sc = new Scanner(System.in);
//                        e.printStackTrace(); // 예외에 대한 상세 내용 출력
                System.out.println(e.getClass().getName() + "예외 발생: 양의 정수를 입력하세요.");
            }
        }

        // 원의 넓이 계산
        circleResult.add(cirCalc.getArea(num1));

        // 원의 넓이 저장
        cirCalc.setOperResult(circleResult);
//      System.out.println(cirCalc.getOperResult());

        // 저장된 연산 결과 출력
        cirCalc.inquiryResults();
    }

}