package com.example.blockforce_kotlin

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Draw : View {

    var conv = resources.displayMetrics.density
    var game: Tet = Tet()

    constructor(context: Context) : super(context) {}

    fun setField(game: Tet) {
        this.game = game
        invalidate()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var p: Paint

        canvas.drawColor(Color.BLACK)
        var initx = 90 * conv
        var inity = 100 * conv
        var ratio = 18 * conv

        for (i in 3 until game.getField().size) {
            for (j in 0 until game.getField().get(i).size) {
                p = Pcolor(game.getField().get(i).get(j), (12 * conv).toInt())
                canvas.drawPoint(ratio * j + initx, ratio * (i - 3) + inity, p)
            }
        }

        initx = 110 * conv
        inity = 60 * conv
        ratio = 10 * conv
        for (k in game.getNextForm().indices) {
            for (i in 0 until game.getNextForm()[k]!!.size) {
                for (j in 0 until game.getNextForm()[k]!!.get(i).size) {
                    p = Pcolor(game.getNextForm()[k]!![i][j], (6 * conv).toInt())
                    var fk = k.toFloat()
                    if (k == 3) fk = (3.2).toFloat()
                    canvas.drawPoint(ratio * j + initx + fk * 50 * conv, ratio * (i - 3) + inity, p)
                }
            }
            initx += 5 * conv
        }
    }

    fun Pcolor(n: Int, size: Int): Paint {
        val p = Paint()
        p.strokeWidth = size.toFloat()
        when (n) {
            0 -> p.color = Color.BLACK
            1 -> p.color = Color.RED
            2 -> p.color = Color.BLUE
            3 -> p.color = Color.YELLOW
            4 -> p.color = Color.GREEN
            5 -> p.color = Color.CYAN
            6 -> p.color = Color.MAGENTA
            7 -> p.setARGB(255, 255, 165, 0)
            8 -> p.setARGB(255, 75, 0, 130)
            -1 -> p.color = Color.DKGRAY
            99 -> p.color = Color.WHITE
        }
        return p
    }
}