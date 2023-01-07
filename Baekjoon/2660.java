/**
 * 백준 2660번 (골드 5)
 * 문제 이름 : 회장 뽑기
 * 알고리즘 분류 : 그래프, 플로이드 워셜
 * 링크 : https://www.acmicpc.net/problem/2660
 */

import java.util.*;
import java.io.*;

public class Main {

    static final int MAX_VALUE = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> friends = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            friends.add(new ArrayList<>());
        }

        int[][] arr = new int[N + 1][N + 1];
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                if (i != j) {
                    arr[i][j] = MAX_VALUE;
                }
            }
        }


        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sIndex = Integer.parseInt(st.nextToken());
            int eIndex = Integer.parseInt(st.nextToken());
            if (sIndex == -1 && eIndex == -1) {
                break;
            }
            arr[sIndex][eIndex] = 1;
            arr[eIndex][sIndex] = 1;
        }

        for (int k=1; k<=N; k++) {
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int minScore = MAX_VALUE;
        int[] scores = new int[N + 1];
        for (int i=1; i<=N; i++) {
            int score = 0;
            for (int j=1; j<=N; j++) {
                if (arr[i][j] != MAX_VALUE) {
                    score = Math.max(score, arr[i][j]);
                }
            }
            scores[i] = score;
            minScore = Math.min(minScore, score);
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            if (scores[i] == minScore) {
                count++;
                sb.append(i).append(" ");
            }
        }

        System.out.println(minScore + " " + count);
        System.out.println(sb);
    }
}