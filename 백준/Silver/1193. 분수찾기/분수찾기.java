import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int crossCount = 1;
        int prevCountSum = 0;

        while (true) {
            if (X <= prevCountSum + crossCount) {

                int position = X - prevCountSum; 
                
                if (crossCount % 2 == 1) { 
                    System.out.println((crossCount - position + 1) + "/" + position);
                    break;
                } else { 
                    System.out.println(position + "/" + (crossCount - position + 1));
                    break;
                }
            } else {
                prevCountSum += crossCount;
                crossCount++;
            }
        }
    }
}