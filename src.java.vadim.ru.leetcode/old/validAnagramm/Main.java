package old.validAnagramm;

import java.util.Arrays;

/**
 * Просто достаем из строк массива чар и сортируем, потом снова конвертируем в стрингу и сравниваем между собой.
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "nagaram";
        System.out.println(isAnagram(s1, s2));
    }
    public static boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        char[] t1 = t.toCharArray();
        Arrays.sort(t1);
        return String.valueOf(t1).equals(String.valueOf(s1));
    }
}
