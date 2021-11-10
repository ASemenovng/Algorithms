import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

/**
 * Алгоритм быстрой сортровки Хоара
 * <code>pivot<code/> выбирается рандомно
 * T(n) = O(n * log(n))
 * В худшем случае T(n) = O(n * n);
 * @author andreisemenov
 * @version
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {0,3,5,1,-9,22,6};
        sort(array, 0, array.length);
        System.out.println(Arrays.toString(array));

        /*int[] mas = new int[90000];
        Random random = new Random();
        for(int i = 0; i < 90000; ++i){
            mas[i] = random.nextInt();
        }
        Instant start = Instant.now();
        sort(mas, 0, mas.length);
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        System.out.println("Прошло времени, мс: " + elapsed);

         */


        //int[] b = {0, 2, 1, 1};
        //sort_v2(b, 0, b.length);
        //System.out.println(Arrays.toString(b));

    }

    public  static void sort(int[] a, int l ,int r){
        if(r - l == 1){
            return;
        }
        if(l == r){
            return;
        }
        int m = partition(a, l, r);
        sort(a, l, m);
        sort(a, m, r);
    }

    public  static void sort_v2(int[] a, int l ,int r){
        if(r - l == 1){
            return;
        }
        if(l == r){
            return;
        }
        int m = partition_v2(a, l, r)[0];
        int k = partition_v2(a, l, r)[1];
        sort(a, l, m);
        sort(a, k, r);
    }

    /**
     * Рандомно выбирается <code>pivot</code>
     * данный метод не работает в случае с одинаковыми элементами в массиве
     * @param a
     * @param l
     * @param r
     * @return
     */
    public static int partition(int[] a, int l, int r){
        Random random = new Random();
        int x = random.nextInt(r - l) + l;
        int pivot = a[x];
        int m = l;
        for (int i = l; i < r; ++i){
            if(a[i] < pivot){
                a[i] = swap(a[m], a[m] = a[i]);
                ++m;
            }
        }
        return m;
    }

    public static int[] partition_v2(int[] a, int l, int r){
        Random random = new Random();
        int x = random.nextInt(r - l) + l;
        int pivot = a[x];
        int m = l;
        int k = l;
        for (int i = l; i < r; ++i){
            if(a[i] < pivot){
                a[i] = swap(a[m], a[m] = a[i]);
                ++m;
                ++k;
            }

            if(a[i] == pivot){
                a[i] = swap(a[k], a[k] = a[i]);
                ++k;
            }
        }
        int[] pair = {m, k};
        return pair;
    }


    public static <T> T swap(T a, T b){
        return a;
    }
}
