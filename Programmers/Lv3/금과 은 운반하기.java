/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 금과 은 운반하기 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/86053
 */

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long minTime = 0;
        long maxTime = (long) ((10e9 * 2) * 10e5 * 2 + 1L);
        while (minTime < maxTime) {
            int gold = 0;
            int silver = 0;
            int total = 0;
            long mid = (minTime + maxTime) / 2;
            for (int i=0; i<w.length; i++) {
                int nowGold = g[i];
                int nowSilver = s[i];
                int nowWeight = w[i];
                long nowTime = t[i];
                long moveCount = mid / (nowTime * 2);
                if (mid % (nowTime * 2) >= nowTime) {
                    moveCount++;
                }
                gold += Math.min(nowGold, nowWeight * moveCount);
                silver += Math.min(nowSilver, nowWeight * moveCount);
                total += Math.min(nowGold + nowSilver, nowWeight * moveCount);
            }
            if (a <= gold && b <= silver && a + b <= total) {
                maxTime = mid;
            } else {
                minTime = mid + 1;
            }
        }

        return minTime;
    }
}