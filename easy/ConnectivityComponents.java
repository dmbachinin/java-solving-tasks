import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class ConnectivityComponents {
    // https://coderun.yandex.ru/problem/connectivity-components
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] size = reader.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);
        List<List<Integer>> matrix = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            matrix.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            String[] chain = reader.readLine().split(" ");
            int v1 = Integer.parseInt(chain[0]) - 1;
            int v2 = Integer.parseInt(chain[1]) - 1;
            matrix.get(v1).add(v2);
            matrix.get(v2).add(v1);
        }

        boolean[] visits = new boolean[N];
        List<String> components_List = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!visits[i]) {
                Queue<Integer> q = new LinkedList<>();
                List<Integer> curr_component = new ArrayList<>();
                q.add(i);
                visits[i]=true;
                while(!q.isEmpty()) {
                    int cur_v = q.remove();
                    curr_component.add(cur_v+1);
                    for (int j : matrix.get(cur_v)) {
                        if (!visits[j]) {
                            q.add(j);
                            visits[j]=true;
                        }
                    }
                }
                StringBuilder sb = new  StringBuilder();
                sb.append(curr_component.size()).append("\n");
                for (int num : curr_component) {
                    sb.append(num);
                    sb.append(' ');
                }
                sb.append('\n');
                components_List.add(sb.toString());
            }
        }
        writer.write(String.valueOf(components_List.size()));
        writer.write('\n');
        for (String component : components_List) {
            writer.write(component);
        }

        reader.close();
        writer.close();
    }
}
