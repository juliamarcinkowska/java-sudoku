/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.prokom.sudoku;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa FileSudokuBoardDao.
 */
public class FileSudokuBoardDao implements Dao<SudokuBoard> {

    private String fileName;

    public FileSudokuBoardDao(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public SudokuBoard read() {
        SudokuBoard board = new SudokuBoard();
        try {

            Scanner scan = new Scanner(new File(fileName));

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board.setNumber(i, j, scan.nextInt());
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileSudokuBoardDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return board;
    }

    @Override
    public void write(SudokuBoard obj) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            int[][] array = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    array[i][j] = obj.getNumber(i, j);
                    writer.write(array[i][j] + " ");
                }
                writer.append("\n");
            }

        } catch (IOException ex) {
            Logger.getLogger(FileSudokuBoardDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
