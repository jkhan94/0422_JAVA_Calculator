package level2_11;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

// 실행 가능한 연산 종류 모음
// 새 연산 추가 시 opertypes에 저장
public class OperationTypes {
    // 연산 종류를 저장할 리스트
    LinkedList<String> operations = new LinkedList<>();

    // 연산 종류 출력을 위한 파일 필드
    BufferedReader br = null;
    String line = null;
    String basePath = new File("").getAbsolutePath();
    String resourcePath = "/src/resource";
    String fileName = "/opertypes2.txt";
    String filePath = " ";

    // 연산 종류가 저장된 파일 읽기
    // 연산 종류가 적으면 배열로 선언해도 되지만 연산 종류가 많이질 경우 배열이 길어짐.
    // 더불어 연산 종류가 변경될 경우 매번 코드를 수정해야 함.
    // 그러나 파일에서 불러올 경우 파일을 수정하여 연산 종류를 관리할 수 있음.
    public OperationTypes() {
        // 파일 경로 설정
        filePath = basePath + resourcePath + fileName;
        if (!Files.exists(Paths.get(filePath))) {
            filePath = basePath + "/resource" + fileName;
        }
    }

    // 연산 종류 출력
    public void printOperTypes() {
        // 파일 출력
        try {
            br = new BufferedReader(new FileReader(filePath));
            int i = 1;
            // readLine()은 값을 읽어올 때 줄바꿈 문자는 가져오지 않는다
            // 줄바꿈 문자를 만나면 읽기 중단 = line by line으로 읽음
            while ((line = br.readLine()) != null) {
                // 콘솔에 연산 종류 출력
                System.out.print(i + ". " + line + " ");
                i++;
                // 연산 종류를 리스트에 저장
                operations.add(line);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("존재하지 않는 파일입니다!");
        } catch (IOException e) {
            System.out.println("연결 오류");
        }
    }

/*  배열로 연산 종류 출력
    연산 종류가 정해져 있고 수정될 일도 없다면 아래처럼 배열을 이용하는 게 나을 수 있음.

    // 연산 종류를 저장한 문자열 배열
    String[] opertypes = {"사칙연산", "원의넓이"};

    // 생성자 호출 시 연결리스트에 연산 종류 저장
    public OperationTypes() {
        for (int i = 0; i < opertypes.length; i++) {
            operations.add(opertypes[i]);
        }
    }
    // 연산 종류 출력
    public void printOperTypes() {
        // 연산 종류를 리스트에 저장했을 때 출력
        for (int i = 0; i < operations.size(); i++) {
            System.out.print((i + 1) + "." + operations.get(i) + " ");
        }
        System.out.println();
    }*/
}
