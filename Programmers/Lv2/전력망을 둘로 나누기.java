/**
 * 프로그래머스 코딩테스트 연습
 * 문제 이름 : 전력망을 둘로 나누기 (Lv2)
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/86971
 */

class Solution {

    static int min;
    static int[] arr;

    public int solution(int n, int[][] wires) {
        min = n + 1;
        arr = new int[n + 1];
        for (int i=0; i<n-1; i++) {
            for (int j=1; j<=n; j++) {
                arr[j] = j;
            }
            combination(i, wires);
            getResult(wires[i][0], wires[i][1], n + 1);
        }

        return min;
    }

    private static void getResult(int s, int e, int M) {
        int groupId1 = find(s);
        int groupId2 = find(e);
        int v1 = 0;
        int v2 = 0;
        for (int i=1; i<arr.length; i++) {
            int id = find(arr[i]);
            if (id == groupId1) {
                v1++;
            } else if (id == groupId2) {
                v2++;
            }
        }
        min = Math.min(min, Math.abs(v2 - v1));
    }

    private static void combination(int index, int[][] wires) {
        for (int i=0; i<wires.length; i++) {
            if (index == i) {
                continue;
            }
            if (find(wires[i][0]) != find(wires[i][1])) {
                union(wires[i][0], wires[i][1]);
            }
        }
    }

    private static void union(int i, int j) {
        int ii = find(i);
        int jj = find(j);

        if (ii < jj) {
            arr[jj] = ii;
        } else {
            arr[ii] = jj;
        }
    }

    private static int find(int v) {
        if (arr[v] == v) {
            return v;
        }
        return arr[v] = find(arr[v]);
    }
}