/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.prokom.sudoku;

/**
 * Klasa SudokuBoardDaoFactory.
 */
public class SudokuBoardDaoFactory {

    public Dao getFileDao(String filename) {
        Dao dao = new FileSudokuBoardDao(filename);
        return dao;
    }
}
