package newStart.leetcode75;

import java.util.ArrayDeque;

/*
345


 */
public class ReverseVowels {

    class Solution {
        public String reverseVowels(String s) {
            if (s.length() == 1) return s;
            var queue = new ArrayDeque<Integer>();
            for (int i = 0; i < s.length(); i++) {
                var symbol = s.charAt(i);
                if (isVowel(symbol)) queue.push(i);
            }
            StringBuilder newStr = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                var symbol = s.charAt(i);
                if (isVowel(symbol)) {
                    var index = queue.pop();
                    newStr.append(s.charAt(index));
                } else {
                    newStr.append(symbol);
                }
            }
            return newStr.toString();
        }

        private boolean isVowel(char s) {
            s = Character.toLowerCase(s);
            return s == 'a' || s == 'e' || s == 'o' || s == 'u' || s == 'i';
        }

        // решение за один проход и без доп памяти - Двойной указатель
        //Этот метод использует два указателя — один начинает с начала строки, другой — с конца.
        // Они "встречно" ищут гласные и меняют их местами.
        public String reverseVowels2(String s) {
            if (s == null || s.length() < 2) return s;

            char[] chars = s.toCharArray(); // Преобразуем строку в массив символов

            int left = 0, right = s.length() - 1;
            while (left < right) {
                // Ищем ближайший гласный слева
                while (left < right && !isVowel(chars[left])) {
                    left++;
                }
                // Ищем ближайший гласный справа
                while (left < right && !isVowel(chars[right])) {
                    right--;
                }
                // Меняем местами найденные гласные
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }

            return new String(chars); // Создаём строку на основе массива
        }
    }

}
