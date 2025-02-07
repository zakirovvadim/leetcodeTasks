package old.validPalindrome;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder asc = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) && Character.isLetter(s.charAt(i))) {
                asc.append(s.charAt(i));
            }
        }
        String re = asc.toString();
        return re.equalsIgnoreCase(asc.reverse().toString());
    }
}
