import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            int num = Integer.parseInt(br.readLine());
            // 입력값이 0이면 while문 탈출
            if(num == 0) {
                break;
            }

            // 팰린드롬 인지 아닌지 확인하는 boolean
            boolean flag = true;
            // 입력받은 숫자를 문자열로 변환
            String str = String.valueOf(num);

            //반복문을 통해 앞자리와 그와 대치하는 뒷자리 일치여부 확인
            for (int i = 0; i < str.length()/2; i++){
                // (str.length()/2) -> 문자열길이의 절반만큼만 반복해 앞뒷자리 확인 => 홀수이면 가운데 확인 필요 X
                if(str.charAt(i) != str.charAt(str.length()-1-i)){ //일치하지 않으면  no 출력 및 flag FALSE
                    System.out.println("no");
                    flag = false;
                    break; //더이상 반복문을 돌릴 이유 x / 계속 돌리면 출력 반복
                }
            }

            // 반복문 종료 후 flag의 값에 따라서 yes출력
            if(flag){
                System.out.println("yes");
            }
        }

    }
}