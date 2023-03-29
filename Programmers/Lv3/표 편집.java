/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 표 편집 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/81303
 */

import java.util.*;

class Solution {

    static Node now;
    static Stack<Node> trash = new Stack<>();

    public String solution(int n, int k, String[] cmd) {
        Node nowNode = new Node(0);
        if (k == 0) {
            now = nowNode;
        }
        for (int i=1; i<n; i++) {
            nowNode.next = new Node(i);
            if (i == k) {
                now = nowNode.next;
            }
            nowNode.next.prev = nowNode;
            nowNode = nowNode.next;
        }
        for (String command : cmd) {
            runCommand(command);
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append("O");
        }
        while (!trash.isEmpty()) {
            Node tmp = trash.pop();
            sb.setCharAt(tmp.index, 'X');
        }
        return sb.toString();
    }

    private static void runCommand(String str) {
        String[] arr = str.split(" ");
        String command = arr[0];
        if (command.equals("U")) {
            int value = Integer.parseInt(arr[1]);
            moveUp(value);
        }
        if (command.equals("D")) {
            int value = Integer.parseInt(arr[1]);
            moveDown(value);
        }
        if (command.equals("C")) {
            remove();
        }
        if (command.equals("Z")) {
            restore();
        }
    }

    private static void moveUp(int value) {
        while (value-- > 0) {
            if (now.prev == null) {
                break;
            }
            now = now.prev;
        }
    }

    private static void moveDown(int value) {
        while (value-- > 0) {
            if (now.next == null) {
                break;
            }
            now = now.next;
        }
    }

    private static void remove() {
        trash.push(now);
        if (now.next == null && now.prev != null) {
            now = now.prev;
            now.next = null;
        } else if (now.prev == null && now.next != null) {
            now = now.next;
            now.prev = null;
        } else if (now.prev == null && now.next == null) {
            return;
        } else {
            now.prev.next = now.next;
            now.next.prev = now.prev;
            now = now.next;
        }
    }

    private static void restore() {
        Node node = trash.pop();
        if (node.prev != null) {
            node.prev.next = node;
        }
        if (node.next != null) {
            node.next.prev = node;
        }
    }
}

class Node {
    int index;
    Node prev, next;

    public Node(int i) {
        this.index = i;
    }
}