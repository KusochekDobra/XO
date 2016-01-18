package io.xo;

import controllers.WinnerController;
import io.xo.exception.InvalidPointException;
import org.junit.Test;

import java.awt.*;

public class TestWinner {
    @Test
    public void Test1(){
        Field field = new Field(3);
        try {
            field.setFigure(new Point(0,0), Figure.O);
            field.setFigure(new Point(0,1), Figure.X);
            field.setFigure(new Point(0,2), Figure.X);
            field.setFigure(new Point(1,0), Figure.O);
            field.setFigure(new Point(2,0), Figure.O);

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        WinnerController winnerController = new WinnerController();
        System.out.println(winnerController.getWinner(field));
    }
}
