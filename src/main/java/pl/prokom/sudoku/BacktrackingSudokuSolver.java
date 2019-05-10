/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.prokom.sudoku;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
* Klasa rozwiazujaca sudoku.
*/
public class BacktrackingSudokuSolver implements SudokuSolver {

    private static final int EMPTY = 0;
    //SudokuBoard nboard = new SudokuBoard();
    //int[][] board = nboard.getBoard();

    //@Override
    /**
     * Klasa wypelniajaca sudoku.
     */
    public boolean solve(SudokuBoard sudboard) {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = Arrays.asList(array);
        Collections.shuffle(list);

        SudokuField[][] board = sudboard.getBoard();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col].getFieldValue() == EMPTY) {
                    for (int i = 0; i < list.size(); i++) {
                        if (isInRow(row, list.get(i), board) && isInCol(col, list.get(i), board)
                                && isInBox(row, col, list.get(i), board)) {
                            board[row][col].setFieldValue(list.get(i));
                            if (solve(sudboard)) {
                                return true;
                            } else {
                                board[row][col].setFieldValue(EMPTY);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isInRow(int row, Integer number, SudokuField[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i].getFieldValue() == number) {
                return false;
            }
        }
        return true;
    }

    private boolean isInCol(int col, Integer number, SudokuField[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col].getFieldValue() == number) {
                return false;
            }
        }
        return true;
    }

    private boolean isInBox(int row, int col, int number, SudokuField[][] board) {
        int rbox = row - row % 3;
        int cbox = col - col % 3;
        for (int i = rbox; i < rbox + 3; i++) {
            for (int j = cbox; j < cbox + 3; j++) {
                if (board[i][j].getFieldValue() == number) {
                    return false;
                }
            }
        }
        return true;
    }
}
