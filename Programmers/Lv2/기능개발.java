/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 가눙개발 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */

import java.util.*;

class Solution {

    static int N;
    static List<Integer> list = new ArrayList<>();

    public int[] solution(int[] progresses, int[] speeds) {
        int index = 0;
        N = progresses.length;
        while (index < N) {
            int day = getCompleteDay(index, progresses, speeds);
            progress(day, progresses, speeds);
            int count = 0;
            for (int i=index; i<N; i++) {
                if (progresses[i] >= 100) {
                    count++;
                    index = i + 1;
                } else {
                    index = i;
                    break;
                }
            }
            list.add(count);
        }

        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    private static int getCompleteDay(int idx, int[] progresses, int[] speeds) {
        double min = 100 - progresses[idx];
        return (int) Math.ceil(min / speeds[idx]);
    }

    private static void progress(int day, int[] progresses, int[] speeds) {
        for (int i=0; i<N; i++) {
            progresses[i] += speeds[i] * day;
        }
    }
}