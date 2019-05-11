/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.prokom.sudoku;

import java.util.List;

/**
 * Klasa SudokuColumn.
 */
public class SudokuColumn extends SudokuFragment {

    /**
     * Konstruktor dla SudokuColumn.
     *
     * @param board SudokuField[][]
     * @param c int.
     */
    public SudokuColumn(List<List<SudokuField>> board, int c) {
        for (int i = 0; i < 9; i++) {
            fragment.set(i, board.get(i).get(c));
        }
    }

    /**
     * Konstruktor dla SudokuColumn.
     */
    public SudokuColumn() {
        for (int i = 0; i < 9; i++) {
            fragment.set(i, new SudokuField());
        }
    }    
}
