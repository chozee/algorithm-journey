package mine;

/**
 * insertion/bubble/selection
 */
public class SimpleSort {
    public void insertion(int[] arr) {
        // todo empty and only 1

        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {// 最后一个不用管了已经有序了
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }
    }

    public void bubble(int[] arr) {
        // empty / null / only 1

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length - i; j++) {
                if (arr[i] < arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
