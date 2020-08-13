package samkough.com.painter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class CanvasView extends View
{
    /*
    * When the user touches the screen and moves their finger to draw,
    * we will use a Path to trace their drawing action on the canvas.
    * Both the canvas and the drawing on top of it are represented by Paint
    * objects. The initial paint color corresponds to the first color
    * in the palette we created last time, which will be initially selected
    * when the app launches. Finally we declare variables for the canvas
    * and bitmap - the user paths drawn with drawPaint will be drawn onto
    * the canvas, which is drawn with canvasPaint.
    * */
    //drawing paint
    private Paint paint = new Paint();
    // canvas paint
    private Paint canvasPaint = new Paint();
    //drawing path
    private Path path = new Path();
    // canvas
    private Canvas canvas = new Canvas();
    //canvas bitmap
    private Bitmap canvasBitmap;
    // brush size and pixel size
    private float brushSize, pixelAmount;

    public CanvasView(Context context, AttributeSet attrs)
    {
        // Setting the anti-alias, stroke join and cap styles will make the user's drawings appear smoother.
        super(context, attrs);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
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
        canvas.drawPath(path, paint);
        drawCanvas.drawBitmap(canvasBitmap, 0, 0, canvasPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
        // get the coords of the touch event
        float eventX = e.getX();
        float eventY = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // set a new starting point
                path.moveTo(eventX, eventY);
                path.reset();
                path.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                // connect the points
                path.lineTo(eventX, eventY);
                break;
            default:
                return false;
        }

        // makes you view repaint and call ondraw
        invalidate();
        return true;
    }

    public void clearCanvas()
    {
        path.reset();
        canvas.drawColor(Color.WHITE);
        invalidate();
    }

    public void setStrokeWidth(float f)
    {
        pixelAmount = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, f, getResources().getDisplayMetrics());
        brushSize = pixelAmount;

        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(brushSize);
        invalidate();
    }

    public void setColor(int p)
    {
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(p);
        invalidate();
    }
}