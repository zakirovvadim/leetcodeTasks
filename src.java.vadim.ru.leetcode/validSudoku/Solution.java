package validSudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        char[][] board = new char[][]
                         {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }

        public static boolean isValidSudoku ( char[][] board){
            Set<Character> row = new HashSet<>();
            Map<String, HashSet<Character>> squad = Map.of(
                    "00", new HashSet<>(),
                    "01", new HashSet<>(),
                    "02", new HashSet<>(),
                    "10", new HashSet<>(),
                    "11", new HashSet<>(),
                    "12", new HashSet<>(),
                    "20", new HashSet<>(),
                    "21", new HashSet<>(),
                    "22", new HashSet<>()
            );
            Map<Integer, HashSet<Character>> columnMap = Map.of(
                    0, new HashSet<Character>(),
                    1, new HashSet<Character>(),
                    2, new HashSet<Character>(),
                    3, new HashSet<Character>(),
                    4, new HashSet<Character>(),
                    5, new HashSet<Character>(),
                    6, new HashSet<Character>(),
                    7, new HashSet<Character>(),
                    8, new HashSet<Character>());
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (Character.isDigit(board[i][j])) {
                        boolean existedRow = row.add(board[i][j]);
                        if (!existedRow) return false;
                        boolean addedColumn = columnMap.get(j).add(board[i][j]);
                        if (!addedColumn) return false;
                        int col = i / 3;
                        int r = j / 3;
                        String box = col + "" + r;
                        boolean validBox = squad.get(box).add(board[i][j]);
                        if (!validBox) return false;
                    }
                }
                row.clear();
            }
            return true;
        }
    }
