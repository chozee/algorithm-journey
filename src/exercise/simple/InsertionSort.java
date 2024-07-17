package exercise.simple;

public class InsertionSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (checkEmpty(arr)) return;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }
}
