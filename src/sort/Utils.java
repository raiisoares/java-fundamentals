package sort;

public class Utils {

    public static Integer[] quicksort(Integer[] arr, int start, int end) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        if (start < end) {
            int pivot = partition(arr, start, end);
            quicksort(arr, start, pivot - 1);
            quicksort(arr, pivot + 1, end);
        }

        return arr;
    }

    private static int partition(Integer[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;
        return i + 1;
    }
}
