/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 2차원 동전 뒤집기 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/131703
 */

import java.util.*;

class Solution {

    static final int MAX_VALUE = 10 * 10 + 1;

    static int N, M;
    static int answer = MAX_VALUE;

    public int solution(int[][] beginning, int[][] target) {
        N = beginning.length;
        M = beginning[0].length;
        for (int bitmask=0; bitmask<(1 << N); bitmask++) {
            combinationRow(bitmask, cloneArr(beginning), target);
        }

        return (answer == MAX_VALUE) ? -1 : answer;
    }

    private static int[][] cloneArr(int[][] arr) {
        int[][] newArr = new int[N][M];
        for (int i=0; i<N; i++) {
            newArr[i] = arr[i].clone();
        }
        return newArr;
    }

    private static void combinationRow(int bitmask, int[][] arr, int[][] target) {
        int count = 0;
        for (int i=0; i<N; i++) {
            if ((bitmask & (1 << i)) > 0) {
                reverseRow(i, arr);
                count++;
            }
        }
        for (int bit=0; bit<(1 << M); bit++) {
            combinationCol(bit, count, cloneArr(arr), target);
        }
    }

    private static void combinationCol(int bitmask, int count, int[][] arr, int[][] target) {
        int totalCount = 0;
        for (int j=0; j<M; j++) {
            if ((bitmask & (1 << j)) > 0) {
                reverseCol(j, arr);
                totalCount++;
            }
        }
        if (isSame(arr, target)) {
            answer = Math.min(answer, totalCount + count);
        }
    }

    private static boolean isSame(int[][] arr, int[][] target) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (arr[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void reverseRow(int index, int[][] arr) {
        for (int j=0; j<M; j++) {
            arr[index][j] = (arr[index][j] == 0) ? 1 : 0;
        }
    }

    private static void reverseCol(int index, int[][] arr) {
        for (int i=0; i<N; i++) {
            arr[i][index] = (arr[i][index] == 0) ? 1 : 0;
        }
    }
}