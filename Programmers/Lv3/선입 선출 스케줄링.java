/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 선입 선출 스케줄링 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12920
 */

class Solution {

    static int total;

    public int solution(int n, int[] cores) {
        int time = binarySearch(n, cores);
        total -= n;
        for (int i=cores.length-1; i>=0; i--) {
            if (time % cores[i] == 0) {
                if (total == 0) {
                    return i+1;
                }
                total--;
            }
        }
        return -1;
    }

    private static int binarySearch(int N, int[] cores) {
        int s = 0;
        int e = 10000 * N + 1;
        while (s < e) {
            int mid = (s + e) / 2;
            int count = getCount(mid, cores);
            if (count < N) {
                s = mid + 1;
            } else {
                total = count;
                e = mid;
            }
        }
        return s;
    }

    private static int getCount(int time, int[] cores) {
        int count = cores.length;
        if (time == 0) {
            return count;
        }
        for (int core : cores) {
            count += time / core;
        }
        return count;
    }
}