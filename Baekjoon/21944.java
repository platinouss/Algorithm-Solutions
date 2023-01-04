/**
 * 백준 21944번 (골드 2)
 * 문제 이름 : 문제 추천 시스템 Version 2
 * 알고리즘 분류 : 이진 검색 트리
 * 링크 : https://www.acmicpc.net/problem/21944
 */

import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<com.company.Main.Node> {
        int number, difficulty, groupId;

        public Node(int n, int d, int g) {
            this.number = n;
            this.difficulty = d;
            this.groupId = g;
        }

        @Override
        public int compareTo(com.company.Main.Node o) {
            if (this.difficulty == o.difficulty) {
                return this.number - o.number;
            }
            return this.difficulty - o.difficulty;
        }
    }

    static StringBuilder sb = new StringBuilder();

    static TreeSet<com.company.Main.Node> total = new TreeSet<>();
    static Map<Integer, Integer> algoInfo = new HashMap<>();
    static Map<Integer, Integer> diffInfo = new HashMap<>();
    static Map<Integer, TreeSet<com.company.Main.Node>> map = new HashMap<>();

    private static void addProblem(int number, int difficulty, int groupId) {
        total.add(new com.company.Main.Node(number, difficulty, groupId));
        if (!map.containsKey(groupId)) {
            map.put(groupId, new TreeSet<>());
            map.get(groupId).add(new com.company.Main.Node(number, difficulty, groupId));
        } else {
            map.get(groupId).add(new com.company.Main.Node(number, difficulty, groupId));
        }
        algoInfo.put(number, groupId);
        diffInfo.put(number, difficulty);
    }

    private static void recommend(int groupId, int condition) {
        if (condition == 1) {
            sb.append(map.get(groupId).last().number).append("\n");
        }
        if (condition == -1) {
            sb.append(map.get(groupId).first().number).append("\n");
        }
    }

    private static void recommend2(int condition) {
        if (condition == 1) {
            sb.append(total.last().number).append("\n");
        }
        if (condition == -1) {
            sb.append(total.first().number).append("\n");
        }
    }

    private static void recommend3(int condition, int diff) {
        if (condition == 1) {
            com.company.Main.Node n = total.ceiling(new com.company.Main.Node(0, diff, 0));
            if (n == null) {
                sb.append("-1").append("\n");
                return;
            }
            sb.append(n.number).append("\n");
        }
        if (condition == -1) {
            com.company.Main.Node n = total.floor(new com.company.Main.Node(0, diff, 0));
            if (n == null) {
                sb.append("-1").append("\n");
                return;
            }
            sb.append(n.number).append("\n");
        }
    }

    private static void solvedProblem(int number) {
        int groupId = algoInfo.get(number);
        int difficulty = diffInfo.get(number);
        total.remove(new com.company.Main.Node(number, difficulty, groupId));
        map.get(groupId).remove(new com.company.Main.Node(number, difficulty, groupId));
        algoInfo.remove(number);
        diffInfo.remove(number);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int number = Integer.parseInt(st.nextToken());
            int difficulty = Integer.parseInt(st.nextToken());
            int groupId = Integer.parseInt(st.nextToken());
            addProblem(number, difficulty, groupId);
        }
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            String[] arr = br.readLine().split(" ");
            String command = arr[0];
            if (command.equals("add")) {
                addProblem(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]));
            }
            if (command.equals("recommend")) {
                recommend(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
            }
            if (command.equals("recommend2")) {
                recommend2(Integer.parseInt(arr[1]));
            }
            if (command.equals("recommend3")) {
                recommend3(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
            }
            if (command.equals("solved")) {
                solvedProblem(Integer.parseInt(arr[1]));
            }
        }
        System.out.print(sb);
    }
}