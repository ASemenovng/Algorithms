import java.util.Arrays;

public class MergeSorting {
    public static void main(String[] args) {
        int a[] = {1, 3, 2, 0, 6, 4};
        a = mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static int[] merge(int[] a, int[] b){
        int n = a.length;
        int m = b.length;
        int[] c = new int[n + m];
        int i, j, k;
        i = j = k = 0;
        while (i < n || j < m){
            if(j == m || (i < n && a[i] < b [j]))
                c[k++] = a[i++];
            else
                c[k++] = b[j++];
        }
        return c;
    }

    public static int[] mergeSort(int[] a){
        int n = a.length;
        if (n <= 1)
            return a;
        else {
            if(n % 2 == 0){
                int[] al = new int[n / 2];
                int[] ar = new int[n / 2];
                for (int i = 0; i < n/2; i++) {
                    al[i] = a[i];
                }
                for (int i = 0; i < n/2; i++) {
                    ar[i] = a[n/2 + i];
                }
                al = mergeSort(al);
                ar = mergeSort(ar);
                return merge(al, ar);
            }
            else {
                int[] al = new int[n / 2];
                int[] ar = new int[n / 2 + 1];
                for (int i = 0; i < n/2; i++) {
                    al[i] = a[i];
                }
                for (int i = 0; i < n/2 + 1; i++) {
                    ar[i] = a[n/2 + i];
                }
                al = mergeSort(al);
                ar = mergeSort(ar);
                return merge(al, ar);
            }
        }
    }
}
