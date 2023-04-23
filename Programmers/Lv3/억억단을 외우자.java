/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 억억단을 외우자 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/138475
 */

import java.util.*;

class Solution {

    static Node[] arr;

    public int[] solution(int e, int[] starts) {
        arr = new Node[e + 1];
        for (int i=0; i<=e; i++) {
            arr[i] = new Node(i, 0);
        }
        for (int i=1; i<=e; i++) {
            for (int j=i; j<=e; j+=i) {
                arr[j].count++;
            }
        }
        Arrays.sort(arr);
        int[] answer = new int[starts.length];
        for (int i=0; i<starts.length; i++) {
            for (int j=0; j<=e; j++) {
                if (arr[j].num >= starts[i]) {
                    answer[i] = arr[j].num;
                    break;
                }
            }
        }
        return answer;
    }
}

class Node implements Comparable<Node> {
    int num, count;

    public Node(int num, int count) {
        this.num = num;
        this.count = count;
    }

    @Override
    public int compareTo(Node n) {
        if (this.count == n.count) {
            return this.num - n.num;
        }
        return n.count - this.count;
    }
}