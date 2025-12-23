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
        System.out.println(isAnagram2(s1, s2));
    }
    public static boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        char[] t1 = t.toCharArray();
        Arrays.sort(t1);
        return String.valueOf(t1).equals(String.valueOf(s1));
    }

    // оптимальнее если только будут строчные латинские буквы
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] cnt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
            cnt[t.charAt(i) - 'a']--;
        }

        for (int x : cnt) {
            if (x != 0) return false;
        }
        return true;
    }
}
