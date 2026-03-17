import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String word = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            
            // 폭발 문자열의 길이 이상이 되면 검사
            if (sb.length() >= word.length()) {
                boolean isMatch = true;
                
                for (int j = 0; j < word.length(); j++) {
                    if (sb.charAt(sb.length() - word.length() + j) != word.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }
                
                // 폭발 문자열 길이만큼 삭제
                if (isMatch) {
                    sb.delete(sb.length() - word.length(), sb.length());
                }
            }
        }
        
        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
        
        
    }
}