package com.samkough.spriteanimation;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView
{
    private GameLoopThread gameLoopThread;
    private List<Sprite> sprites = new ArrayList<Sprite>();
    private List<TempSprite> temps = new ArrayList<TempSprite>();
    private long lastClick;
    private Bitmap bmpBlood;
    // for the about button
    private Bitmap bmpAbout;
    private Paint p;

    public GameView(Context context)
    {
        super(context);
        gameLoopThread = new GameLoopThread(this);
        getHolder().addCallback(new SurfaceHolder.Callback()
        {
            @Override
            public void surfaceDestroyed(SurfaceHolder holder)
            {
                boolean retry = true;
                gameLoopThread.setRunning(false);
                while (retry)
                {
                    try
                    {
                        gameLoopThread.join();
                        retry = false;
                    } catch (InterruptedException e)
                    {

                    }
                }
            }

            @Override
            public void surfaceCreated(SurfaceHolder holder)
            {
                createSprites();
                gameLoopThread.setRunning(true);
                gameLoopThread.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
            {

            }
        });

        bmpBlood = BitmapFactory.decodeResource(getResources(), R.drawable.blood1);
        p = new Paint();
        bmpAbout = BitmapFactory.decodeResource(getResources(), R.drawable.about);
        p.setColor(Color.RED);
    }

    private void createSprites()
    {
        sprites.add(createSprite(R.drawable.bad1));
        sprites.add(createSprite(R.drawable.bad2));
        sprites.add(createSprite(R.drawable.bad3));
        sprites.add(createSprite(R.drawable.bad4));
        sprites.add(createSprite(R.drawable.bad5));
        sprites.add(createSprite(R.drawable.bad6));
        sprites.add(createSprite(R.drawable.good1));
        sprites.add(createSprite(R.drawable.good2));
        sprites.add(createSprite(R.drawable.good3));
        sprites.add(createSprite(R.drawable.good4));
        sprites.add(createSprite(R.drawable.good5));
        sprites.add(createSprite(R.drawable.good6));
    }

    private Sprite createSprite(int resource)
    {
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), resource);
        return new Sprite(this, bmp);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawColor(Color.GRAY);

        for (int i = temps.size() - 1; i >= 0; i--) {

            temps.get(i).onDraw(canvas);
        }
        for (Sprite sprite : sprites)
        {
            sprite.onDraw(canvas);
        }

        canvas.drawBitmap(bmpAbout, 780, 1580, p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (System.currentTimeMillis() - lastClick > 300)
        {
            lastClick = System.currentTimeMillis();
            float x = event.getX();
            float y = event.getY();
            synchronized (getHolder())
            {
                for (int i = sprites.size() - 1; i >= 0; i--)
                {
                    Sprite sprite = sprites.get(i);
                    if (sprite.isCollision(x, y))
                    {
                        sprites.remove(sprite);
                        temps.add(new TempSprite(temps, this, x, y, bmpBlood));
                        break;
                    }
                }
            }
        }

        int action = event.getAction();
        float x = event.getX();
        float y = event.getY();
        float aboutX = Math.min(Math.max(x - bmpAbout.getWidth() / 2, 0), this.getWidth() - bmpAbout.getWidth());
        float aboutY = Math.min(Math.max(y - bmpAbout.getHeight() / 2, 0), this.getHeight() - bmpAbout.getHeight());

        switch(action)
        {
            case MotionEvent.ACTION_DOWN:
                if (x >= aboutX && x < (aboutX + bmpAbout.getWidth()) && y >= aboutY && y < (aboutY + bmpAbout.getHeight()))
                {
                    /* DOESN'T WORK */
                }
                break;
        }
        return true;
    }

}