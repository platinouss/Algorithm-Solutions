/**
 * 백준 21276번 (골드 3)
 * 문제 이름 : 계보 복원가 호석
 * 알고리즘 분류 : 정렬, 해시, 위상 정렬
 * 링크 : https://www.acmicpc.net/problem/21276
 */

import java.util.*;
import java.io.*;

public class Main {

    static int[] indegrees;
    static List<List<Integer>> list = new ArrayList<>();
    static List<List<Integer>> result = new ArrayList<>();
    static Map<String, Integer> indexes = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        Arrays.sort(tmp);
        for (int i=0; i<N; i++) {
            indexes.put(tmp[i], i);
        }

        indegrees = new int[N];
        for (int i=0; i<N; i++) {
            list.add(new ArrayList<>());
            result.add(new ArrayList<>());
        }

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int childNum = indexes.get(st.nextToken());
            int parentNum = indexes.get(st.nextToken());
            list.get(parentNum).add(childNum);
            indegrees[childNum]++;
        }

        int familyCount = 0;
        List<Integer> roots = new ArrayList<>();
        for (int i=0; i<N; i++) {
            if (indegrees[i] == 0) {
                roots.add(i);
                familyCount++;
            }
        }
        sb.append(familyCount).append("\n");
        for (int root : roots) {
            sb.append(tmp[root]).append(" ");
        }
        sb.append("\n");

        for (int root : roots) {
            setResult(root);
        }

        for (int i=0; i<N; i++) {
            sb.append(tmp[i]).append(" ");
            int size = result.get(i).size();
            if (size == 0) {
                sb.append("0").append("\n");
                continue;
            }
            sb.append(size).append(" ");
            Collections.sort(result.get(i));
            for (int person : result.get(i)) {
                sb.append(tmp[person]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void setResult(int root) {
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int index = q.poll();
            for (int idx : list.get(index)) {
                indegrees[idx]--;
                if (indegrees[idx] == 0) {
                    result.get(index).add(idx);
                    q.add(idx);
                }
            }
        }
    }
}