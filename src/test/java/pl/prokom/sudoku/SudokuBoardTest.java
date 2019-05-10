/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.prokom.sudoku;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.google.common.testing.EqualsTester;


/**
 *
 * @author Julia
 */
public class SudokuBoardTest {

    public SudokuBoardTest() {
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
     * Test of setNumber method, of class SudokuBoard.
     */
    @Test
    public void testSetNumber() {
        System.out.println("setNumber");
        int x = 3;
        int y = 7;
        int value = 4;
        SudokuField[][] board = null;
        SudokuBoard instance = new SudokuBoard(board);
        instance.setArray(9);
        instance.setNumber(x, y, value);
        assertEquals(instance.getNumber(x, y), value);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumber method, of class SudokuBoard.
     */
    @Test
    public void testCheckBoard() {
        System.out.println("board not valid");
        SudokuField[][] board = null;
        SudokuBoard instance = new SudokuBoard(board);
        instance.setArray(9);
        instance.setNumber(3, 7, 4);
        instance.setNumber(7, 2, 8);
        assertEquals(instance.checkBoard(), true);
        instance.setNumber(1, 7, 5);
        instance.setNumber(2, 8, 5);
        assertEquals(instance.checkBoard(), false);
        instance.setNumber(5, 2, 7);
        instance.setNumber(5, 6, 7);
        assertEquals(instance.checkBoard(), false);
        instance.setNumber(7, 1, 6);
        instance.setNumber(2, 1, 6);
        assertEquals(instance.checkBoard(), false);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of fillBoard method, of class SudokuBoard.
     */
    @Test
    public void differentBoards() {
        System.out.println("differentBoards");
        SudokuField [][] board1 = null, board2 = null;
        SudokuBoard sudoku1 = new SudokuBoard(board1);
        SudokuBoard sudoku2 = new SudokuBoard(board2);
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        sudoku1.setArray(9);
        solver.solve(sudoku1);
        sudoku2.setArray(9);
        solver.solve(sudoku2);
        assertThat(sudoku1.getBoard(), is(not(equalTo(sudoku2.getBoard()))));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRow method, of class SudokuBoard.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        SudokuField [][] board = null;
        SudokuBoard sudoku = new SudokuBoard(board);
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        sudoku.setArray(9);
        sudoku.setNumber(3, 7, 4);
        solver.solve(sudoku);
        assertEquals(sudoku.checkBoard(), true);
        SudokuRow row = sudoku.getRow(3);
        assertEquals(row.verify(), true);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of getRow method, of class SudokuBoard.
     */
    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        SudokuField [][] board = null;
        SudokuBoard sudoku = new SudokuBoard(board);
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        sudoku.setArray(9);
        sudoku.setNumber(3, 7, 4);
        solver.solve(sudoku);
        assertEquals(sudoku.checkBoard(), true);
        SudokuColumn col = sudoku.getColumn(7);
        assertEquals(col.verify(), true);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getBox method, of class SudokuBoard.
     */
    @Test
    public void testGetBox() {
        System.out.println("getBox");
        SudokuField [][] board = null;
        SudokuBoard sudoku = new SudokuBoard(board);
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        sudoku.setArray(9);
        sudoku.setNumber(3, 7, 4);
        solver.solve(sudoku);
        assertEquals(sudoku.checkBoard(), true);
        SudokuBox box = sudoku.getBox(3, 7);
        assertEquals(box.verify(), true);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of getBox method, of class SudokuBoard.
     */
    @Test
    public void testEquals() {
        SudokuField [][] board = null;
        SudokuField [][] board1 = null;
        new EqualsTester()
            .addEqualityGroup(new SudokuBoard(board), new SudokuBoard(board))
            .testEquals();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
