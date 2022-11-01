package com.example.lesson20221101;

import android.graphics.Canvas;

public class Circle extends Figure {
    public int radius;

    public Circle(int x, int y, int color, int radius) {
        super(x, y, color);
        this.radius = radius;
    }

    public Circle(int x, int y, int color) {
        this(x,y,color,20);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawCircle(getX(), getY(), this.radius, paint);
    }
}
