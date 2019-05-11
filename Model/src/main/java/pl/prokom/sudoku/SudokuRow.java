/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.prokom.sudoku;

import java.util.List;

/**
 * Klasa SudokuRow.
 */
public class SudokuRow extends SudokuFragment {

    /**
     * Konstruktor dla SudokuRow.
     *
     * @param board SudokuField[][]
     * @param r int.
     */
    public SudokuRow(List<List<SudokuField>> board, int r) {
        for (int i = 0; i < 9; i++) {
            fragment.set(i, board.get(r).get(i));
        }
    }

    /**
     * Konstruktor dla SudokuRow.
     *
     */
    public SudokuRow() {
        for (int i = 0; i < 9; i++) {
            fragment.set(i, new SudokuField());
        }
    }

}
