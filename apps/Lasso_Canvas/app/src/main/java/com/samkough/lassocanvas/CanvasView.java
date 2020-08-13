package com.samkough.lassocanvas;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CanvasView extends View
{

    public int width;
    public int height;
    public Bitmap mBitmap;
    public Canvas mCanvas;
    public Path mPath;
    Context context;
    public Paint mPaint;
    public float mX, mY;
    public static final float TOLERANCE = 5;
    float getX;
    float getY;
    String str;
    float x, y;
    Intent i;

    public CanvasView(Context c, AttributeSet attrs)
    {
        super(c, attrs);
        context = c;

        // we set a new Path
        mPath = new Path();

        // and we set a new Paint with the desired attributes
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(6f);
    }

    // override onSizeChanged
    @Override
    public void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w, h, oldw, oldh);

        // your Canvas will draw onto the defined Bitmap
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    // override onDraw
    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        // draw the mPath with the mPaint on the canvas when onDraw
        canvas.drawPath(mPath, mPaint);


    }

    // when ACTION_DOWN start touch according to the x,y values
    public void startTouch(float x, float y)
    {
        mPath.moveTo(x, y);
        mX = x;
        mY = y;
    }

    // when ACTION_MOVE move touch according to the x,y values
    public void moveTouch(float x, float y)
    {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);

        if (dx >= TOLERANCE || dy >= TOLERANCE)
        {
            mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
            mX = x;
            mY = y;
        }
    }

    public void clearCanvas()
    {
        mPath.reset();
        invalidate();
    }

    public String getPoint(float x, float y)
    {
        str = "(" + x + ", " + y + ")";
        System.out.println(str);
        return str;
    }

    public String getPoint2()
    {
        String str = "";



        return str;
    }

    // when ACTION_UP stop touch
    public void upTouch()
    {
        mPath.lineTo(mX, mY);
    }

    //override the onTouchEvent
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        x = event.getX();
        y = event.getY();

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                startTouch(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                moveTouch(x, y);
                System.out.println("X = " + x + " and the Y = " + y);
                getPoint(x, y);
                getPoint2();
                str = "(" + x + ", " + y + ")";
                toString();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                upTouch();
                invalidate();
                break;

        }
        return true;
    }

    public void setColor(int p)
    {
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setColor(p);
        invalidate();
    }

    public float getX()
    {
        return x;
    }


    public float getY()
    {
        return y;
    }

    public String toString()
    {
        return str;
    }
}