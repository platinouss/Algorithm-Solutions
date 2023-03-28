/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 순위 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/49191
 */

import java.util.*;

class Solution {

    static int[][] arr;

    public int solution(int n, int[][] results) {
        arr = new int[n][n];
        for (int[] result : results) {
            int win = result[0] - 1;
            int lose = result[1] - 1;
            arr[win][lose] = 1;
            arr[lose][win] = -1;
        }
        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                        arr[j][i] = -1;
                    }
                    if (arr[i][k] == -1 && arr[k][j] == -1) {
                        arr[i][j] = -1;
                        arr[j][i] = 1;
                    }
                }
            }
        }
        int result = 0;
        for (int i=0; i<n; i++) {
            int count = 0;
            for (int j=0; j<n; j++) {
                if (arr[i][j] != 0) {
                    count++;
                }
            }
            if (count == n - 1) {
                result++;
            }
        }
        return result;
    }
}