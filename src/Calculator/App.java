package Calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 1-1. Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받음.
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        System.out.print("첫 번째 숫자를 입력하세요: ");
        num1 = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요: ");
        num2 = sc.nextInt();

        // 1-2. Scanner를 사용하여 사칙연산 기호를 전달 받음. (`charAt(0)`)
        char operator = sc.next().charAt(0);
    }
}