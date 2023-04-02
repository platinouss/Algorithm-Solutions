/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 디펜스 게임 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/142085
 */

import java.util.*;

class Solution {

    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public int solution(int n, int k, int[] enemy) {
        int count = 0;
        for (int damage : enemy) {
            n -= damage;
            pq.add(damage);
            if (n < 0) {
                if (k < 1) {
                    break;
                }
                n += pq.remove();
                k--;
            }
            count++;
        }

        return count;
    }
}