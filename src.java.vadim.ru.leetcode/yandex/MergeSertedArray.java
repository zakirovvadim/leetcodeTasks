package yandex;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSertedArray {
    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
        merge(new int[]{1}, 1, new int[]{}, 0);
        merge(new int[]{0}, 0, new int[]{1}, 1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m -1; // последний элемент в первом массиве до нулей
        int j = n - 1; // последний элемент второго массива
        int k = n + m - 1; // последний индекс первого массива

        while (i >=0 && j >= 0) { // итерируемся пока оба они не равны нулю, итерация с конца
            int i1 = nums1[i]; // достаем элемент 1 массива
            int i2 = nums2[j]; // второго масисвууа
            // присваиваем в конеы - т е в k то значение, которое больше и дикрементируем последнее значение и тот индекс что присвоили
            if (i2 > i1) {
                nums1[k] = i2;
                k--;
                j--;
            } else {
                nums1[k] = i1;
                k--;
                i--;
            }
        }
        // если второй масисв оказался длинее, тогда его данные просто копируем в первый массив
        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
        System.out.println(Arrays.toString(nums1));
    }
}
