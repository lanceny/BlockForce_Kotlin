package com.example.blockforce_kotlin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class Play : AppCompatActivity() {

    private var timer: Timer? = null

    private var game: Tet? = null
    private var period = 0
    private var sensitivity = 0
    private var sw = false
    private var level_view: TextView? = null
    private var Lines_view: TextView? = null
    private val handler: Handler? = Handler()
    private var cx = 0.0
    private var cy = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        game = Tet()

        sw = java.lang.Boolean.TRUE
        game!!.init()
        FieldDraw(game)
        timer = Timer()
        period = 1000
        cx = 0.0
        cy = 0.0
        sensitivity = 100
        level_view?.setText(resources.getString(R.string.Level, game!!.getLevel()))
        Lines_view?.setText(resources.getString(R.string.Lines, game!!.getDelete_count()))
        level_view = findViewById(R.id.Level)
        Lines_view = findViewById(R.id.Lines)
        repeat(handler)
        LevelCheck()
    }


    fun repeat(handler: Handler?) {
        val special = findViewById<TextView?>(R.id.SpecialFormView)
        timer?.schedule(object : TimerTask() {
            override fun run() {
                // handlerを通じてUI Threadへ処理をpost
                handler?.post(Runnable {
                    if (sw) {
                        //一定時間毎の処理をここに記述
                        if (!game?.update()!!) {
                            //ゲームオーバー時の処理
                            GameOver()
                        }
                        special.text = resources.getString(R.string.After_turns, game!!.getCount())
                        FieldDraw(game)
                        Lines_view?.setText(resources.getString(R.string.Lines, game!!.getDelete_count()))
                    }
                    sw = java.lang.Boolean.TRUE
                })
            }
        }, 0, period.toLong())
    }

    fun LevelCheck() {
        level_view?.setText(resources.getString(R.string.Level, game?.getLevel()))
        Lines_view?.setText(resources.getString(R.string.Lines, game?.getDelete_count()))
        period = 1000 - 100 * game!!.getLevel()
        timer?.cancel()
        timer = Timer()
        sw = java.lang.Boolean.FALSE
        repeat(handler)
    }

    fun GameOver() {
        timer?.cancel()
        val i = Intent()
        i.putExtra("Lines", game?.getDelete_count())
        setResult(RESULT_OK, i)
        finish()
        overridePendingTransition(0, 0)
    }

    fun Rotate_Left_onClick(view: View?) {
        game?.rotation(false)
        FieldDraw(game)
    }

    fun Rotate_Right_onClick(view: View?) {
        game?.rotation(true)
        FieldDraw(game)
    }

    fun Under_onClick(view: View?) {
        val special = findViewById<TextView?>(R.id.SpecialFormView)
        if (game?.getCount() == 4) {
            special.text = resources.getString(R.string.After_turns, 20)
        } else {
            special.text = resources.getString(R.string.After_turns, game!!.getCount() - 1)
        }
        if (game?.under()!!) {
            GameOver()
        }
        FieldDraw(game)
        LevelCheck()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.getAction()) {
            MotionEvent.ACTION_DOWN -> {
                cx = event.getX().toDouble()
                cy = event.getY().toDouble()
            }
            MotionEvent.ACTION_MOVE -> {
                if (cx - event.getX() > sensitivity) {
                    //左にスライドした場合の処理
                    game?.move(java.lang.Boolean.FALSE)
                    cx = event.getX().toDouble()
                } else if (cx - event.getX() < -sensitivity) {
                    //右にスライドした場合の処理
                    game?.move(java.lang.Boolean.TRUE)
                    cx = event.getX().toDouble()
                }
                if (cy - event.getY() < -sensitivity) {
                    //下にスライドした場合の処理
                    game?.update()
                    cy = event.getY().toDouble()
                }
                FieldDraw(game)
            }
            MotionEvent.ACTION_UP -> {
            }
        }
        return true
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        timer?.cancel()
        finish()
        overridePendingTransition(0, 0)
        return super.onKeyDown(keyCode, event)
    }

    fun FieldDraw(game: Tet?) {
        val v = findViewById<Draw?>(R.id.view)
        v.setField(game!!)
    }
}
