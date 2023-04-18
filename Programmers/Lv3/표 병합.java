/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 표 병합 (Lv3)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/150366
 */

import java.util.*;

class Solution {

    static int[] arr = new int[2500];
    static List<String> answer = new ArrayList<>();
    static Map<Integer, String> map = new HashMap<>();

    public String[] solution(String[] commands) {
        for (int i=0; i<2500; i++) {
            arr[i] = i;
            map.put(i, "");
        }
        for (String command : commands) {
            runCommand(command);
        }
        return answer.toArray(new String[answer.size()]);
    }

    private static void runCommand(String str) {
        String[] tmp = str.split(" ");
        String cmd = tmp[0];
        if (cmd.equals("UPDATE")) {
            if (tmp.length == 4) { update(sToI(tmp[1]), sToI(tmp[2]), tmp[3]); }
            else { update(tmp[1], tmp[2]); }
        }
        if (cmd.equals("MERGE")) {
            merge(sToI(tmp[1]), sToI(tmp[2]), sToI(tmp[3]), sToI(tmp[4]));
        }
        if (cmd.equals("UNMERGE")) {
            unmerge(sToI(tmp[1]), sToI(tmp[2]));
        }
        if (cmd.equals("PRINT")) {
            print(sToI(tmp[1]), sToI(tmp[2]));
        }
    }

    private static void update(int a, int b, String food) {
        int idx = find(convertIndex(a, b));
        map.put(idx, food);
    }

    private static void update(String before, String after) {
        for (int idx : map.keySet()) {
            if (map.get(idx).equals(before)) {
                map.put(idx, after);
            }
        }
    }

    private static void merge(int i1, int j1, int i2, int j2) {
        int idx1 = find(convertIndex(i1, j1));
        int idx2 = find(convertIndex(i2, j2));
        if (idx1 == idx2) {
            return;
        }
        String food = (map.get(idx1).equals("")) ? map.get(idx2) : map.get(idx1);
        map.put(idx1, "");
        map.put(idx2, "");
        if (idx1 < idx2) {
            arr[idx2] = idx1;
            map.put(idx1, food);
        } else {
            arr[idx1] = idx2;
            map.put(idx2, food);
        }
    }

    private static void unmerge(int a, int b) {
        int idx = find(convertIndex(a, b));
        String food = map.get(idx);
        map.put(idx, "");
        map.put(convertIndex(a, b), food);

        List<Integer> tmp = new ArrayList<>();
        for (int i=0; i<2500; i++) {
            if (find(i) == idx) {
                tmp.add(i);
            }
        }
        for (int index : tmp) {
            arr[index] = index;
        }
    }

    private static void print(int a, int b) {
        int idx = find(convertIndex(a, b));
        if (!map.get(idx).equals("")) {
            answer.add(map.get(idx));
        } else {
            answer.add("EMPTY");
        }
    }

    private static int find(int index) {
        if (arr[index] == index) {
            return index;
        }
        return arr[index] = find(arr[index]);
    }


    private static int convertIndex(int a, int b) {
        return (50 * (a - 1)) + (b-1);
    }

    private static int sToI(String str) {
        return Integer.parseInt(str);
    }
}