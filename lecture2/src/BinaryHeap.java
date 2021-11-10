import java.util.Arrays;

import static UsefullThings.UsefullThings.*;
// Данная реализация кучи тратит O(n) доп памяти
// Далее будет представлена реализация без доп. памяти
// В "плохой" реалтзации куча строится за O(n * log(n)), можно строить за n, будем реализовывать так
public class BinaryHeap {
    int n = 0;
    int[] array;

    public BinaryHeap(int ... array){
        this.array = new int[array.length];
        for (int i: array) {
            this.insert(i);
        }
    }

    public BinaryHeap() {
        this.n = 0;
        this.array = new int[n];
    }

    // T(n) = O(log(n))
    // просеивание вверх
    public  void insert(int x){
        array[n++] = x;
        int i = n - 1;
        sift_up(array, i);
    }

    // T(n) = O(log(n))
    // просеивание вниз
    public int remove_min(){
        int res = array[0];
        array[0] = swap(array[--n], array[n] = array[0]);
        int i = 0;
        sift_down(array, i);
        return res;
    }

    @Override
    public String toString() {
        return "BinaryHeap{" +
                "n=" + n +
                ", array=" + Arrays.toString(array) +
                '}';
    }
    private static void sift_up(int[] array, int i){
        while(i > 0 && array[i] < array[(i - 1) / 2]){
            array[(i - 1) / 2] = swap(array[i], array[i] = array[(i - 1) / 2]);
            i = (i - 1) / 2;
        }
    }

    private static void sift_down(int[] array, int i){
        int y = 0;
        while (true){
            int n = array.length;
            int j = i;
            if(2*i + 1 < n && array[2*i + 1] < array[j]){j = 2*i + 1;}
            if(2*i + 2 < n && array[2*i + 2] < array[j]){j = 2*i + 2;}
            if(j == i){break;}
            array[i] = swap(array[j], array[j] = array[i]);
            i = j;
        }
    }


    public static void heapSort(int[] array){
        for(int i = 0; i < array.length; ++i){
            sift_up(array, i);
        }

        int n = array.length - 2;
        for(int i = array.length - 1; i > 0; --i){
            array[0] = swap(array[i], array[i] = array[0]);
            int k = 0;
            while (true){
                int j = k;
                if(2*k + 1 < n && array[2*k + 1] < array[j]){j = 2*k + 1;}
                if(2*k + 2 < n && array[2*k + 2] < array[j]){j = 2*k + 2;}
                if(j == k){break;}
                array[j] = swap(array[k], array[k] = array[j]);
                k = j;
            }
            --n;
        }
    }
}