/**
 * 백준 2250번 (골드 2)
 * 문제 이름 : 트리의 높이와 너비
 * 알고리즘 분류 : 트리, DFS
 * 링크 : https://www.acmicpc.net/problem/2250
 */

import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int parent, num, left, right;

        public Node (int n, int l, int r) {
            this.parent = -1;
            this.num = n;
            this.left = l;
            this.right = r;
        }
    }

    static int[] min;
    static int[] max;
    static com.company.Main.Node[] trees;
    static int nodeIndex = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        trees = new com.company.Main.Node[N + 1];
        min = new int[N + 1];
        max = new int[N + 1];
        for (int i=1; i<=N; i++) {
            trees[i] = new com.company.Main.Node(i, -1, -1);
            min[i] = N;
            max[i] = 0;
        }

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            trees[num].left = left;
            trees[num].right = right;
            if (left != -1) {
                trees[left].parent = num;
            }
            if (right != -1) {
                trees[right].parent = num;
            }
        }

        int rootNum = 1;
        for (int i=1; i<=N; i++) {
            if (trees[i].parent == -1) {
                rootNum = i;
                break;
            }
        }

        int level = 1;
        int width = 0;
        inOrder(rootNum, level);

        for (int i=1; i<=N; i++) {
            int tmp = max[i] - min[i] + 1;
            if (width < tmp) {
                width = tmp;
                level = i;
            }
        }

        System.out.println(level + " " + width);
    }

    private static void inOrder(int root, int level) {
        com.company.Main.Node node = trees[root];
        if (node.left != -1) {
            inOrder(node.left, level + 1);
        }
        min[level] = Math.min(min[level], nodeIndex);
        max[level] = Math.max(max[level], nodeIndex);
        nodeIndex++;
        if (node.right != -1) {
            inOrder(node.right, level + 1);
        }
    }
}