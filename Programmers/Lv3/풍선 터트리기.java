/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 풍선 터트리기 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/68646
 */

class Solution {

    static int N;
    static int[] leftMins;
    static int[] rightMins;

    public int solution(int[] a) {
        N = a.length;
        leftMins = new int[N];
        rightMins = new int[N];

        int min = Integer.MAX_VALUE;
        for (int i=0; i<N; i++) {
            if (min > a[i]) {
                min = a[i];
                leftMins[i] = min;
            } else {
                leftMins[i] = min;
            }
        }
        min = Integer.MAX_VALUE;
        for (int i=N-1; i>=0; i--) {
            if (min > a[i]) {
                min = a[i];
                rightMins[i] = min;
            } else {
                rightMins[i] = min;
            }
        }

        int count = 0;
        for (int i=0; i<N; i++) {
            int mid = a[i];
            if (leftMins[i] < mid && rightMins[i] < mid) {
                count++;
            }
        }

        return N - count;
    }
}