/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 길 찾기 게임 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42892
 */

import java.util.*;

class Solution {

    static List<Node> nodes = new ArrayList<>();
    static int idx = 0;
    static int[][] answer;

    public int[][] solution(int[][] nodeinfo) {
        for (int i=0; i<nodeinfo.length; i++) {
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i+1));
        }
        Collections.sort(nodes, (o1, o2) -> {
            if (o1.y == o2.y) {
                return o1.x - o2.x;
            }
            return o2.y - o1.y;
        });

        Node root = nodes.get(0);
        for (int i=1; i<nodes.size(); i++) {
            setNode(root, nodes.get(i));
        }

        answer = new int[2][nodeinfo.length];
        idx = 0;
        preOrder(root);
        idx = 0;
        postOrder(root);

        return answer;
    }

    private static void preOrder(Node parent) {
        if (parent == null) {
            return;
        }
        answer[0][idx++] = parent.index;
        preOrder(parent.left);
        preOrder(parent.right);
    }

    private static void postOrder(Node parent) {
        if (parent == null) {
            return;
        }
        postOrder(parent.left);
        postOrder(parent.right);
        answer[1][idx++] = parent.index;
    }

    private static void setNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                setNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                setNode(parent.right, child);
            }
        }
    }
}

class Node {
    Node left, right;
    int x, y, index;

    public Node(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
}