package io.xo;

import controllers.CurrentMoveController;
import io.xo.exception.InvalidPointException;

import java.awt.*;

public class Field {
    public final int fieldSize;
    private static final int MIN_COORDINATE = 0;

    private final Figure[][] field ;

    public int getSize(){
        return fieldSize;
    }

    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
        field = new Figure[fieldSize][fieldSize];
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
            if(!checkPoint(point)){
                throw new InvalidPointException();
            }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException{
        if(!checkPoint(point)){
            throw new InvalidPointException();
        }

        field[point.x][point.y] = figure;

        CurrentMoveController.nextMove();
    }

    private boolean checkPoint(final Point point){
        return (checkCoordinate(point.x, field.length) && checkCoordinate(point.y, field[point.x].length));
    }
    private boolean checkCoordinate(final int coordinate, final int maxCoordinate){
        return(coordinate >= MIN_COORDINATE && coordinate < maxCoordinate);
    }
}
