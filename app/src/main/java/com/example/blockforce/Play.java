package com.example.blockforce;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Timer;
import java.util.TimerTask;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Play extends AppCompatActivity {

    private Timer timer;
    private Tet game;
    private int period, sensitivity;
    private boolean sw;
    private TextView level_view = null, Lines_view = null;
    private final Handler handler = new Handler();
    private double cx,cy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        game = new Tet();
        sw = TRUE;
        game.init();
        FieldDraw(game);
        timer = new Timer();
        period = 1000;
        cx = 0; cy = 0;
        sensitivity = 100;
        level_view = findViewById(R.id.Level);
        Lines_view = findViewById(R.id.Lines);
        level_view.setText(getResources().getString(R.string.Level, game.getLevel()));
        Lines_view.setText(getResources().getString(R.string.Lines, game.getDelete_count()));
        repeat(handler);
    }

    public void repeat(final Handler handler){
        final TextView special = findViewById(R.id.SpecialFormView);
        timer.schedule( new TimerTask(){
            @Override
            public void run() {
                // handlerを通じてUI Threadへ処理をpost
                handler.post(new Runnable() {
                    public void run() {
                        if(sw){
                            //一定時間毎の処理をここに記述
                            if(!game.update()){
                                //ゲームオーバー時の処理
                                GameOver();
                            }
                            special.setText(getResources().getString(R.string.After_turns, game.getCount()));
                            FieldDraw(game);
                            Lines_view.setText(getResources().getString(R.string.Lines, game.getDelete_count()));
                        }
                        sw = TRUE;
                    }
                });
            }
        }, 0, period);
    }

    public void LevelCheck(){
        level_view.setText(getResources().getString(R.string.Level, game.getLevel()));
        Lines_view.setText(getResources().getString(R.string.Lines, game.getDelete_count()));

        period = 1000 - 100 * game.getLevel();
        timer.cancel();
        timer = new Timer();
        sw = FALSE;
        repeat(handler);
    }

    public void GameOver(){
        timer.cancel();
        Intent i = new Intent();
        i.putExtra("Lines", game.getDelete_count());
        setResult(RESULT_OK,i);
        finish();
        overridePendingTransition(0, 0);
    }

    public void Rotate_Left_onClick(View view) {
        game.rotation(false);
        FieldDraw(game);
    }

    public void Rotate_Right_onClick(View view) {
        game.rotation(true);
        FieldDraw(game);
    }

    public void Under_onClick(View view) {
        TextView special = findViewById(R.id.SpecialFormView);
        if(game.getCount() == 4){
            special.setText(getResources().getString(R.string.After_turns,20));
        }else{
            special.setText(getResources().getString(R.string.After_turns,game.getCount()-1));
        }
        if(game.under()){
            GameOver();
        }
        FieldDraw(game);
        LevelCheck();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                cx = event.getX();
                cy = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                if((cx - event.getX()) > sensitivity){
                    //左にスライドした場合の処理
                    game.move(FALSE);
                    cx = event.getX();
                }else if((cx - event.getX()) < -sensitivity){
                    //右にスライドした場合の処理
                    game.move(TRUE);
                    cx = event.getX();
                }
                if((cy - event.getY()) < -sensitivity){
                    //下にスライドした場合の処理
                    game.update();
                    cy = event.getY();
                }
                FieldDraw(game);
                break;
            case MotionEvent.ACTION_UP:
        }
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        timer.cancel();
        finish();
        overridePendingTransition(0, 0);
        return super.onKeyDown(keyCode, event);
    }

    public void FieldDraw (Tet game){
        Draw v = findViewById(R.id.view);
        v.setField(game);
    }
}
