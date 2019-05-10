/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.prokom.sudoku;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;

/**
 * Klasa abstrakcyjna SudokuFragment.
 */
public abstract class SudokuFragment {

    private List<SudokuField> fragment = Arrays.asList(new SudokuField[9]);

    public SudokuFragment(List<SudokuField> frag) {
        fragment = frag;
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
    public int hashCode() {
        return Objects.hashCode(this.fragment);
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
        final SudokuFragment other = (SudokuFragment) obj;
        
        return Objects.equal(this.fragment, other.fragment);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("Fragment", fragment).toString();
    } 
   
}
