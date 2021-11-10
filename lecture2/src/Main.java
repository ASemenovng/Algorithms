import java.util.Arrays;

public class Main {
    // T(n) = O(n * log(n))
    public static void main(String[] args) {
        int[] b = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[]mas = new int[1000];
        for (int i = 0; i < 1000; ++i){
            mas[i] = (int)(Math.random() * 1000);
        }

        BinaryHeap heap_mas = new BinaryHeap(mas);
        for (int i = 0; i < mas.length; ++i){
            mas[i] = heap_mas.remove_min();
        }

        BinaryHeap.heapSort(b);

        System.out.println("Сортировка небольшого массива в обратном порядке без использования доп памяти при построении кучи");
        System.out.println(Arrays.toString(b) + "\n");
        System.out.println("Сортировка большого массива случайных значений с использованием доп памяти при построении кучи");
        System.out.println(Arrays.toString(mas) + "\n");

    }
}
