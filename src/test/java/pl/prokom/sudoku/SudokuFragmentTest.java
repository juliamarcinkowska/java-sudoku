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
    public void testVerify() {
        System.out.println("verify");
        SudokuField [][] board = null;
        SudokuBoard sudoku = new SudokuBoard(board);
        sudoku.setArray(9);        
        sudoku.setNumber(3, 0, 7);
        sudoku.setNumber(3, 1, 4);
        sudoku.setNumber(3, 2, 8);
        sudoku.setNumber(3, 3, 3);
        sudoku.setNumber(3, 4, 1);
        sudoku.setNumber(3, 5, 5);
        sudoku.setNumber(3, 6, 6);
        sudoku.setNumber(3, 7, 2);
        sudoku.setNumber(3, 8, 9);
        SudokuRow row = sudoku.getRow(3);
        assertEquals(row.verify(), true);
        sudoku.setNumber(3, 0, 9);
        row = sudoku.getRow(3);
        assertEquals(row.verify(), false);
    }
    
}
