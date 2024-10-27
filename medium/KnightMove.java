import java.io.*;
import java.util.*;

public class KnightMove {
    // https://coderun.yandex.ru/problem/knight-move/description
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] size = reader.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);
        int[][] field = new int[N][M];

        int[] move_x = new int[]{2, 1};
        int[] move_y = new int[]{1, 2};
        field[0][0] = 1;

        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < M; j ++) {
                for (int move = 0; move < move_x.length; move++) {
                    int next_i = i + move_x[move];
                    int next_j = j + move_y[move];
                    if (next_i < N && next_j < M) {
                        field[next_i][next_j] += field[i][j];
                    }
                }
            }
        }

        writer.write(String.valueOf(field[N-1][M-1]));
        reader.close();
        writer.close();
    }
}
