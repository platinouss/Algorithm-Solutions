/**
 * 백준 9655번 (실버 5)
 * 문제 이름 : 돌 게임
 * 알고리즘 분류 : 수학, DP
 * 링크 : https://www.acmicpc.net/problem/9655
 */

import java.util.*;
import java.io.*;

class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N % 2 == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
