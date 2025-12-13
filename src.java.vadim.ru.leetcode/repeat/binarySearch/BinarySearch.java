package repeat.binarySearch;

import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        long start = System.nanoTime();
        customBinarysEarch(6);
        long finish = System.nanoTime();
        System.out.println("custom " + (finish - start));

        long start2 = System.nanoTime();
        search(6);
        long finish2 = System.nanoTime();
        System.out.println("base - " + (finish2 - start2));
    }

    private static int customBinarysEarch(int search) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25);
        int l = 0;
        int r = list.size() - 1;
        int indexResult = -1;
        while (l <= r) {
            int midIndex = l + (r - l) / 2;
            Integer midValue = list.get(midIndex);
            if (midValue == search) {
                indexResult = midIndex;
                break;
            }
            if (midValue > search) {
                r = midIndex - 1;
            }
            if (midValue < search) {
                l = midIndex + 1;
            }
        }
        return indexResult;
    }

    private static int search(int search) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25);
        return list.indexOf(search);
    }
}
