/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 주식가격 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42584
 */

import java.util.*;

class Solution {

    static Stack<Node> stack = new Stack<>();

    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        for (int i=0; i<N; i++) {
            if (stack.isEmpty()) {
                stack.push(new Node(i, prices[i]));
                continue;
            }
            while (!stack.isEmpty() && stack.peek().value > prices[i]) {
                Node node = stack.pop();
                answer[node.index] = i - node.index;
            }
            stack.push(new Node(i, prices[i]));
        }

        for (int i=N-1; i>=0; i--) {
            if (answer[i] == 0) {
                answer[i] = N - 1 - i;
            }
        }

        return answer;
    }
}

class Node {
    int index, value;

    public Node (int i, int v) {
        this.index = i;
        this.value = v;
    }
}