/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 캠핑 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/1833
 */

import java.util.*;

class Solution {

    static int count;
    static int[][] dp;
    static List<Integer> xList;
    static List<Integer> yList;

    public int solution(int n, int[][] data) {
        init();
        for (int[] point : data) {
            xList.add(point[0]);
            yList.add(point[1]);
        }
        List<Integer> uniqueX = new ArrayList<>(new HashSet<Integer>(xList));
        List<Integer> uniqueY = new ArrayList<>(new HashSet<Integer>(yList));
        Collections.sort(uniqueX);
        Collections.sort(uniqueY);
        for (int i=0; i<n; i++) {
            data[i][0] = uniqueX.indexOf(xList.get(i));
            data[i][1] = uniqueY.indexOf(yList.get(i));
            dp[data[i][1]][data[i][0]] = 1;
        }
        for (int a=0; a<5000; a++) {
            for (int b=0; b<5000; b++) {
                dp[a][b] += ((a - 1 >= 0 ? dp[a - 1][b] : 0)
                        + (b - 1 >= 0 ? dp[a][b - 1] : 0)
                        - (a - 1 >= 0 && b - 1 >= 0 ? dp[a - 1][b - 1] : 0));
            }
        }
        Arrays.sort(data, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int x1 = Math.min(data[i][0], data[j][0]), x2 = Math.max(data[i][0], data[j][0]);
                int y1 = Math.min(data[i][1], data[j][1]), y2 = Math.max(data[i][1], data[j][1]);
                if (x1 == x2 || y1 == y2) {
                    continue;
                }
                int v = dp[y2 - 1][x2 - 1] - dp[y2 - 1][x1] - dp[y1][x2 - 1] + dp[y1][x1];
                if (v == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private static void init() {
        count = 0;
        dp = new int[5000][5000];
        xList = new ArrayList<>();
        yList = new ArrayList<>();
    }
}