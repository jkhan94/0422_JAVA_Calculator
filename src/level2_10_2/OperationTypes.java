package level2_10_2;

import java.util.LinkedList;

// 실행 가능한 연산 종류 모음
// 새 연산 추가 시 opertypes에 저장
public class OperationTypes {
    // 연산 종류를 저장한 문자열 배열
    String[] opertypes = {"사칙연산", "원의넓이"};

    // 연산 종류를 저장할 필드
    LinkedList<String> operations = new LinkedList<>();

    // 생성자 호출 시 연결리스트에 연산 종류 저장
    public OperationTypes() {
        for (int i = 0; i < opertypes.length; i++) {
            operations.add(opertypes[i]);
        }
    }

    // 연산 종류 출력
    public void printOperTypes() {
        for (int i = 0; i < operations.size(); i++) {
            System.out.print((i+1) + "." + operations.get(i) + " ");
        }
        System.out.println();
    }
}
