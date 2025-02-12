package newStart.leetcode75;
/*
1768
 */
public class MergeStringsAlternately {

    class Solution {
        public String mergeAlternately(String word1, String word2) {
            StringBuilder builder = new StringBuilder();
            if (word1 == null || word1.isEmpty()) return word2;
            if (word2 == null || word2.isEmpty()) return word1;
            if (word1.length() > word2.length()) {
                for (int i = 0; i < word2.length(); i++) {
                    if (i == word2.length() - 1) {
                        builder.append(word1.charAt(i));
                        builder.append(word2.charAt(i));
                        builder.append(word1.substring(i + 1));
                    } else {
                        setChar(word1, word2, i, builder);
                    }
                }
            } else if (word1.length() < word2.length()) {
                for (int i = 0; i < word1.length(); i++) {
                    if (i == word1.length() - 1) {
                        builder.append(word1.charAt(i));
                        builder.append(word2.substring(i));
                    } else {
                        setChar(word1, word2, i, builder);
                    }
                }
            } else {
                for (int i = 0; i < word1.length(); i++) {
                    setChar(word1, word2, i, builder);
                }
            }
            return builder.toString();
        }

        private static void setChar(String word1, String word2, int i, StringBuilder builder) {
            builder.append(word1.charAt(i));
            builder.append(word2.charAt(i));
        }
    }
}
