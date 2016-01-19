package controllers;

import io.xo.Field;
import io.xo.Figure;
import io.xo.exception.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void testCurrentMove() throws Exception {

            final int size = 3;
            final Field field = new Field(size);

            try {

                    field.setFigure(new Point(0, 0), Figure.X);
                    field.setFigure(new Point(0, 1), Figure.O);
                    field.setFigure(new Point(0, 2), Figure.X);


            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
          CurrentMoveController currentMoveController = new CurrentMoveController();
          assertEquals(Figure.X, currentMoveController.currentMove(field));


    }
}