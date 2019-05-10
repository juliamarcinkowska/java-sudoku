/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.prokom.sudoku;

import java.util.List;

/**
 * Klasa SudokuBox.
 */
public class SudokuBox extends SudokuFragment {

    /**
     * Konstruktor dla SudokuBox.
     *
     * @param frag SudokuField[]
     * @param board SudokuField[][]
     * @param r int
     * @param c int.
     */
    public SudokuBox(List<SudokuField> frag, SudokuField[][] board, int r, int c) {
        super(frag);
        int rbox = r - r % 3;
        int cbox = c - c % 3;
        int count = 0;
        for (int m = rbox; m < rbox + 3; m++) {
            for (int n = cbox; n < cbox + 3; n++) {
                frag.set(count, board[m][n]);
                count++;
            }
        }
    }
   
}
