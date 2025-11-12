import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			String binary = Integer.toBinaryString(M);
			char[] ch = binary.toCharArray();
			
			boolean isOk = true;
			
			for (int i = ch.length - N; i < ch.length; i++) {
				if(i < 0 || ch[i] == '0') {
					System.out.println("#" + test_case + " " + "OFF");
					isOk = false;
					break;
				}		
			}
			
			if(isOk) System.out.println("#" + test_case + " " + "ON");
		}
	}
}