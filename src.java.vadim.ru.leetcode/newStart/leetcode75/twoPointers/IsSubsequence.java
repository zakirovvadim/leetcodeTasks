package newStart.leetcode75.twoPointers;

/*
Решение без дополнительного задания:
Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */
public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        int sPoint = 0, tPoint = 0; // создаем два указателя
        if (s.isEmpty()) return true;
        while (tPoint < t.length()) { // двигаемся по второйц строке, где нам требуется найти последовательность
            if (s.charAt(sPoint) == t.charAt(tPoint)) { // если символы равны, тогда двигаем левый указатель, чтобы найти след символ последовательности
                sPoint++;
            }
            if (sPoint == s.length()) { // если левая строка закончилась, значит последовательность найдена полностью
                return true;
            }
            tPoint++; //независимо от левого указателя двигаем указатель стриоки Т - где нам надло найти последовательность
        }
        return false; // еслит ничего не найден, выйдем из цикла
    }
}
