package exercise.serch;

public abstract class AbstractSearch{

    public boolean checkEmpty(int[] arr) {
        return arr == null || arr.length == 0;
    }


    // 为了验证
    // 保证arr有序，才能用这个方法
    public static int right(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                return i;
            }
        }
        return -1;
    }
    // 为了验证
    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * v) + 1;
        }
        return arr;
    }
    public abstract int search(int[] arr, int start, int end, int target);

    public abstract int search(int[] arr, int target);

    public abstract int searchLargeThan(int[] arr, int target);

    public abstract int searchLessThan(int[] arr, int target);
}
