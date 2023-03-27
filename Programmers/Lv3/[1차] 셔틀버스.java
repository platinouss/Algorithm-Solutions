/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : [1차] 셔틀버스 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17678
 */

import java.util.*;

class Solution {

    static final int START_TIME = 9 * 60;

    static int[] arr;

    public String solution(int n, int t, int m, String[] timetable) {
        arr = new int[n];
        Arrays.sort(timetable);

        int index = 0;
        int lastTime = 0;
        for (int k=0; k<n; k++) {
            int count = 0;
            int busTime = START_TIME + (t * k);
            while(index < timetable.length) {
                int now = stringToInt(timetable[index]);
                if (count >= m || now > busTime) {
                    break;
                }
                count++;
                index++;
                lastTime = now;
            }
            arr[k] = count;
        }

        return getResult(lastTime, n, t, m);
    }

    private static String getResult(int lastTime, int n, int t, int m) {
        if (arr[n-1] < m) {
            return intToString(START_TIME + (t * (n - 1)));
        }
        return intToString(lastTime - 1);
    }


    private static int stringToInt(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    private static String intToString(int time) {
        int hour = time / 60;
        int min = time % 60;
        return String.format("%02d:%02d", hour, min);
    }
}