/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 뒤에 있는 큰 수 찾기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/154539
 */

import java.util.*;

class Solution {

    static Stack<Integer> stack = new Stack<>();

    public int[] solution(int[] numbers) {
        int N = numbers.length;
        int[] answer = new int[N];

        for (int i=0; i<N; i++) {
            if (stack.isEmpty() || numbers[i] <= numbers[i-1]) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}