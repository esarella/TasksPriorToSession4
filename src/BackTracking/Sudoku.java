package BackTracking;

import java.util.ArrayList;

public class Sudoku {
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        int[][] A = {
                {6, 0, 0, 0, 0, 7, 5, 0, 0},
                {8, 5, 9, 0, 0, 2, 0, 0, 0},
                {0, 0, 7, 0, 6, 3, 8, 0, 9},
                {0, 8, 0, 9, 0, 0, 4, 0, 7},
                {0, 0, 0, 3, 8, 4, 0, 0, 0},
                {4, 0, 3, 0, 0, 5, 0, 2, 0},
                {9, 0, 2, 1, 5, 0, 3, 0, 0},
                {0, 0, 0, 2, 0, 0, 6, 7, 5},
                {0, 0, 5, 7, 0, 0, 0, 0, 1}
        };

        sudoku.printBoard(A);
        sudoku.solveSudoku(A);
        System.out.println("------- Solution -------");
        sudoku.printBoard(A);
    }


    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        int rows = a.size();
        int cols = a.get(0).size();

        int[][] board = new int[rows][cols];

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(0).size(); j++) {
                char c = a.get(i).get(j).charValue();
                if (c == '.') board[i][j] = 0;
                else board[i][j] = c - '0';
            }
        }
        solveSudoku(board);

        a.clear();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            list.clear();
            for (int j = 0; j < board[0].length; j++) {
                list.add(Character.valueOf((char) (board[i][j] + '0')));
            }
            a.add(new ArrayList<Character>(list));

        }
    }

    public void solveSudoku(int[][] A) {
        solveSudoku(A, 0, 0);
    }

    private void solveSudoku(int[][] A, int row, int col) {
        if (row != A.length) {
            if (A[row][col] != 0) {
                if (col == A[0].length - 1) solveSudoku(A, row + 1, 0);
                else solveSudoku(A, row, col + 1);
            } else {

                for (int val = 1; val <= 9; val++) {

                    if (isValid(A, row, col, val)) {
                        A[row][col] = val;
                        int i = row;
                        int j = 0;
                        if (col == A[0].length - 1) {
                            i = row + 1;
                        } else j = col + 1;
                        solveSudoku(A, i, j);
                        if (isSolved(A)) break;
                        else {
                            A[row][col] = 0;
                        }

                    }
                }

            }
        }

    }

    private boolean isSolved(int[][] board) {
        int count[] = new int[9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) return false;
                count[board[i][j] - 1]++;
            }

        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 9 || count[i] < 9) return false;
        }
        return true;
    }

    private boolean isValid(int[][] A, int row, int col, int val) {

        // check row and col
        for (int i = 0; i < A[0].length; i++) {
            if (i != col && A[row][i] == val) return false;
            if (i != row && A[i][col] == val) return false;
        }

        /* ------------ check box ------------- */
        int rowStart = getStartOffset(row);
        int colStart = getStartOffset(col);

        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (i == row && j == col) continue;
                if (A[i][j] == val) return false;
            }
        }

        return true;

    }

    private int getStartOffset(int index) {
        if (index >= 0 && index < 3) return 0;
        if (index >= 3 && index < 6) return 3;
        if (index >= 6 && index < 9) return 6;
        return 0;
    }


    public boolean isEmpty(int[][] board, int row, int col) {
        return board[row][col] == 0;
    }

    public void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
