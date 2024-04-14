/**
 * [Baekjoon] 2437. 저울
 * https://www.acmicpc.net/problem/2437
 *
 */

import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[] weights;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weights = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(weights);
    }

    public static void main (String[] args) throws IOException {
        input();
        int sum = 0;
        for (int weight : weights) {
            if (weight > sum + 1) {
                break;
            }
            sum = sum + weight;
        }
        System.out.println(sum + 1);
    }
}
