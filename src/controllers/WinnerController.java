package controllers;

import io.xo.Field;
import io.xo.Figure;
import io.xo.exception.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(Field field) {

        try {
            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(i, 0), p -> new Point(p.x, p.y + 1))) {
                    return field.getFigure(new Point(i, 0));
                }
            }

            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(i, 0), p -> new Point(p.x + 1, p.y))) {
                    return field.getFigure(new Point(0, i));
                }
            }

            if (check(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1)))
                return field.getFigure(new Point(field.getSize() / 2, field.getSize() / 2));

            if (check(field, new Point(2, 0), p -> new Point(p.x - 1, p.y + 1)))
                return field.getFigure(new Point(field.getSize() / 2, field.getSize() / 2));

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(final Field field, final Point currentPoint, IPointChanger pointChanger){
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointChanger.next(currentPoint);

        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(currentPoint);
        } catch (InvalidPointException e) {
            return true;//?
        }

        if(currentFigure == null) return false;

        if(currentFigure != nextFigure) return false;

        return check(field, nextPoint, pointChanger);
    }

    private interface IPointChanger{
        Point next(final Point p);
    }
}
