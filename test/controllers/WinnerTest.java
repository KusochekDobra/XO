package controllers;

import controllers.WinnerController;
import io.xo.Field;
import io.xo.Figure;
import io.xo.exception.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class WinnerTest {

    @Test
    public void LineTest(){
        final int size = 3;
        final Field field = new Field(size);

        try {
            for(int i = 0; i < size; i++){
                field.setFigure(new Point(i, 0), Figure.O);
            }



        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        WinnerController winnerController = new WinnerController();
        assertEquals(Figure.O, winnerController.getWinner(field));

    }

    @Test
    public void ColumnTest(){
        final int size = 3;
        final Field field = new Field(size);

        try {
           for(int i = 0; i < size; i++){
            field.setFigure(new Point(0, i), Figure.X);

           }



        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        WinnerController winnerController = new WinnerController();
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void MainDiagonalTest(){
        final int size = 3;
        final Field field = new Field(size);
        try {
            for(int i = 0; i < size; i++){
                field.setFigure(new Point(i, i), Figure.X);
             }



        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        WinnerController winnerController = new WinnerController();
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void AdverseDiagonalTest(){
        final int size = 3;
        final Field field = new Field(size);

        try {
            for(int i = 0; i < size; i++){
                field.setFigure(new Point(i, size - 1 - i), Figure.X);
                }



        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        WinnerController winnerController = new WinnerController();
        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void NoWinnerTest(){
        final int size = 3;
        final Field field = new Field(size);

        try {
                field.setFigure(new Point(0, 0), Figure.X);
                field.setFigure(new Point(1, 0), Figure.X);
                field.setFigure(new Point(0, 1), Figure.X);

                field.setFigure(new Point(2, 0), Figure.O);
                field.setFigure(new Point(2, 1), Figure.O);
                field.setFigure(new Point(1, 1), Figure.O);

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        WinnerController winnerController = new WinnerController();
        assertNull(winnerController.getWinner(field));
    }
}
