package old;

import java.util.ArrayList;
import java.util.List;

public class Polyndrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        List<Integer> list = new ArrayList();
        StringBuilder builder = new StringBuilder();
        if (isNumeric(x)) {
            while (x > 0) {
                builder.insert(0, x % 10);
                x = x / 10;
            }
        } else {
            builder.insert(0, x);
        }
        String to = builder.toString();
        String reverse = builder.reverse().toString();
        return to.equals(reverse);
    }

    private static boolean isNumeric(int x) {
        try {
            Integer.parseInt(String.valueOf(x));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
