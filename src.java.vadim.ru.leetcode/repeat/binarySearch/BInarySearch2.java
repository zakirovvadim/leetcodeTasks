package repeat.binarySearch;

import java.util.List;

public class BInarySearch2 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19);
        int i = binarySearch(integers, 6);
        System.out.println(i);
    }

    private static int binarySearch(List<Integer> integers, int target) {
        int l = 0;
        int r = integers.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int val = integers.get(mid);
            if (val == target) {
                return mid;
            }
            if (val < target) {
                l = mid + 1;

            }
            if (val > target) {
                r = mid - 1;
            }
        }
        return -1;
    }
 }
