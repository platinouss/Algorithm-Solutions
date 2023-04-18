/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : [1차] 추석 트래픽 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17676
 */

import java.util.*;

class Solution {

    static List<Response> responses = new ArrayList<>();

    public int solution(String[] lines) {
        for (String line : lines) {
            responses.add(sToTime(line));
        }
        int count = 0;
        for (int i=0; i<responses.size(); i++) {
            Response res = responses.get(i);
            count = Math.max(count, getCount(res.start, i));
            count = Math.max(count, getCount(res.end, i));
        }
        return count;
    }

    private static int getCount(int start, int index) {
        int count = 1;
        int end = start + 1000;
        for (int j=0; j<responses.size(); j++) {
            if (index == j) {
                continue;
            }
            if (responses.get(j).end < start || responses.get(j).start >= end) {
                continue;
            }
            count++;
        }
        return count;
    }

    private static Response sToTime(String s) {
        String[] str = s.split(" ");
        String[] tmp = str[1].split(":");
        int current = 0;
        int hour = Integer.parseInt(tmp[0]) * 60 * 60 * 1000;
        int min = Integer.parseInt(tmp[1]) * 60 * 1000;
        int second = Integer.parseInt(tmp[2].substring(0, 2)) * 1000 + Integer.parseInt(tmp[2].substring(3, 6));
        if (str[2].length() > 2) {
            current = Integer.parseInt(str[2].substring(0, 1)) * 1000 +
                    Integer.parseInt(str[2].substring(2, str[2].length() - 1));
        } else {
            current = Integer.parseInt(str[2].substring(0, 1)) * 1000;
        }
        int end = hour + min + second;
        int start = end - current + 1;
        return new Response(start, end);
    }
}

class Response {
    int start, end;

    public Response(int start, int end) {
        this.start = start;
        this.end = end;
    }
}