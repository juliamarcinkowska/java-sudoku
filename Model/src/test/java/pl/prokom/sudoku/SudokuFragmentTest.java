/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.prokom.sudoku;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Julia
 */
public class SudokuFragmentTest {

    public SudokuFragmentTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of testVerify method, of class SudokuFragment.
     */
    @Test
    public void testVerifyRow() {
        System.out.println("verify row");
        SudokuFragment row = new SudokuRow();
        for (int i = 0; i < 9; i++) {
            row.fragment.get(i).setFieldValue(i);
        }
        assertEquals(row.verify(), true);
        row.fragment.get(5).setFieldValue(4);
        assertEquals(row.verify(), false);
    }

    /**
     * Test of testVerify method, of class SudokuFragment.
     */
    @Test
    public void testVerifyBox() {
        System.out.println("verify box");
        SudokuFragment box = new SudokuBox();
        for (int i = 0; i < 9; i++) {
            box.fragment.get(i).setFieldValue(i);
        }
        assertEquals(box.verify(), true);
        box.fragment.get(5).setFieldValue(4);
        assertEquals(box.verify(), false);
    }

    /**
     * Test of testVerify method, of class SudokuFragment.
     */
    @Test
    public void testVerifyColumn() {
        System.out.println("verify column");
        SudokuFragment column = new SudokuColumn();
        for (int i = 0; i < 9; i++) {
            column.fragment.get(i).setFieldValue(i);
        }
        assertTrue(column.verify());
        column.fragment.get(5).setFieldValue(4);
        assertFalse(column.verify());
    }

    /**
     * Test of getBox method, of class SudokuFragment.
     */
    @Test
    public void testGetBox() {
        System.out.println("get box");
        SudokuBoard board = new SudokuBoard();
        SudokuFragment box = new SudokuBox();
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        solver.solve(board);
        box = board.getBox(1, 3);
        assertTrue(box.verify());
        assertEquals(board.getNumber(1, 3), box.fragment.get(3).getFieldValue());
        assertEquals(board.getNumber(2, 5), box.fragment.get(8).getFieldValue());
    }

}
