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

        List<List<SudokuField>> board = sudboard.getBoard();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board.get(row).get(col).getFieldValue() == EMPTY) {
                    for (int i = 0; i < list.size(); i++) {
                        if (isInRow(row, list.get(i), board) && isInCol(col, list.get(i), board)
                                && isInBox(row, col, list.get(i), board)) {
                            board.get(row).get(col).setFieldValue(list.get(i));
                            if (solve(sudboard)) {
                                return true;
                            } else {
                                board.get(row).get(col).setFieldValue(EMPTY);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isInRow(int row, Integer number, List<List<SudokuField>> board) {
        for (int i = 0; i < 9; i++) {
            if (board.get(row).get(i).getFieldValue() == number) {
                return false;
            }
        }
        return true;
    }

    private boolean isInCol(int col, Integer number, List<List<SudokuField>> board) {
        for (int i = 0; i < 9; i++) {
            if (board.get(i).get(col).getFieldValue() == number) {
                return false;
            }
        }
        return true;
    }

    private boolean isInBox(int row, int col, int number, List<List<SudokuField>> board) {
        int rbox = row - row % 3;
        int cbox = col - col % 3;
        for (int i = rbox; i < rbox + 3; i++) {
            for (int j = cbox; j < cbox + 3; j++) {
                if (board.get(i).get(j).getFieldValue() == number) {
                    return false;
                }
            }
        }
        return true;
    }
}
