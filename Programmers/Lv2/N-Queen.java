/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : N-Queen (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12952
 */



class Solution {

    static int count = 0;
    static Node[] nodes;

    public int solution(int n) {
        nodes = new Node[n];
        combination(0, n);
        return count;
    }

    private static void combination(int depth, int N) {
        if (depth == N) {
            count++;
        }
        for (int j=0; j<N; j++) {
            if (isPossible(depth, j)) {
                nodes[depth] = new Node(depth, j);
                combination(depth + 1, N);
            }
        }
    }

    private static boolean isPossible(int a, int b) {
        for (int i=0; i<a; i++) {
            Node node = nodes[i];
            if (node.j == b || Math.abs(node.i - a) == Math.abs(node.j - b)) {
                return false;
            }
        }
        return true;
    }
}

class Node {
    int i, j;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}