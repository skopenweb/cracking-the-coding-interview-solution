//package misc;


// 10 20 35 40 45 | 30 25
// flip(lastLessIndex)
// 20 10 35 40 45 | 30 25
// flip(i)
// 45 40 35 10 20 | 30 25
// flip(i+1)
// 30 20 10 35 40 45
// flip(lastLessIndex + 1)
// 10 20 30 35 40 | 45


// 30 35 | 20 10 | 25
// 25 10 20 | 35 30
class Pancake {
    static void flip(int[] ar, int k) {
        if (k <= 0 || k > ar.length) return;
        int i = 0;
        int j = k - 1;
        while (i < j) {
            int temp = ar[i];
            ar[i] = ar[j];
            ar[j] = temp;
            i++;
            j--;
        }
    }

    static int[] pancakeSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j] > arr[i]) j--;
            if (j > 0) {
                flip(arr, j + 1);
                flip(arr, i + 1);
                flip(arr, i + 2);
                flip(arr, j + 2);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 5, 2, 3};
        pancakeSort(arr);
        for (int e : arr) {
            System.out.print(e+" ");
        }
        System.out.println();

    }

}