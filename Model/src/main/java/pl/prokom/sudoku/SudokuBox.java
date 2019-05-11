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
     * @param board List< List < SudokuField > >
     * @param r int
     * @param c int.
     */
    public SudokuBox(List<List<SudokuField>> board, int r, int c) {
        int rbox = r - r % 3;
        int cbox = c - c % 3;
        int count = 0;
        for (int m = rbox; m < rbox + 3; m++) {
            for (int n = cbox; n < cbox + 3; n++) {
                fragment.set(count, board.get(m).get(n));
                count++;
            }
        }
    }

    /**
     * Konstruktor dla SudokuBox.
     */
    public SudokuBox() {
        for (int i = 0; i < 9; i++) {
            fragment.set(i, new SudokuField());
        }
    }

}
