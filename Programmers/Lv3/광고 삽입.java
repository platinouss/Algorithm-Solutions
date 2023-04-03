/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 광고 삽입 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/72414
 */

import java.util.*;

class Solution {

    static long[] arr;

    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = parseTime(play_time);
        int advTime = parseTime(adv_time);
        arr = new long[playTime + 1];
        for (String log : logs) {
            String[] tmp = log.split("-");
            int start = parseTime(tmp[0]);
            int end = parseTime(tmp[1]);
            arr[start]++;
            arr[end]--;
        }
        for (int i=1; i<=playTime; i++) {
            arr[i] += arr[i - 1];
        }
        for (int i=1; i<=playTime; i++) {
            arr[i] += arr[i - 1];
        }
        int index = 0;
        long distance = arr[advTime - 1];
        for (int i=0; i+advTime<=playTime; i++) {
            long d = arr[i+advTime] - arr[i];
            if (distance < d) {
                distance = d;
                index = i + 1;
            }
        }

        return String.format("%02d:%02d:%02d", index / 60 / 60, (index / 60) % 60, index % 60);
    }

    private static int parseTime(String str) {
        String[] arr = str.split(":");
        int hour = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1]);
        int second = Integer.parseInt(arr[2]);
        return (hour * 60 * 60) + (min * 60) + second;
    }
}