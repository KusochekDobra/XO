package io.xo;

import io.xo.exception.AlreadyOccupiedException;
import io.xo.exception.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void testGetSize() throws Exception {
        Field field = new Field(3);

        assertEquals(3, field.getSize());
    }

    @Test
    public void testSetFigure() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }
/*
    @Test
    public void testSetFigureWhenAlreadyOccupied() throws Exception {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        try{
            field.setFigure(inputPoint, inputFigure);
            fail();
        }catch (final AlreadyOccupiedException e){}
    }
*/
    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);


    }

    @Test
    public void testGetFigureWhenXIsLessNull() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(-1, 0);


        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {

        }
    }

    @Test
    public void testGetFigureWhenXIsMoreThenSize() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.getSize() + 1, 0);


        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {

        }
    }

    @Test
    public void testGetFigureWhenYIsLessNull() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, -1);


        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {

        }
    }

    @Test
    public void testGetFigureWhenYIsMoreThenSize() throws Exception {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0, field.getSize() + 1);


        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {

        }
    }
}