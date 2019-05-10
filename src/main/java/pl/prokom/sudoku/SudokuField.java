/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.prokom.sudoku;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Klasa SudokuField.
 */
public class SudokuField {

    private int value;

    public int getFieldValue() {
        int n = value;
        return n;
    }

    public void setFieldValue(int value1) {
        value = value1;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SudokuField other = (SudokuField) obj;

        return Objects.equal(this.value, other.value);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("Value", value).toString();
    }
}
