/**
 * @program: AlgorithmProject.BubbleSort
 * @description: 冒泡排序
 * @author: Ruipeng
 * @create: 2020/6/9 20:54
 */
public class BubbleSort {
    public void sort(int[] arrays) {
        int length = arrays.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int temp = arrays[j + 1];
                    arrays[j + 1] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 3, 6, 7, 8, 1};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
