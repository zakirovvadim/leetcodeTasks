package validSudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        char [][] board = new char[][]
                {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, HashSet<Character>> rowSet = new HashMap<>();
        Map<Integer, HashSet<Character>> columnSet = new HashMap<>();
        Map<Integer, HashSet<Character>> box = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int rowIndex = j / 3;
                int columnIndex = i / 3;
                if (rowIndex == columnIndex && box.containsKey(board[i][j])) {
                    return false;
                }
                if (!rowSet.put(j, rowSet.get(j).add()[i][j]) || !columnSet.add(board[i][j]) || ){
                    return false;
                } else {
                    return true;
                }

            }
        }
    }
}
