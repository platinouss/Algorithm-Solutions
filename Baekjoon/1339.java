/**
 * [Baekjoon] 1339. 단어 수학
 * https://www.acmicpc.net/problem/1339
 *
 * 접근 방식
 * 1) 입력 값으로 주어진 문자열을 읽으면서, 알파벳의 가중치를 자리 수에 따라 부여하고 각 알파벳마다의 총 합을 저장한다.
 * 2) 높은 숫자를 총 합이 큰 알파벳부터 순서대로 부여한다.
 * 3) 알파벳 마다 부여된 숫자로 치환하여 입력 값으로 주어진 숫자들의 총 합을 구한다.
 */

import java.util.*;
import java.io.*;

class Main {

    static List<String> voca;
    static Map<Character, Integer> weights;
    static Map<Character, Integer> chars;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        voca = new ArrayList<>();
        chars = new HashMap<>();
        while (N-- > 0) {
            int depth = 1;
            String str = br.readLine();
            voca.add(str);
            for (int i=str.length()-1; i >= 0; i--) {
                chars.put(str.charAt(i), chars.getOrDefault(str.charAt(i), 0) + depth);
                depth *= 10;
            }
        }
    }

    private static void setWeight() {
        int weight = 9;
        weights = new HashMap<>();
        List<Character> alphabet = new ArrayList<>(chars.keySet());
        Collections.sort(alphabet, (o1, o2) -> chars.get(o2) - chars.get(o1));
        for (char c : alphabet) {
            weights.put(c, weight);
            weight--;
        }
    }

    private static int getMaxSum() {
        int sum = 0;
        for (String str : voca) {
            int number = 0;
            for (char c : str.toCharArray()) {
                number = number * 10 + weights.get(c);
            }
            sum += number;
        }
        return sum;
    }

    public static void main (String[] args) throws IOException {
        input();
        setWeight();
        System.out.println(getMaxSum());
    }
}
