import java.io.*;
import java.util.*;

public class TheCheapestWay {
    // https://coderun.yandex.ru/problem/cheapest-way
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] size = reader.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M =  Integer.parseInt(size[1]);

        int[][] matrix = new int[N][M];
        int[][] minWeightMatrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] numbers = reader.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                minWeightMatrix[i][j] = Integer.MAX_VALUE;
                matrix[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        int[] moveX = new int[]{0, 1};
        int[] moveY = new int[]{1, 0};
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        queueX.add(0);
        queueY.add(0);
        minWeightMatrix[0][0] = matrix[0][0];
        while (!queueX.isEmpty()) {
            int x = queueX.remove();
            int y = queueY.remove();
            int weight = minWeightMatrix[x][y];
            for (int i = 0; i < moveX.length; i++) {
                int nextX =  x + moveX[i];
                int nextY =  y + moveY[i];
                if (nextX < N && nextY < M ) {
                    int nextWeight =  weight + matrix[nextX][nextY];
                    if (nextWeight < minWeightMatrix[nextX][nextY]) {
                        minWeightMatrix[nextX][nextY] = nextWeight;
                        queueX.add(nextX);
                        queueY.add(nextY);
                    }
                }
            }
            print(minWeightMatrix);
        }

        writer.write(String.valueOf(minWeightMatrix[N-1][M-1]));

        reader.close();
        writer.close();
    }

    static void print(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.print("\n");
        }
    }
}
