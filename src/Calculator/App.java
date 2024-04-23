package Calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int num1, num2;
        char operator;
        String repeat;
        int index = 0;
        double[] operResult = new double[10];

        // 1-4. 반복문(e.g. for, while)을 사용하여 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 수정
        while (true) {
            int result = 0;

            // 1-1. Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받음.
            Scanner sc = new Scanner(System.in);
            System.out.print("첫 번째 숫자를 입력하세요: ");
            num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            num2 = sc.nextInt();

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
            if (index != 9) {
                // 배열이 비어 있으면 결과 저장.
                operResult[index] = result;
                index++;
            } else if (index == 9) {
                // 배열이 꽉 찼으면 앞으로 당김.
                for (int i = 0; i < 9; i++) {
                    operResult[i] = operResult[i + 1];
                }
                operResult[9] = result;
            }

            System.out.println("더 계산하시려면 아무 키나 누르세요. (exit 입력 시 종료)");
            repeat = sc.next();
            if (repeat.equals("exit")) {
                break;
            }
        }
    }
}