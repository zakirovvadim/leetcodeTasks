package newStart.leetcode75;
/*
Алгоритм переворота слов в строке:
1. Разбиваем строку на массив слов по пробелам (split)
2. Проходим по массиву с конца в начало
3. Добавляем только непустые слова
4. В конце удаляем лишний пробел

Пример:
Вход: "  hello world  "
1. После split: ["", "", "hello", "world", ""]
2. Проход с конца и проверка на пустоту
3. Результат: "world hello"

Сложность:
- Время: O(n), где n - длина строки
- Память: O(n) для хранения массива слов
*/
public class ReverseWordsString {
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }

    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String[] splittedWord = s.split(" ");
        for (int i = splittedWord.length - 1; i >= 0; i--) {
            String current = splittedWord[i];
            if (!current.isEmpty()) {
                result.append(current);
                result.append(' ');
            }
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
