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
 * Klasa sudokuBoard.
 */
public class SudokuBoard {

    private List<List<SudokuField>> board = Arrays.asList(new List[9]);

    /**
     * Konstruktor SudokuBoard.
     */
    public SudokuBoard() {
        for (int i = 0; i < 9; i++) {
            board.set(i, Arrays.asList(new SudokuField[9]));
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.board.get(i).set(j, new SudokuField());
            }
        }

    }

    public List<List<SudokuField>> getBoard() {
        List<List<SudokuField>> copy = board;
        return copy;
    }

    public int getNumber(int x, int y) {
        return board.get(x).get(y).getFieldValue();
    }

    public void setNumber(int x, int y, int value) {
        board.get(x).get(y).setFieldValue(value);
    }

    /**
     * Funkcja zwracajaca rzad z tablicy.
     *
     * @param x int
     * @return SudokuRow
     */
    public SudokuRow getRow(int x) {
        SudokuRow row = new SudokuRow(this.getBoard(), x);
        return row;
    }

    /**
     * Funkcja zwracajaca kolumne z tablicy.
     *
     * @param y int
     * @return SudokuColumn
     */
    public SudokuColumn getColumn(int y) {
        SudokuColumn column = new SudokuColumn(this.getBoard(), y);
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
        SudokuBox box = new SudokuBox(this.getBoard(), x, y);
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
                if (board.get(row).get(col).getFieldValue() != 0) {
                    for (int i = 0; i < 9; i++) {
                        if ((board.get(row).get(i).getFieldValue()
                                == board.get(row).get(col).getFieldValue())
                                && (i != col)) {
                            return false;
                        }
                    }
                    for (int i = 0; i < 9; i++) {
                        if ((board.get(i).get(col).getFieldValue()
                                == board.get(row).get(col).getFieldValue())
                                && (i != row)) {
                            return false;
                        }
                    }
                    int rbox = row - row % 3;
                    int cbox = col - col % 3;
                    for (int m = rbox; m < rbox + 3; m++) {
                        for (int n = cbox; n < cbox + 3; n++) {
                            if (board.get(m).get(n).getFieldValue()
                                    == board.get(row).get(col).getFieldValue()
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
        return com.google.common.base.Objects.hashCode(this.board);
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

        return com.google.common.base.Objects.equal(this.board, other.board);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("\n", getRow(0))
                .add("\n", getRow(1))
                .add("\n", getRow(2))
                .add("\n", getRow(3))
                .add("\n", getRow(4))
                .add("\n", getRow(5))
                .add("\n", getRow(6))
                .add("\n", getRow(7))
                .add("\n", getRow(8)).toString();
    }

}
