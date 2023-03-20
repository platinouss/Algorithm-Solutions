/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 디스크 컨트롤러 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42627
 */

import java.util.*;

class Solution {

    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
        return o1[1] - o2[1];
    });

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        int time = 0;
        int total = 0;
        int index = 0;
        int count = 0;
        while (count < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= time) {
                pq.add(jobs[index]);
                index++;
            }
            if (pq.isEmpty()) {
                time = jobs[index][0];
            } else {
                int[] job = pq.remove();
                total += (time + job[1] - job[0]);
                time += job[1];
                count++;
            }
        }

        return total / jobs.length;
    }
}