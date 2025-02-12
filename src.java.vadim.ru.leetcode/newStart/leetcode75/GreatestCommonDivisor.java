package newStart.leetcode75;
/*
В общем нужно не итерироваться,а исполдьзовать алгоритм Евклида
 */
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        String str1 = "ABCDABCD";
        String str2 = "ABCD";
        Solution2 solution2 = new Solution2();
        solution2.gcdOfStrings(str1, str2);
    }
    // мой вариант
    public String gcdOfStrings(String str1, String str2) {
        String min = "";
        if (str1.length() >= str2.length()) {
            min = str2;
        } else min = str1;
        int start = 1;
        if (min.length() == 1) start = 0;
        StringBuilder builder = new StringBuilder();
        Character delimeter = min.charAt(0);
        builder.append(delimeter);
        for (int i = start; i < min.length(); i++) {
            if (!delimeter.equals(str1.charAt(i)) && str1.charAt(i) == (str2.charAt(i))) {
                builder.append(str1.charAt(i));
            } else {
                break;
            }
        }
        return builder.toString();
    }

    static class Solution2 {
        /*
        ### Шаг 1: Проверка совместимости строк
            Чтобы одна строка могла быть делителем другой, необходимо выполнить простую проверку: мы должны убедиться, что сложение
            строк в обоих порядках создаёт одинаковую строку. Это означает, что строки должны быть последовательными повторениями одной и той же подстроки.
         */
        public String gcdOfStrings(String str1, String str2) {
            if (!(str1 + str2).equals(str2 + str1)) {
                return "";
            }
            int gcdLength = gcd(str1.length(), str2.length());
            return str1.substring(0, gcdLength);

        }

        /*
        ### Шаг 2: Вычисление НОД длины строк
        Если строки совместимы, их общий делитель должен находиться в рамках наибольшего общего делителя длин строк.

        - Если строка `x` делит обе строки, то длина `x` должна быть делителем длин обеих строк. Например:
        - Если `str1` имеет длину 6, и `str2` имеет длину 3, длина `x` должна быть НОД(6, 3) = 3.

        Для вычисления НОД (наибольшего общего делителя) используется классический алгоритм **Евклида**:
        В самом простом случае алгоритм Евклида применяется к паре положительных целых чисел и формирует новую пару, которая состоит из меньшего числа и остатка от деления большего числа на меньшее.
        - `gcd(6, 3)`:
            - 6 делится на 3 без остатка → НОД = 3.

        - `gcd(18, 24)`:
            - 24 % 18 = 6
            - 18 % 6 = 0 → НОД = 6.

        Этот НОД говорит нам, на сколько символов должна состоять самая длинная подстрока-делитель.
         */
        private int gcd(int l1, int l2) {
            return l2 == 0 ? l1 : gcd(l2, l1 % l2);
        }
    }
}
