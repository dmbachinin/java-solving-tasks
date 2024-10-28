import static java.lang.Math.abs;

public class FindAnyRepeatingNumber {

    // Дано: массив из N+1 целых чисел, который содержит элементы в диапазоне [1, N].
    // Найти: любое повторяющееся число.

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2, 3, 4, 5, 6};
        System.out.println(findRepeatNumber2(a));
        System.out.println(findRepeatNumber1(a));
//        System.out.println(findRepeatNumber3(a));
    }
    // Решение через использование массива как словаря
    public static int findRepeatNumber1(int[] a) {
        for (int i : a){
            int i_abs = abs(i);
            if (a[i_abs] < 0) {
                return i_abs;
            }
            a[i_abs] *= -1;
        }
        return -1;
    }

    // Решение если повторяется только одно число и массив неизменяем
    public static int findRepeatNumber2(int[] a) {
        int number_sum = 0;
        int index_sum = 0;
        for (int i = 0; i < a.length; i++){
            number_sum += a[i];
            index_sum += i;
        }
        return abs((index_sum - number_sum));
    }


}
