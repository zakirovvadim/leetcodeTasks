package newStart.leetcode75.slidingWindow;

import java.util.Set;
/*
Алгоритм:
создаем две переменные максимальное количество гласных и текущий подсчет гласных для цикла.
создаем первую итерацию для заполнения окна и подсчета гласных.
во втором цикле проверяем является ли гласная в уходящем окне это первый индекс окна т.е. текущий индекс минус k -> уменьшеаем текущий счетчик
далее проверяем является ли гласная в приходящем окне, т.е. текущий индекс, если да счтетчик увеличиваем
потом сравниваем с максимумом.
 */
public class MaximumNumberVowelsSubstringGivenLength {
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
        System.out.println(maxVowels("aeiou", 2));
        System.out.println(maxVowels("leetcode", 3));
    }

    public static int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of( 'a', 'e', 'i', 'o', 'u');
        int maxVowel = 0;
        int current = 0;

        for (int i =0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                current++;
            }
        }
        maxVowel = current;
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i - k))) {
                current--;
            }
            if (vowels.contains(s.charAt(i))) {
                current++;
            }
            maxVowel = Math.max(maxVowel, current);
        }
        return maxVowel;
    }
}
