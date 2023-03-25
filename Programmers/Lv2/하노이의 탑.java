/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 하노이의 탑 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12946
 */

import java.util.*;

class Solution {

    static List<int[]> list = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        int[][] answer = new int[list.size()][2];
        for (int i=0; i<list.size(); i++) {
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        return answer;
    }

    private static void hanoi(int n, int start, int via, int end) {
        int[] tmp = {start, end};
        if (n == 1) {
            list.add(tmp);
            return;
        }

        hanoi(n-1, start, end, via);
        list.add(tmp);
        hanoi(n-1, via, start, end);
    }
}