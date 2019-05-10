/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.prokom.sudoku;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
public class BacktrackingSudokuSolverTest {

    public BacktrackingSudokuSolverTest() {
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
     * Test of solve method, of class BacktrackingSudokuSolver.
     */
    @Test
    public void testSolve() {
        System.out.println("not solved");
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuField [][] board = null;
        SudokuBoard instance = new SudokuBoard(board);
        instance.setArray(9);
        instance.setNumber(3, 7, 4);
        instance.setNumber(7, 2, 8);
        instance.setNumber(5, 1, 3);
        instance.setNumber(2, 4, 5);
        instance.setNumber(4, 6, 9);
        instance.setNumber(1, 3, 7);
        assertEquals(instance.checkBoard(), true);
        solver.solve(instance);
        assertEquals(instance.getBoard()[3][7].getFieldValue(), 4);
        int[] test = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                test[j] = instance.getBoard()[i][j].getFieldValue();
            }
            List<Integer> listRow = Arrays.stream(test).boxed().collect(Collectors.toList());
            int count = (int) listRow.stream().distinct().count();
            assertEquals(9, count);
            for (int j = 0; j < 9; j++) {
                test[j] = instance.getBoard()[j][i].getFieldValue();
            }
            List<Integer> listCol = Arrays.stream(test).boxed().collect(Collectors.toList());
            count = (int) listCol.stream().distinct().count();
            assertEquals(9, count);

        }
        int no = 0;
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int m = i; m < i + 3; m++) {
                    for (int n = j; n < j + 3; n++) {
                        test[no] = instance.getBoard()[m][n].getFieldValue();
                        no++;
                    }
                }
                List<Integer> listBox = Arrays.stream(test).boxed().collect(Collectors.toList());
                int count = (int) listBox.stream().distinct().count();
                assertEquals(9, count);
                no = 0;
            }
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        for (int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                assertTrue(instance.getBoard()[i][j].getFieldValue() >= 1 
                        && instance.getBoard()[i][j].getFieldValue() <= 9);
            }
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of fillBoard method, of class SudokuBoard.
     */
    @Test
    public void validBoard() {
        System.out.println("notValidBoard");
        SudokuField [][] board = null;
        SudokuBoard sudoku = new SudokuBoard(board);
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        sudoku.setArray(9);
        solver.solve(sudoku);
        int[] test = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                test[j] = sudoku.getBoard()[i][j].getFieldValue();
            }
            List<Integer> listRow = Arrays.stream(test).boxed().collect(Collectors.toList());
            int count = (int) listRow.stream().distinct().count();
            assertEquals(count, 9);
            for (int j = 0; j < 9; j++) {
                test[j] = sudoku.getBoard()[j][i].getFieldValue();
            }
            List<Integer> listCol = Arrays.stream(test).boxed().collect(Collectors.toList());
            count = (int) listCol.stream().distinct().count();
            assertEquals(count, 9);

        }
        int no = 0;
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int m = i; m < i + 3; m++) {
                    for (int n = j; n < j + 3; n++) {
                        test[no] = sudoku.getBoard()[m][n].getFieldValue();
                        no++;
                    }
                }
                List<Integer> listBox = Arrays.stream(test).boxed().collect(Collectors.toList());
                int count = (int) listBox.stream().distinct().count();
                assertEquals(count, 9);
                no = 0;
            }
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        for (int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                assertTrue(sudoku.getBoard()[i][j].getFieldValue() >= 1 
                        && sudoku.getBoard()[i][j].getFieldValue() <= 9);
            }
        }
    }

}
