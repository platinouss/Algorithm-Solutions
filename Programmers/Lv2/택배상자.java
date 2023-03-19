/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 택배상자 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/131704
 */

import java.util.*;

class Solution {

    static int answer = 0;
    static Stack<Integer> stack = new Stack<>();

    public int solution(int[] order) {
        int num = 1;
        for (int i=0; i<order.length; i++) {
            int condition = order[i];

            if (num < condition) {
                while (num < condition) {
                    stack.push(num++);
                }
            }

            if (num == condition) {
                answer++;
                num++;
            } else {
                if (!stack.isEmpty() && stack.peek() == condition) {
                    stack.pop();
                    answer++;
                    continue;
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}
