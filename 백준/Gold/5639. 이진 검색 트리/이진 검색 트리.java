import java.io.*;
import java.util.*;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    // 이진 검색 트리 삽입 메서드
    public void insert(int n) {
        if (n < this.value) {
            // 들어온 값이 현재 노드보다 작으면 왼쪽!
            if (this.left == null) {
                this.left = new Node(n); // 빈자리라면 삽입
            } else {
                this.left.insert(n);     // 이미 있다면 한 칸 더 내려감
            }
        } else {
            // 들어온 값이 현재 노드보다 크면 오른쪽!
            if (this.right == null) {
                this.right = new Node(n); // 빈자리라면 삽입
            } else {
                this.right.insert(n);     // 이미 있다면 한 칸 더 내려감
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        if (input == null || input.isEmpty()) return;
        
        Node root = new Node(Integer.parseInt(input));

        while (true) {
            input = br.readLine();
            
            if (input == null || input.isEmpty()) {
                break;
            }
            
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }

    private static void postOrder(Node node) {
        if (node == null) return;
        
        postOrder(node.left); // 왼쪽 끝까지
        postOrder(node.right); // 오른쪽 끝까지
        System.out.println(node.value); // 나 자신 출력
    }
}