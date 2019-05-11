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
        SudokuBoard instance = new SudokuBoard();
        instance.setNumber(x, y, value);
        assertEquals(instance.getNumber(x, y), value);
        assertThrows(IllegalArgumentException.class, () -> {
            instance.setNumber(x, y, 10);
        });
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumber method, of class SudokuBoard.
     */
    @Test
    public void testCheckBoard() {
        System.out.println("board not valid");
        SudokuBoard instance = new SudokuBoard();
        instance.setNumber(3, 7, 4);
        instance.setNumber(7, 2, 8);
        assertEquals(instance.checkBoard(), true);
        instance.setNumber(1, 7, 5);
        instance.setNumber(2, 8, 5);
        assertFalse(instance.checkBoard());
        instance.setNumber(5, 2, 7);
        instance.setNumber(5, 6, 7);
        assertFalse(instance.checkBoard());
        instance.setNumber(7, 1, 6);
        instance.setNumber(2, 1, 6);
        assertFalse(instance.checkBoard());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of fillBoard method, of class SudokuBoard.
     */
    @Test
    public void differentBoards() {
        System.out.println("differentBoards");
        SudokuBoard sudoku1 = new SudokuBoard();
        SudokuBoard sudoku2 = new SudokuBoard();
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        solver.solve(sudoku1);
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
        SudokuBoard sudoku = new SudokuBoard();
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
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
        SudokuBoard sudoku = new SudokuBoard();
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
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
        SudokuBoard sudoku = new SudokuBoard();
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        sudoku.setNumber(3, 7, 4);
        solver.solve(sudoku);
        assertEquals(sudoku.checkBoard(), true);
        SudokuBox box = sudoku.getBox(3, 7);
        assertEquals(box.verify(), true);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Equals method, of class SudokuBoard.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        SudokuBoard sudoku = new SudokuBoard();
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        solver.solve(sudoku);
        assertTrue(sudoku.equals(sudoku));
        assertFalse(sudoku.equals(null));
        assertFalse(sudoku.equals(solver));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Equals method, of class SudokuBoard.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        SudokuBoard sudoku = new SudokuBoard();
        SudokuBoard sudoku2 = new SudokuBoard();
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        solver.solve(sudoku);
        solver.solve(sudoku2);
        assertThat(sudoku.hashCode(), is(not(equalTo(sudoku2.hashCode()))));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Equals method, of class SudokuBoard.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SudokuBoard sudoku = new SudokuBoard();
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        solver.solve(sudoku);
        System.out.println(sudoku.toString());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
