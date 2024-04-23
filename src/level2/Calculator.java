package level2;

import java.util.LinkedList;

/*
* 2-1. Calculator 클래스를 생성
- 연산 결과를 저장하는 컬렉션 타입 필드.
- 양의 정수 2개(0 포함)와 연산 기호를 매개변수로 받아 사칙연산(+,-,*,/) 기능을 수행한 후 결과 값을 반환하는 메서드
- 나눗셈에서 분모에 0이 들어오거나 연산자 기호가 잘못 들어온 경우 적합한 Exception 클래스를 생성하여 throw 합니다. (매개변수로 해당 오류 내용을 전달.)
* */
public class Calculator {
    // 필드
    /* 2-3. App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정합니다. (캡슐화)
    - 간접 접근을 통해 필드에 접근하여 가져올 수 있도록 구현합니다. (Getter 메서드)
    - 간접 접근을 통해 필드에 접근하여 수정할 수 있도록 구현합니다. (Setter 메서드) */
    private LinkedList<Double> operResult = new LinkedList<Double>();

    public LinkedList<Double> getOperResult() {
        return operResult;
    }

    public void setOperResult(LinkedList<Double> operResult) {
        this.operResult = operResult;
    }

    // 생성자
    /* 2-6. Calculator 인스턴스를 생성(new)할 때 생성자를 통해, 연산 결과를 저장하고 있는 컬렉션 필드가 초기화 되도록 수정 */
    public Calculator() {
        // 리스트는 따로 초기화할 필요가 없다.
        // 그럼에도 초기화하라는 걸 보면 저장된 값을 지우라는 것 같다.
        // clear() : 리스트에 저장된 전체 값 삭제
        operResult.clear();
        areaResult.clear();
    }

    // 메서드
    public double calculate(int num1, int num2, char operator) throws DivisionException, BadOperatorException {
        double result = 0.0;
        String oper = "+-*/";

        // 스트링.indexOf():  연산기호 문자열 oper에 입력된 연산기호가 없으면 -1을 리턴
        if (oper.indexOf(operator) < 0) {
            throw new BadOperatorException();
        }

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
                    throw new DivisionException();
                }

                result = num1 / num2;
                break;
        }
        return result;
    }

    /* 2-4. Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 메서드 구현
    App 클래스의 main 메서드에 삭제 메서드가 활용될 수 있도록 수정. */
    public void removeResult() {
        operResult.remove(0);
    }

    /* 2-5.Calculator 클래스에 저장된 연산 결과들을 조회하는 메서드 구현
    App 클래스의 main 메서드에 조회 메서드가 활용될 수 있도록 수정. */
    public void inquiryResults() {
        System.out.println("연산 결과 출력 : " + operResult);
    }


    // 원의 넓이 구하기
    /*2-7. Calculator 클래스에 반지름을 매개변수로 전달받아 원의 넓이를 계산하여 반환해주는 메서드를 구현.
    - APP 클래스의 main 메서드에 Scanner를 활용하여 사칙연산을 진행할지 원의 넓이를 구할지 명령어를 입력 받은 후,
      원의 넓이를 구하는 것을 선택했을 때 원의 반지름을 입력 받아 원의 넓이를 구한 후 출력되도록 구현.
    - 사용할 경우 static, final 키워드에 대한 설명과 활용한 이유에 대해 주석으로 작성
    - 원의 넓이 결과를 저장하는 컬렉션 타입의 필드 선언 및 생성
    - 계산된 원의 넓이를 저장합니다.
    - 생성자로 초기화됩니다.
    - 외부에서 직접 접근할 수 없습니다. : Getter, Setter 메서드를 구현합니다.
    - 원의 넓이 결과값들을 조회하는 메서드를 구현 */
    private LinkedList<Double> areaResult = new LinkedList<Double>();

    public LinkedList<Double> getAreaResult() {
        return areaResult;
    }

    public void setAreaResult(LinkedList<Double> areaResult) {
        this.areaResult = areaResult;
    }

    // 원의 넓이 계산
    public double calculateCircleArea(int radius) {
        double area = Math.PI * Math.pow(radius, 2);
        return area;
    }

    // 원의 넓이값들 조회
    public void inquiryAreas() {
        System.out.println("원의 넓이 출력 : " + areaResult);
    }
}
