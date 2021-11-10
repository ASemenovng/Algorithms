import java.util.Arrays;

public class SortingByInserts {
    public static void main(String[] args) {
        int[] mas = {1, 8, 4, 2, 0};
        sortingByInserts(mas);
        System.out.println(Arrays.toString(mas));
    }

    static <T> T swap(T a, T b){
        return a;
    }

    static void sortingByInserts(int[] args){
        for (int i = 0; i < args.length; ++i){
            int j = i;
            while (j > 0 && args[j] < args[j - 1]){
                args[j] = swap(args[j - 1], args[j - 1] = args[j]);
                --j;
            }
        }
    }
}
