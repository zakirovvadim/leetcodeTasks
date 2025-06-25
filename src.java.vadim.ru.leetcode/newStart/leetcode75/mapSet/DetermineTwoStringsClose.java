package newStart.leetcode75.mapSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetermineTwoStringsClose {

    public static void main(String[] args) {
        long s = System.nanoTime();
        System.out.println(closeStrings2("abc", "bca"));
        System.out.println(closeStrings2("a", "aa"));
        System.out.println(closeStrings2("cabbba", "abbccc"));
        long f = System.nanoTime();
        System.out.println(f - s);
    }

    /*
    Мой вариант, менее оптимлаьынй
    создаем мапы две, для каждой строки и считаем количество вхождений, где ключ символ,а значение - вхождение
    Далее проверяем если символы иквалс (ключи обеих мап), если нет, уже можно возвращать фолс
    Далее нужно проверить множества, одинаковые или нет, для этого значения обеих мап сортируем и помещаем в коллекцию, и сравниваем.
     */
    public static boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            map.put(word1.charAt(i), map.getOrDefault(word1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < word2.length(); i++) {
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
        }

        if (!map.keySet().equals(map2.keySet())) {
            return false;
        }
        List<Integer> list = map.values().stream().sorted().toList();
        List<Integer> list2 = map2.values().stream().sorted().toList();
        return list.equals(list2);
    }

    /*
    Супер оптимальное решение
     */
        public static boolean closeStrings2(String s1, String s2) {
            if (s1.length() != s2.length()) return false;
            int[] f1 = new int[26];
            int[] f2 = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                int i1 = s1.charAt(i) - 'a';
                f1[i1]++;
            }
            for (int i = 0; i < s2.length(); i++) {
                f2[s2.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if ((f1[i] == 0 && f2[i] != 0) || (f1[i] != 0 && f2[i] == 0)) {
                    return false;
                }
            }
            Arrays.sort(f2);
            Arrays.sort(f1);
            for (int i = 0; i < 26; i++) {
                if (f1[i] != f2[i]) {
                    return false;
                }
            }
            return true;
        }

}
