package old.validPalindrome;
/*
Valid Palindrome (two pointers):
- Два указателя: left с начала, right с конца.
- Пока left < right:
  1) Сдвигаем left вправо, пропуская все не-алфавитно-цифровые символы (пробелы, знаки).
  2) Сдвигаем right влево, пропуская все не-алфавитно-цифровые символы.
     Важно: в обоих циклах проверяем left < right, чтобы не выйти за границы строки на кейсах вроде "!!!".
  3) Сравниваем символы в одном регистре (toLowerCase); если не равны — это не палиндром.
  4) После успешного сравнения сдвигаем оба указателя к центру.
- Если все сравнения прошли — строка палиндром по условию (игнорируя регистр и не-буквенно-цифровые символы).
Time: O(n), Space: O(1).
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome2("race a car"));
    }

    // старое и неэффективное
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

    public static boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));
            if (leftChar != rightChar) {
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }
}
