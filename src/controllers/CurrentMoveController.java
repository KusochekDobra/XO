package controllers;

import io.xo.Field;
import io.xo.Figure;

import java.awt.*;

public class CurrentMoveController {
    private static int numberMove = 0;

    public Figure currentMove(final Field field){

        if(numberMove%2 == 0){
            return Figure.X;
        }

        if(numberMove%2 == 1){
            return Figure.O;
        }
        if(numberMove > field.getSize()) {
            throw new RuntimeException();
        }
        return null;
    }

    public static void nextMove(){
        numberMove++;
    }

}
