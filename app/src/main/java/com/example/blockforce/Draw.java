package com.example.blockforce;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Draw extends View {
    float conv = getResources().getDisplayMetrics().density;
    Tet game = new Tet();

    public Draw(Context context) {
        super(context);
    }

    public void setField(Tet game) {
        this.game = game;
        invalidate();
    }

    public Draw(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Draw(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        Paint p;
        canvas.drawColor(Color.BLACK);
        float initx = 90*conv ,inity = 100*conv ,ratio = 18*conv;
        for(int i = 3; i < game.getField().length; i++){
            for(int j = 0; j < game.getField()[i].length; j++){
                p=Pcolor(game.getField()[i][j], (int)(12 * conv));
                canvas.drawPoint((ratio * j + initx), (ratio * (i - 3) + inity), p);
            }
        }
        initx = 110 * conv;
        inity = 60 * conv;
        ratio = 10 * conv;
        for(int k = 0; k < game.getNextForm().length; k++){
            for(int i = 0; i < game.getNextForm()[k].length; i++){
                for(int j = 0; j < game.getNextForm()[k][i].length; j++){
                    p = Pcolor(game.getNextForm()[k][i][j], (int)(6 * conv));
                    float fk = k;
                    if(k == 3) fk = (float) 3.2;
                    canvas.drawPoint((ratio * j + initx + fk * 50 * conv),(ratio * (i - 3) + inity), p);
                }
            }
            initx += 5 * conv;
        }

    }

    public Paint Pcolor(int n, int size){
        Paint p = new Paint();
        p.setStrokeWidth(size);
        switch (n){
            case 0:
                p.setColor(Color.BLACK);
                break;
            case 1:
                p.setColor(Color.RED);
                break;
            case 2:
                p.setColor(Color.BLUE);
                break;
            case 3:
                p.setColor(Color.YELLOW);
                break;
            case 4:
                p.setColor(Color.GREEN);
                break;
            case 5:
                p.setColor(Color.CYAN);
                break;
            case 6:
                p.setColor(Color.MAGENTA);
                break;
            case 7:
                p.setARGB(255,255,165,0);

                break;
            case 8:
                p.setARGB(255,75,0,130);
                break;
            case -1:
                p.setColor(Color.DKGRAY);
                break;
            case 99:
                p.setColor(Color.WHITE);
                break;
        }
        return p;
    }
}
