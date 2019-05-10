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
     * @param frag SudokuField[]
     * @param board SudokuField[][]
     * @param r int.
     */
    public SudokuRow(List<SudokuField> frag, SudokuField[][] board, int r) {
        super(frag);
        for (int i = 0; i < 9; i++) {
            frag.set(i, board[r][i]);
        }
    }
    
}
