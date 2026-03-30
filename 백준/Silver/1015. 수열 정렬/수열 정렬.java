import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Element implements Comparable<Element> {
    int value;
    int index;

    public Element(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Element o) {
        
        if (this.value == o.value) {
            return this.index - o.index;
        }

        return this.value - o.value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Element[] arr = new Element[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = new Element(Integer.parseInt(st.nextToken()), i);
        }

        Arrays.sort(arr);

        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            P[arr[i].index] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(' ');
        }
        
        System.out.println(sb);
    }
}