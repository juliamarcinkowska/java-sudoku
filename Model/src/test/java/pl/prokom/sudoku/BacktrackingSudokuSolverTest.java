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
        SudokuBoard instance = new SudokuBoard();
        instance.setNumber(3, 7, 4);
        instance.setNumber(7, 2, 1);
        instance.setNumber(5, 1, 3);
        instance.setNumber(2, 4, 5);
        instance.setNumber(4, 6, 9);
        instance.setNumber(1, 3, 7);
        assertEquals(instance.checkBoard(), true);
        solver.solve(instance);
        assertEquals(instance.getNumber(3, 7), 4);
        int[] test = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                test[j] = instance.getNumber(i, j);
            }
            List<Integer> listRow = Arrays.stream(test).boxed().collect(Collectors.toList());
            int count = (int) listRow.stream().distinct().count();
            assertEquals(9, count);
            for (int j = 0; j < 9; j++) {
                test[j] = instance.getNumber(i, j);
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
                        test[no] = instance.getNumber(m, n);
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
                assertTrue(instance.getNumber(i, j) >= 1 
                        && instance.getNumber(i, j) <= 9);
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
        SudokuBoard sudoku = new SudokuBoard();
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        solver.solve(sudoku);
        int[] test = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                test[j] = sudoku.getNumber(i, j);
            }
            List<Integer> listRow = Arrays.stream(test).boxed().collect(Collectors.toList());
            int count = (int) listRow.stream().distinct().count();
            assertEquals(count, 9);
            for (int j = 0; j < 9; j++) {
                test[j] = sudoku.getNumber(i, j);
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
                        test[no] = sudoku.getNumber(m, n);
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
                assertTrue(sudoku.getNumber(i, j) >= 1 
                        && sudoku.getNumber(i, j) <= 9);
            }
        }
    }

}
