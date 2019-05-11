/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.prokom.sudoku;


import org.junit.jupiter.api.Test;



/**
 *
 * @author Julia
 */
public class FileSudokuBoardDaoTest {

    public FileSudokuBoardDaoTest() {
    }

    /**
     * Test of read method, of class FileSudokuBoardDao.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        SudokuBoard board = new SudokuBoard();
        FileSudokuBoardDao instance = new FileSudokuBoardDao("sudoku.txt");
        board = instance.read();
        System.out.println(board.toString());

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class FileSudokuBoardDao.
     */
    @Test
    public void testWrite() {
        System.out.println("write");
        SudokuBoard obj = new SudokuBoard();
        FileSudokuBoardDao instance = new FileSudokuBoardDao("sudoku.txt");
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        solver.solve(obj);
        instance.write(obj);

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
@Test
    public void testWriteFactory() {
        System.out.println("write factory");
        SudokuBoard obj = new SudokuBoard();
        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
        Dao instance = factory.getFileDao("sudoku.txt");
        BacktrackingSudokuSolver solver = new BacktrackingSudokuSolver();
        solver.solve(obj);
        instance.write(obj);

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
