import java.io.*;
import java.util.Arrays;

public class TheMiddleElement {
    /*
    * https://coderun.yandex.ru/problem/median-out-of-three
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("in.txt"));
        BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"));

        String[] numsString = in.readLine().split(" ");
        int[] nums = new int[numsString.length];
        for (int i = 0; i < numsString.length; i ++) {
            nums[i] = Integer.parseInt(numsString[i]);
        }
        Arrays.sort(nums);
        out.write(String.valueOf(nums[nums.length / 2]));

        in.close();
        out.close();
    }
}
