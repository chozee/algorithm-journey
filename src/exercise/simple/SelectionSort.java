package exercise.simple;

public class SelectionSort implements Sort {
    @Override
    public void sort(int[] arr) {
        if (checkEmpty(arr)) return;

        for (int minIndex, i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
}
