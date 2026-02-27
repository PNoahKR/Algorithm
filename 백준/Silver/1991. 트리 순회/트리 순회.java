import java.io.*;
import java.util.*;

class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    // 알파벳 수만큼만 넣을 수 있음
    static Node[] tree = new Node[26];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parentValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            // 배열 - 'A' 로 배열 채우기
            if (tree[parentValue - 'A'] == null) {
                tree[parentValue - 'A'] = new Node(parentValue);
            }

            //왼쪽
            if(leftValue != '.') {
                tree[leftValue - 'A'] = new Node(leftValue);
                tree[parentValue - 'A'].left = tree[leftValue - 'A'];
            }

            //오른쪽
            if(rightValue != '.') {
                tree[rightValue - 'A'] = new Node(rightValue);
                tree[parentValue - 'A'].right = tree[rightValue - 'A'];
            }
        }

        preorder(tree[0]);
        System.out.println();

        inorder(tree[0]);
        System.out.println();

        postorder(tree[0]);
        System.out.println();
    }

    private static void preorder(Node node) {
        if (node == null) return;

        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    private static void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    private static void postorder(Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
}