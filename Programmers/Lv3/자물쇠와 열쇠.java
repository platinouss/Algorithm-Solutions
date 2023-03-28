/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 자물쇠와 열쇠 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/60059
 */

import java.util.*;

class Solution {

    static int[][] arr;
    static int[][][] keys;

    public boolean solution(int[][] key, int[][] lock) {
        int keyLen = key.length;
        int lockLen = lock.length;
        int len = (keyLen * 2) + lockLen - 2;
        arr = new int[len][len];
        keys = new int[4][keyLen][keyLen];

        for (int i=0; i<len; i++) {
            Arrays.fill(arr[i], -1);
        }

        int midIdx = keyLen-1;
        for (int i=midIdx; i<midIdx+lockLen; i++) {
            for (int j=midIdx; j<midIdx+lockLen; j++) {
                arr[i][j] = lock[i - midIdx][j - midIdx];
            }
        }
        makeKey(keyLen, key);

        for (int i = 0; i < len - keyLen + 1; i++) {
            for (int j = 0; j < len - keyLen + 1; j++) {
                if(isCorrect(i, j, midIdx, keyLen, lockLen)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isCorrect(int ii, int jj, int midIdx, int keyLen, int lockLen) {
        for (int k=0; k<4; k++) {
            int[][] tmp = new int[arr.length][arr.length];
            for (int i=0; i<arr.length; i++) {
                tmp[i] = arr[i].clone();
            }

            boolean check = true;
            for (int i=ii; i<ii+keyLen; i++) {
                for (int j=jj; j<jj+keyLen; j++) {
                    if (tmp[i][j] == 1 && keys[k][i - ii][j - jj] == 1) {
                        check = false;
                    }
                    if (tmp[i][j] == 0 && keys[k][i - ii][j - jj] == 1) {
                        tmp[i][j] = 1;
                    }
                }
            }
            if (!check) {
                continue;
            }
            check = true;
            for (int i=midIdx; i<midIdx+lockLen; i++) {
                for (int j=midIdx; j<midIdx+lockLen; j++) {
                    if (tmp[i][j] == 0) {
                        check = false;
                    }
                }
            }
            if (!check) {
                continue;
            }
            return true;
        }
        return false;
    }

    private static void makeKey(int keyLen, int[][] key) {
        int[][] tmp = new int[keyLen][keyLen];
        for (int i=0; i<keyLen; i++) {
            tmp[i] = key[i].clone();
        }
        for (int i=0; i<keyLen; i++) {
            keys[0][i] = tmp[i].clone();
        }
        for (int k=1; k<4; k++) {
            tmp = rotate(keyLen, tmp);
            for (int i=0; i<keyLen; i++) {
                keys[k][i] = tmp[i].clone();
            }
        }
    }

    private static int[][] rotate(int keyLen, int[][] arr) {
        int[][] tmp = new int[keyLen][keyLen];
        int tmpJ = 0;
        for (int i=keyLen-1; i>=0; i--) {
            int tmpI = 0;
            for (int j=0; j<keyLen; j++) {
                tmp[tmpI][tmpJ] = arr[i][j];
                tmpI++;
            }
            tmpJ++;
        }
        return tmp;
    }
}