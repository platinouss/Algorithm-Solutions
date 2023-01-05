/**
 * 백준 1781번 (골드 2)
 * 문제 이름 : 컵라면
 * 알고리즘 분류 : 그리디, 우선순위 큐
 * 링크 : https://www.acmicpc.net/problem/1781
 */

import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int deadline, count;

        public Node(int d, int c) {
            this.deadline = d;
            this.count = c;
        }

        @Override
        public int compareTo(Node o) {
            if (this.deadline == o.deadline) {
                return o.count - this.count;
            }
            return this.deadline - o.deadline;
        }
    }

    static PriorityQueue<Integer> solvedQuestions = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node[] questions = new Node[N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int deadline =  Integer.parseInt(st.nextToken());
            int count =  Integer.parseInt(st.nextToken());
            questions[i] = new Node(deadline, count);
        }

        Arrays.sort(questions);

        for (Node question : questions) {
            int solvedCount = solvedQuestions.size();
            if (solvedCount < question.deadline) {
                solvedQuestions.add(question.count);
            }
            if (solvedCount == question.deadline) {
                int minCount = solvedQuestions.peek();
                if (minCount < question.count) {
                    solvedQuestions.remove();
                    solvedQuestions.add(question.count);
                }
            }
        }

        long totalCount = 0;
        for (int count : solvedQuestions) {
            totalCount += count;
        }

        System.out.println(totalCount);
    }
}