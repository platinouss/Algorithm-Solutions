/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 과제 진행하기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/176962
 */

import java.util.*;

class Solution {

    static int N;
    static int index = 0;
    static String[] answer;
    static Stack<Work> stack = new Stack<>();
    static PriorityQueue<Work> pq = new PriorityQueue<>();

    public String[] solution(String[][] plans) {
        N = plans.length;
        answer = new String[N];
        for (String[] plan : plans) {
            pq.add(new Work(strToTime(plan[1]), Integer.parseInt(plan[2]), plan[0]));
        }
        start();
        allFinish();
        return answer;
    }

    private static void start() {
        int now = pq.peek().time;
        while (!pq.isEmpty()) {
            Work work = pq.remove();
            if (pq.isEmpty()) {
                answer[index++] = work.name;
                allFinish();
            } else {
                int remain = pq.peek().time - work.time;
                if (work.remain <= remain) {
                    answer[index++] = work.name;
                    startRemainTime(remain - work.remain);
                } else {
                    work.remain -= remain;
                    stack.push(work);
                }
                now = pq.peek().time;
            }
        }
    }

    private static void allFinish() {
        while (!stack.isEmpty()) {
            Work work = stack.pop();
            answer[index++] = work.name;
        }
    }

    private static void startRemainTime(int remain) {
        if (stack.isEmpty() || remain <= 0) {
            return;
        }
        while (remain > 0 && !stack.isEmpty()) {
            Work work = stack.pop();
            if (work.remain <= remain) {
                answer[index++] = work.name;
                remain -= work.remain;
            } else {
                work.remain -= remain;
                stack.push(work);
                remain = 0;
            }
        }
    }

    private static int strToTime(String str) {
        String[] arr = str.split(":");
        int hour = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1]);
        return hour * 60 + min;
    }
}

class Work implements Comparable<Work> {
    int time, remain;
    String name;

    public Work(int t, int r, String n) {
        this.time = t;
        this.remain = r;
        this.name = n;
    }

    @Override
    public int compareTo(Work work) {
        return this.time - work.time;
    }
}