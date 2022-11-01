package com.example.lesson20221101;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MyDraw extends View {
    public int figureCount = 0;
    ArrayList<Figure> figures = new ArrayList<>();
    public MyDraw(Context context) {
        super(context);
    }

    void addFigure(int x, int y) {
        figureCount++;
        int type = (int)(Math.random()*4);
        Figure figure = getFigure(3,x,y);
        figures.add(figure);
        invalidate();
    }

    private Figure getFigure(int type, int x, int y) {
        int[] colors = {Color.GREEN, Color.RED, Color.BLUE, Color.YELLOW};
        int color = colors[(int)((Math.random())*colors.length)];
        switch (type) {
            case 0: return new Circle(x,y,color);
            case 1: return new Rectangle(x,y,color);
            case 2: return new Circle(x,y,color, 50);
            case 3: return new Home(x,y,color, 50);
            default: return new Figure(x,y,color);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_MOVE) {
            addFigure((int)event.getX(), (int)event.getY());
        }
        else if (event.getAction()==MotionEvent.ACTION_UP) {
            figures.clear();
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < figures.size(); i++) {
            if (figures.get(i) == null) continue;
            figures.get(i).draw(canvas);
        }
        invalidate();
    }
}
