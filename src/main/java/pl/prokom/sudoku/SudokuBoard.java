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
 * Klasa sudokuBoard.
 */
public class SudokuBoard {

    private SudokuField[][] board;

    public SudokuBoard(SudokuField[][] sudokuboard) {
        board = sudokuboard;
    }

    /**
     * Funkcja inicjujaca dobra wielkosc tablicy sudoku.
     *
     * @param n int.
     */
    public void setArray(int n) {
        this.board = new SudokuField[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new SudokuField();
                board[i][j].setFieldValue(0);
            }
        }
    }

    public SudokuField[][] getBoard() {
        SudokuField[][] copy = board;
        return copy;
    }

    public int getNumber(int x, int y) {
        return board[x][y].getFieldValue();
    }

    public void setNumber(int x, int y, int value) {
        board[x][y].setFieldValue(value);
    }
    
    /**
     * Funkcja zwracajaca rzad z tablicy.
     *
     * @param x int
     * @return SudokuRow
     */
    public SudokuRow getRow(int x) {
        List<SudokuField> fragment = Arrays.asList(new SudokuField[9]);
        SudokuRow row = new SudokuRow(fragment, this.getBoard(), x);
        return row;
    }
    
    /**
     * Funkcja zwracajaca kolumne z tablicy.
     *
     * @param y int
     * @return SudokuColumn
     */
    public SudokuColumn getColumn(int y) {
        List<SudokuField> fragment = Arrays.asList(new SudokuField[9]);
        SudokuColumn column = new SudokuColumn(fragment, this.getBoard(), y);
        return column;
    }
    
    /**
     * Funkcja zwracajaca box z tablicy.
     *
     * @param x int
     * @param y int
     * @return SudokuBox
     */
    public SudokuBox getBox(int x, int y) {
        List<SudokuField> fragment = Arrays.asList(new SudokuField[9]);
        SudokuBox box = new SudokuBox(fragment, this.getBoard(), x, y);
        return box;
    }

    /**
     * Funkcja sprawdzajaca poprawnosc tablicy.
     *
     * @return boolean
     */
    public boolean checkBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col].getFieldValue() != 0) {
                    for (int i = 0; i < 9; i++) {
                        if ((board[row][i].getFieldValue() == board[row][col].getFieldValue())
                                && (i != col)) {
                            return false;
                        }
                    }
                    for (int i = 0; i < 9; i++) {
                        if ((board[i][col].getFieldValue() == board[row][col].getFieldValue())
                                && (i != row)) {
                            return false;
                        }
                    }
                    int rbox = row - row % 3;
                    int cbox = col - col % 3;
                    for (int m = rbox; m < rbox + 3; m++) {
                        for (int n = cbox; n < cbox + 3; n++) {
                            if (board[m][n].getFieldValue() == board[row][col].getFieldValue()
                                    && m != row && n != col) {
                                return false;
                            }
                        }
                    }
                }
            }

        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.board);
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
        final SudokuBoard other = (SudokuBoard) obj;
        
        return Objects.equal(this.board, other.board);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("Board", board).toString();
    }    
    
}
