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
     * @param frag SudokuField[]
     * @param board SudokuField[][]
     * @param c int.
     */
    public SudokuColumn(List<SudokuField> frag, SudokuField[][] board, int c) {
        super(frag);
        for (int i = 0; i < 9; i++) {
            frag.set(i, board[i][c]);
        }
    }
    
}
