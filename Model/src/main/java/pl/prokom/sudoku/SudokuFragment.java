/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.prokom.sudoku;

import com.google.common.base.MoreObjects;
import java.util.Arrays;
import java.util.List;

/**
 * Klasa abstrakcyjna SudokuFragment.
 */
public abstract class SudokuFragment {

    protected List<SudokuField> fragment;

    public SudokuFragment() {
        
        fragment = Arrays.asList(new SudokuField[9]);
    }

    /**
     * Funkcja verify.
     *
     * @return boolean
     */
    public boolean verify() {
        boolean flag = true;
        for (int i = 0; i < fragment.size(); i++) {
            for (int j = i + 1; j < fragment.size(); j++) {
                if (i != j && fragment.get(i).getFieldValue() == fragment.get(j).getFieldValue()) {
                    flag = false;
                }
            }
        }
        return flag;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add(" ", fragment).toString();
    }
   
}
