package old.findTheIndex;

public class FindTheIndex {
    public static void main(String[] args) {
        int i = strStr("leetcode", "leeto");
        System.out.println(i);
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        char[] bytesNeedle = needle.toCharArray();
        int lengthNeedle = needle.toCharArray().length;
        char[] bytesHaysTack = haystack.toCharArray();
        int lastLand = (haystack.length()) - bytesNeedle.length;
        for (int i = 0; i < bytesHaysTack.length; i++) {
            int j = i;
            if (lengthNeedle > bytesHaysTack.length - i) {
                return -1;
            }
            StringBuilder b = new StringBuilder();
            for (int k = 0; k < lengthNeedle; k++) {
                b.append(bytesHaysTack[i]);
                i++;
            }
            i = j;
            if (b.toString().equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
