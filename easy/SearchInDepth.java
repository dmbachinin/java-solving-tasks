import java.io.*;
import java.util.*;
public class SearchInDepth {
        // https://coderun.yandex.ru/problem/search-in-depth
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader("in.txt"));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] size = reader.readLine().split(" ");
            int N = Integer.parseInt(size[0]);
            int M = Integer.parseInt(size[1]);

            boolean[][] matrix = new boolean[N+1][N+1];
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                String[] chain = reader.readLine().split(" ");
                int v1 = Integer.parseInt(chain[0]);
                int v2 = Integer.parseInt(chain[1]);
                matrix[v1][v2] = true;
                matrix[v2][v1] = true;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            result.add(1);
            while(!queue.isEmpty()) {
                int v = queue.remove();
                for (int i = 1; i < matrix[v].length; i++) {
                    if (matrix[v][i] && !result.contains(i)) {
                        queue.add(i);
                        result.add(i);
                    }
                }
            }
            writer.write(String.valueOf(result.size()));
            writer.write('\n');
            Collections.sort(result);
            for (Integer v : result) {
                writer.write(String.valueOf(v));
                writer.write(" ");
            }
            reader.close();
            writer.close();
        }
}
