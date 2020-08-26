package ArrayList;

import java.util.Arrays;

public class Quick_Sort {
    //快排
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];
        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }


    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort6(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort2(int nums[], int left, int right) {
        int i = left;
        int j = right;
        if (left > right) {
            return;
        }
        int temp = nums[left];
        while (i < j) {
            while (nums[j] >= temp && i < j) {
                j--;
            }
            while (nums[i] <= temp && i < j) {
                i++;
            }
            if (i < j) {
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }
        }
        nums[left] = nums[i];
        nums[i] = temp;
        quickSort2(nums, left, j - 1);
        quickSort2(nums, j + 1, right);
    }

    public static void quickSort3(int arr[], int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int temp = arr[left];
        while (i < j) {
            while (arr[j] >= temp && i < j) {
                j--;
            }
            while (arr[i] <= temp && i < j) {
                i++;
            }
            if (i < j) {
                int t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        quickSort3(arr, left, j - 1);
        quickSort3(arr, j + 1, right);
    }

    public static void quickSort4(int arr[], int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int temp = arr[left];
        while (i < j) {
            while (arr[j] >= temp && i < j) {
                j--;
            }
            while (arr[i] <= temp && i < j) {
                i++;
            }
            if (i < j) {
                int t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        quickSort4(arr, left, j - 1);
        quickSort4(arr, j + 1, right);
    }

    public static void quickSort5(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int temp = arr[left];
        while (i < j) {
            while (arr[j] >= temp && i < j) {
                j--;
            }
            while (arr[i] <= temp && i < j) {
                i++;
            }
            if (i < j) {
                int t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        quickSort5(arr, left, j - 1);
        quickSort5(arr, j + 1, right);
    }

    public static void quickSort6(int arr[], int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int temp = arr[left];
        while (i < j) {
            while (arr[j] >= temp && i < j) {
                j--;
            }
            while (arr[i] <= temp && i < j) {
                i++;
            }
            if (i < j) {
                int t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        quickSort6(arr, left, i - 1);
        quickSort6(arr, i + 1, right);
    }
}
