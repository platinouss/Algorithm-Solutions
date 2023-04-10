/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 양궁대회 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/92342
 */

import java.util.*;

class Solution {

    static int max = -1;
    static int[] tmp = new int[11];
    static List<int[]> ryanScores = new ArrayList<>();

    public int[] solution(int n, int[] info) {
        combination(0, 0, n, info);
        if (ryanScores.size() == 0) {
            return new int[] {-1};
        }

        Collections.sort(ryanScores, (o1, o2) -> {
            for (int i=10; i>=0; i--) {
                if (o1[i] != o2[i]) {
                    return o2[i] - o1[i];
                }
            }
            return 0;
        });
        return ryanScores.get(0);
    }

    private static void combination(int depth, int index, int N, int[] apeach) {
        if (depth == N) {
            calculateScore(apeach);
            return;
        }
        for (int i=index; i<=10; i++) {
            if (tmp[i] > apeach[i]) {
                continue;
            }
            tmp[i]++;
            combination(depth + 1, i, N, apeach);
            tmp[i]--;
        }
    }

    private static void calculateScore(int[] apeach) {
        int ryanScore = 0;
        int apeachScore = 0;
        for (int i=0; i<=10; i++) {
            if (tmp[i] == 0 && apeach[i] == 0) {
                continue;
            }
            int score = 10 - i;
            if (tmp[i] > apeach[i]) { ryanScore += score; }
            if (tmp[i] <= apeach[i]) { apeachScore += score; }
        }
        int diff = ryanScore - apeachScore;
        if (diff <= 0) {
            return;
        }
        if (max < diff) {
            max = diff;
            ryanScores.clear();
            ryanScores.add(tmp.clone());
        }
        if (max == diff) {
            ryanScores.add(tmp.clone());
        }
    }
}