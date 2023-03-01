/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 이중우선순위큐 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42628
 */

import java.util.*;

class Solution {

    static PriorityQueue<Integer> minPq = new PriorityQueue<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public int[] solution(String[] operations) {
        for (String operation : operations) {
            String[] oper = operation.split(" ");
            String command = oper[0];
            Integer num = Integer.parseInt(oper[1]);

            if (command.equals("I")) {
                minPq.add(num);
                pq.add(num);
                continue;
            }

            if (command.equals("D")) {
                if (pq.size() < 1) {
                    continue;
                }
                if (num == 1) {
                    int v = pq.remove();
                    minPq.remove(v);
                } else if (num == -1) {
                    int v = minPq.remove();
                    pq.remove(v);
                }
            }
        }

        int[] answer = {0, 0};
        if (pq.size() > 0) {
            answer[0] = pq.remove();
            answer[1] = minPq.remove();
        }

        return answer;
    }
}