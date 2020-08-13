package com.samkough.shapes;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

public class CanvasView extends View
{
    // drawing paint
    private Paint paint = new Paint();
    // canvas paint
    private Paint canvasPaint = new Paint();
    // canvas
    private Canvas canvas = new Canvas();
    //canvas bitmap
    private Bitmap canvasBitmap;

    public CanvasView(Context context, AttributeSet attrs)
    {
        // Setting the anti-alias, stroke join and cap styles will make the user's drawings appear smoother.
        super(context, attrs);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        paint.setColor(Color.parseColor("#b09f44"));
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(canvasBitmap);
    }

    @Override
    protected void onDraw(Canvas drawCanvas)
    {
        drawCanvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
    }

    public void drawCircle()
    {
        int radius = 100;

        canvas.drawColor(Color.WHITE);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, paint);
        invalidate();
    }

    public void drawRectangle()
    {
        canvas.drawColor(Color.WHITE);
        // left top right bottom
        canvas.drawRect(50, 150, getWidth() / 2, getHeight() / 2, paint);
        System.out.println("Width: " + getWidth() / 2);
        System.out.println("Height: " + getHeight() / 2);
        invalidate();
    }

    public int getCanvasWidth()
    {
        return getWidth() / 2;
    }

    public int getCanvasHeight()
    {
        return getHeight() / 2;
    }

    public Point getCanvasCenter()
    {
        int canvasH = canvas.getHeight() / 2;
        int canvasW = canvas.getWidth() / 2;

        Point p = new Point(canvasW, canvasH);

        return p;
    }

    public void clearCanvas()
    {
        canvas.drawColor(Color.WHITE);
        invalidate();
    }
}