/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.prokom.sudoku;

import com.google.common.base.MoreObjects;

/**
 * Klasa SudokuField.
 */
public class SudokuField {

    private int value;

    public SudokuField() {
        value = 0;
    }

    public int getFieldValue() {
        int n = value;
        return n;
    }
    
    /**
     * Ustawianie wartosci wybranego pola.
     * @param value1 int
     */
    public void setFieldValue(int value1) {
        if (value1 < 0 || value1 > 9) {
            throw new IllegalArgumentException("Value must be a number between 1 and 9 or EMPTY");
        }
        value = value1;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(" ", value).toString();
    }
}
