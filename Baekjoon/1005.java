/**
 * 백준 1005번 (골드 3)
 * 문제 이름 : ACM Craft
 * 알고리즘 분류 : DP, 위상 정렬
 * 링크 : https://www.acmicpc.net/problem/1005
 */

import java.io.*;
import java.util.*;

public class Main {

    static int[] buildTime;
    static int[] indegree;
    static int[] dp;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalCount = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int k=0; k<totalCount; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int buildingCount = Integer.parseInt(st.nextToken());
            int lineCount = Integer.parseInt(st.nextToken());

            buildTime = new int[buildingCount + 1];
            indegree = new int[buildingCount + 1];

            dp = new int[buildingCount + 1];
//            Arrays.fill(dp, 100_001);

            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=buildingCount; i++) {
                buildTime[i] = Integer.parseInt(st.nextToken());
            }

            list = new ArrayList<>();
            for (int i=0; i<=buildingCount; i++) { list.add(new ArrayList<>()); }
            for (int i=0; i<lineCount; i++) {
                st = new StringTokenizer(br.readLine());
                int sBuilding = Integer.parseInt(st.nextToken());
                int eBuilding = Integer.parseInt(st.nextToken());
                list.get(sBuilding).add(eBuilding);
                indegree[eBuilding]++;
            }
            int endBuilding = Integer.parseInt(br.readLine());

            getResult();

            sb.append(dp[endBuilding]).append("\n");
        }
        System.out.print(sb);
    }

    private static void getResult() {
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<indegree.length; i++) {
            if (indegree[i] == 0) {
                dp[i] = buildTime[i];
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int index = q.remove();
            for (int eIndex : list.get(index)) {
                indegree[eIndex]--;
                dp[eIndex] = Math.max(dp[eIndex], dp[index] + buildTime[eIndex]);

                if (indegree[eIndex] == 0) { q.add(eIndex); }
            }
        }
    }
}