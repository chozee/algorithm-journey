package exercise.serch;

import java.util.Arrays;

public class BinarySearch extends AbstractSearch {

    // 为了验证
    public static void main(String[] args) {
        int N = 100;
        int V = 1000;
        int testTime = 500000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int n = (int) (Math.random() * N);
            int[] arr = randomArray(n, V);
            Arrays.sort(arr);
            int num = (int) (Math.random() * V);
//            validateLargeThan(arr, num);

            validateLessThan(arr, num);
        }
        System.out.println("测试结束");
    }

    private static void validateLessThan(int[] arr, int num) {
        if (validatorFindRight(arr, num) != new BinarySearch().searchLessThan(arr, num)) {
            System.out.println("error !");
        }
    }

    private static void validateLargeThan(int[] arr, int num) {
        if (right(arr, num) != new BinarySearch().searchLargeThan(arr, num)) {
            System.out.println("出错了!");
        }
    }

    @Override
    public int search(int[] arr, int start, int end, int target) {
        if (checkEmpty(arr)) return -1;

        int midIndex = midIndex(start, end);
        if (target == arr[midIndex]) {
            return midIndex;
        } else if (target < arr[midIndex]) {
            return search(arr, start, midIndex - 1, target);
        } else {
            return search(arr, midIndex, end, target);
        }
    }

    @Override
    public int search(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = midIndex(start, end);
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    /**
     * 大于等于target的最左位置（找小于等于target的最左位置没意义，因为从0开始就可以了）
     * >= target 往左找
     * @param arr    有序
     * @param target
     * @return
     */
    @Override
    public int searchLargeThan(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = midIndex(start, end);
            if (arr[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    /**
     * <=target的最右位置
     * <= 向右找
     * @param arr    有序数组
     * @param target 目标数字
     * @return 索引
     */
    @Override
    public int searchLessThan(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = midIndex(start, end);
            if (arr[mid] <= target) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    // 保证arr有序，才能用这个方法
    // 有序数组中找<=num的最右位置
    public static int validatorFindRight(int[] arr, int num) {
        int l = 0, r = arr.length - 1, m = 0;
        int ans = -1;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (arr[m] <= num) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    private int midIndex(int start, int end) {
        // 防溢出、性能高
        return start + ((end - start) >> 1);
    }
}
