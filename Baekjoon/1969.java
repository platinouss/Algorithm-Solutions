import java.util.*;
import java.io.*;

class Main {
    static char[][] inputChar;
    static int[][] countArr;
    static int result = 0;
    static Map<Character, Integer> indexMap;
    static char[] DNA = {'T', 'G', 'C', 'A'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int inputSize = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        indexMap = Map.of(
                'T', 0,
                'G', 1,
                'C', 2,
                'A', 3
        );

        inputChar = new char[inputSize][length];
        countArr = new int[length][indexMap.size()];
        for (int i=0; i<inputSize; i++) {
            inputChar[i] = br.readLine().toCharArray();
            for(int j=0; j<length; j++) {
                countArr[j][indexMap.get(inputChar[i][j])]++;
            }
        }

        for (int i=0; i<length; i++) {
            bw.write(getMostChar(inputSize, i));
        }
        bw.write("\n");
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

        System.out.println(result);
    }

    public static char getMostChar(int length, int index) {
        char maxChar = 'A';
        int maxCount = 0;
        int[] counts = countArr[index];

        for(int i=0; i<counts.length; i++) {
            if (counts[i] >= maxCount) {
                maxCount = counts[i];
                maxChar = DNA[i];
            }
        }
        result += (length - maxCount);

        return maxChar;
    }
}