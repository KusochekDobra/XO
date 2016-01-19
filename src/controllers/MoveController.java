package controllers;

import io.xo.Field;
import io.xo.Figure;
import io.xo.exception.AlreadyOccupiedException;
import io.xo.exception.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field, final Point point, final Figure figure) throws InvalidPointException, AlreadyOccupiedException {

        if (field.getFigure(point) != null){
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);

    }
}
