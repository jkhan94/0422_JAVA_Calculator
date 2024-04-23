package Level1;

import java.util.*;

public class App {
    public static void main(String[] args) {
        int num1, num2;
        char operator;
        String repeat, removeVal, printResult;
        LinkedList<Double> operResult = new LinkedList<Double>();

        // 1-4. 반복문(e.g. for, while)을 사용하여 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 수정
        while (true) {
            double result = 0.0;
            Scanner sc = new Scanner(System.in);

            // 1-1. Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받음.
            do {
                System.out.print("첫 번째 양의 정수를 입력하세요: ");
                num1 = sc.nextInt();
                System.out.print("두 번째 양의 정수를 입력하세요: ");
                num2 = sc.nextInt();
            } while (num1 < 0 || num2 < 0);

            // 1-2. Scanner를 사용하여 사칙연산 기호를 전달 받음. (`charAt(0)`)
            System.out.print("사칙연산 기호를 입력하세요: ");
            operator = sc.next().charAt(0);

        /* 1-3. 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값 출력
        - 입력받은 연산 기호를 구분하기 위해 제어문을 사용합니다. (e.g.if, switch)
        - 연산 오류가 발생할 경우 해당 오류에 대한 내용을 정제하여 출력. (e.g. “나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. “)*/
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        break;
                    } else {
                        result = num1 / num2;
                        break;
                    }
                case '%':
                    result = num1 % num2;
                    break;
            }
            System.out.println("결과: " + result);

            /* 1-5. 연산 결과 10개를 저장할 수 있는 배열을 선언 및 생성하고 연산의 결과를 저장.
            - 연산의 결과를 비어있는 곳에 저장하기 위해 저장할 때마다 count 합니다.*/
            /*1-6. 연산 결과가 10개 초과하면 가장 먼저 저장된 결과를 삭제하고 새로운 연산 결과가 저장될 수 있도록 소스 코드를 수정.
            - 현재 저장된 index가 마지막(9)라면 가장 먼저 저장된 결과 값이 삭제 되고 새로운 결과 값이 마지막 index에 저장될 수 있도록 구현.*/
            /*1-7. 연산 결과가 10개로 고정되지 않고 무한이 저장될 수 있도록 소스 코드를 수정
            - JCF(Java Collection Framework)를 사용합니다. (e.g. List, Set )
            - “remove”라는 문자열을 입력받으면 가장 먼저 저장된 결과가 삭제될 수 있도록 구현. */
            // 리스트에 연산 결과 저장
            operResult.add(result);

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하려면 remove를 입력하세요. (삭제하지 않으려면 아무 키나 누르세요)");
            removeVal = sc.next();
            if (removeVal.equals("remove")) {
                operResult.remove(0);
            }

            // 1-8. foreach(향상된 for문)을 활용하여 inquiry라는 문자열이 입력되면 저장된 연산 결과 전부를 출력.
            System.out.println("저장된 연산결과를 조회하시려면 inquiry를 입력하세요. (조회하지 않으려면 아무 키나 누르세요)");
            printResult = sc.next();
            if (printResult.equals("inquiry")) {
                System.out.print("연산 결과 출력 : ");
                for (double number : operResult) {
                    System.out.print(number + ", ");
                }
                System.out.println();
                // 이터레이터
                /*Iterator<Double> iter = operResult.iterator();
                while (iter.hasNext()) {
                    System.out.println(iter.next());
                }*/
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