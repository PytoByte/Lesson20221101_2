package com.example.lesson20221101;

import android.graphics.Canvas;

public class Rectangle extends Figure {
    public int scale;

    public Rectangle(int x, int y, int color, int scale) {
        super(x, y, color);
        this.scale = scale;
    }

    public Rectangle(int x, int y, int color) {
        this(x,y,color,20);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawRect(getX()-scale, getY()-scale, getX()+scale, getY()+scale, paint);
    }
}
