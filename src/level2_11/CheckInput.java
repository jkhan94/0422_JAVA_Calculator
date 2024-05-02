package level2_11;

// 제시된 것과 다른 형태가 입력됐을 경우 예외 처리하는 클래스
public class CheckInput {

    // 연산자 기호가 잘 입력됐으면 true, 잘못 입력됐으면 false
    public boolean checkOperator(char operator){
        // 사칙연산에서 입력될 수 있는 연산자 종류
        String oper = "+-*/%";
        // 스트링.indexOf():  연산기호 문자열 oper에 입력된 연산기호가 없으면 -1을 리턴
        return oper.indexOf(operator) != -1;
    }
}
