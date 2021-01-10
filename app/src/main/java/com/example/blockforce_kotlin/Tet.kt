package com.example.blockforce_kotlin

import android.util.Log
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom

class Tet {
    private var field: Array<IntArray> = arrayOf(   intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99),
                                                    intArrayOf(99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99)
    )

    fun getField(): Array<IntArray> {
        return field
    }

    fun getCount(): Int {
        return count
    }

    fun getLevel(): Int {
        return level
    }

    fun getDelete_count(): Int {
        return delete_count
    }

    fun getNextForm(): Array<Array<IntArray>?> {
        val next = arrayOfNulls<Array<IntArray>>(4)
        next[0] = nextForm1
        next[1] = nextForm2
        next[2] = nextForm3
        next[3] = specialForm
        return next
    }

    private val Default_block: Array<Array<IntArray>> =  arrayOf(
            arrayOf(
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0)
            ),
            arrayOf(
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 0),
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0)
            ),
            arrayOf(
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 2, 2, 2, 0),
                    intArrayOf(0, 2, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0)
            ),
            arrayOf(intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 3, 3, 3, 0),
                    intArrayOf(0, 0, 0, 3, 0),
                    intArrayOf(0, 0, 0, 0, 0)
            ),
            arrayOf(intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 4, 4, 0),
                    intArrayOf(0, 4, 4, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0)
            ),
            arrayOf(intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 5, 5, 0, 0),
                    intArrayOf(0, 0, 5, 5, 0),
                    intArrayOf(0, 0, 0, 0, 0)
            ),
            arrayOf(intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 6, 6, 0, 0),
                    intArrayOf(0, 6, 6, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0)
            ),
            arrayOf(intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 7, 7, 7, 0),
                    intArrayOf(0, 0, 7, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0)
            ),
            arrayOf(intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 8),
                    intArrayOf(8, 8, 8, 8, 8),
                    intArrayOf(0, 0, 0, 0, 8),
                    intArrayOf(0, 0, 0, 0, 0)
            ),
            arrayOf(intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(8, 8, 8, 8, 0),
                    intArrayOf(8, 8, 8, 8, 0),
                    intArrayOf(8, 8, 8, 8, 0)
            ),
            arrayOf(intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(8, 8, 8, 8, 8),
                    intArrayOf(8, 0, 8, 0, 8),
                    intArrayOf(8, 0, 8, 0, 8)
            ),
            arrayOf(intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(8, 8, 0, 8, 8),
                    intArrayOf(0, 8, 8, 8, 0),
                    intArrayOf(8, 8, 0, 8, 8),
                    intArrayOf(0, 0, 0, 0, 0)
            ),
            arrayOf(intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 8, 0, 8, 0),
                    intArrayOf(0, 0, 8, 0, 0),
                    intArrayOf(0, 8, 0, 8, 0),
                    intArrayOf(0, 0, 0, 0, 0)
            ),
            arrayOf(intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 8, 0, 0),
                    intArrayOf(8, 8, 8, 8, 8),
                    intArrayOf(0, 8, 0, 8, 0)
            ),
            arrayOf(intArrayOf(0, 0, 0, 0, 0),
                    intArrayOf(0, 8, 0, 8, 0),
                    intArrayOf(8, 8, 8, 8, 8),
                    intArrayOf(0, 8, 0, 8, 0),
                    intArrayOf(0, 0, 0, 0, 0)
            )
    )
    private var currentForm: Array<IntArray> = Array(5) { IntArray(5) }
    private var currentX = 0
    private var currentY = 0
    private var nextForm1: Array<IntArray> = Array(5) { IntArray(5) }
    private var nextForm2: Array<IntArray> = Array(5) { IntArray(5) }
    private var nextForm3: Array<IntArray> = Array(5) { IntArray(5) }
    private var specialForm: Array<IntArray> = Array(5) { IntArray(5) }
    private var count = 0
    private var level = 1
    private var delete_count = 0
    private var check_delete_count = 0

    //最初の初期化，次，その次，さらに次のブロックも格納
    fun init() {
        try {
            val random = SecureRandom.getInstance("SHA1PRNG")
            nextForm1 = Default_block.get(random.nextInt(7) + 1)
            nextForm2 = Default_block.get(random.nextInt(7) + 1)
            nextForm3 = Default_block.get(random.nextInt(7) + 1)
            currentForm = Default_block.get(random.nextInt(7) + 1)
            specialForm = Default_block.get(random.nextInt(7) + 8)
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        currentX = 3
        currentY = 7
        count = 20
        reflection(currentForm, currentX, currentY, java.lang.Boolean.TRUE)
        underLocation()
    }

    //選択してるブロックtarget(5×5)をfieldのx,yの位置に反映する.反映できたらTRUE，反映する場所に何かしらのブロックがあればFALSE.
    fun reflection(target: Array<IntArray>, x: Int, y: Int, sw: Boolean): Boolean {
        val temp = Array<IntArray>(26) { IntArray(14) }
        for (i in temp.indices) {
            System.arraycopy(field.get(i), 0, temp[i], 0, temp[i].size)
        }
        for (i in -2..2) {
            for (j in -2..2) {
                if (target.get(i + 2).get(j + 2) != 0) {
                    if (y + j >= 0 && y + j <= 13) {
                        if (field.get(x + i).get(y + j) > 0) {
                            field = temp
                            return java.lang.Boolean.FALSE
                        }
                    } else {
                        field = temp
                        return java.lang.Boolean.FALSE
                    }
                    field.get(x + i)[y + j] = target.get(i + 2).get(j + 2)
                }
            }
        }
        if (!sw) {
            field = temp
        }
        return java.lang.Boolean.TRUE
    }

    //新しいブロックを生成(nextFormをfieldに生成してnextFormをずらして3番目をランダムに生成) and 生成できるかどうか(ゲームオーバーかどうかの判定)
    fun newBlock(): Boolean {
        currentForm = nextForm1
        nextForm1 = nextForm2
        nextForm2 = nextForm3
        if (count == 4) {
            nextForm3 = specialForm
            try {
                val random = SecureRandom.getInstance("SHA1PRNG")
                specialForm = Default_block.get(random.nextInt(7) + 8)
            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            }
            count = 20
        } else {
            try {
                val random = SecureRandom.getInstance("SHA1PRNG")
                nextForm3 = Default_block.get(random.nextInt(7) + 1)
            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            }
            count--
        }
        currentX = 3
        currentY = 7
        if (!reflection(currentForm, currentX, currentY, java.lang.Boolean.TRUE)) {
            Log.d("gameover", "gameover")
            return java.lang.Boolean.TRUE
        }
        underLocation()
        return java.lang.Boolean.FALSE
    }

    //現在のブロックを一段下に下げる and 下げ切ったのなら行を削除するかを確認してnewblock()呼び出し
    fun update(): Boolean {
        DrawDelete(currentForm, currentX, currentY)
        currentX++
        if (!reflection(currentForm, currentX, currentY, java.lang.Boolean.TRUE)) {
            //下げ切った場合
            currentX--
            reflection(currentForm, currentX, currentY, java.lang.Boolean.TRUE)
            DeleteCheck()
            if (newBlock()) {
                return java.lang.Boolean.FALSE
            }
        }
        underLocation()
        return java.lang.Boolean.TRUE
    }

    //行を削除するかを確認,揃ってる行があれば削除
    fun DeleteCheck() {
        var i = field.size - 2
        while (i > 2) {
            var judge = java.lang.Boolean.TRUE
            for (j in 0 until field.get(i).size) {
                if (field.get(i).get(j) == 0) {
                    judge = java.lang.Boolean.FALSE
                    break
                }
            }
            if (judge) {
                delete_count++
                for (k in i downTo 3) {
                    System.arraycopy(field.get(k - 1), 0, field.get(k), 0, field.get(k).size)
                }
                i++
            }
            if (delete_count - check_delete_count == 10) {
                check_delete_count = delete_count
                level++
            }
            i--
        }
    }

    //指定したブロックをfieldから削除
    fun DrawDelete(target: Array<IntArray>, x: Int, y: Int) {
        for (i in -2..2) {
            for (j in -2..2) {
                if (target.get(i + 2).get(j + 2) != 0) {
                    field.get(x + i).set(y + j, 0)
                }
            }
        }
    }

    //左右移動の処理
    fun move(LR: Boolean) {
        DrawDelete(currentForm, currentX, currentY)
        if (LR) {
            currentY++
        } else {
            currentY--
        }
        if (!reflection(currentForm, currentX, currentY, java.lang.Boolean.TRUE)) {
            if (LR) {
                currentY--
            } else {
                currentY++
            }
            reflection(currentForm, currentX, currentY, java.lang.Boolean.TRUE)
        }
        underLocation()
    }

    //下瞬間移動した場合の位置をfieldに反映(このままいけばここに落ちるよ！っていう位置としてfieldに-1を入れる)
    fun underLocation() {
        val shadow = Array<IntArray>(5) { IntArray(5) }
        for (m in currentForm.indices) {
            for (n in 0 until currentForm.get(m).size) {
                if (currentForm.get(m).get(n) > 0) {
                    shadow[m][n] = -1
                }
            }
        }
        underComp(shadow)
        reflection(currentForm, currentX, currentY, java.lang.Boolean.TRUE)
    }

    //下瞬間移動のボタンを押した場合の処理
    fun under(): Boolean {
        underComp(currentForm)
        DeleteCheck()
        return if (newBlock()) {
            java.lang.Boolean.TRUE
        } else java.lang.Boolean.FALSE
    }

    fun underComp(comp: Array<IntArray>) {
        DrawDelete(currentForm, currentX, currentY)
        for (i in field.indices) {
            for (j in 0 until field.get(i).size) {
                if (field.get(i).get(j) == -1) {
                    field.get(i)[j] = 0
                }
            }
        }
        var x = currentX
        while (true) {
            x++
            if (!reflection(comp, x, currentY, java.lang.Boolean.FALSE)) {
                x--
                reflection(comp, x, currentY, java.lang.Boolean.TRUE)
                break
            }
        }
    }

    //回転の処理,LR=trueなら右，falseなら左
    fun rotation(LR: Boolean) {
        if (currentForm.get(2).get(2) == 6 || currentForm.get(2).get(2) == 12) {
            return
        }
        val newBlock = Array<IntArray>(5) { IntArray(5) }
        for (i in currentForm.indices) {
            for (j in currentForm.indices.reversed()) {
                newBlock[i][j] = currentForm.get(j).get(i)
            }
        }

        if (LR) {
            var temp: Int
            for (k in 0..4) {
                var i = 0
                var j = 4
                while (i < 2) {
                    temp = newBlock[k].get(i)
                    newBlock[k][i] = newBlock[k].get(j)
                    newBlock[k][j] = temp
                    i++
                    j--
                }
            }
        } else {
            var temp: Int
            for (k in 0..4) {
                var i = 0
                var j = 4
                while (i < 2) {
                    temp = newBlock[i].get(k)
                    newBlock[i][k] = newBlock[j].get(k)
                    newBlock[j][k] = temp
                    i++
                    j--
                }
            }
        }

        DrawDelete(currentForm, currentX, currentY)
        val seq = intArrayOf(0, 1, -1, 2, -2)
        for (value in seq) {
            if (reflection(newBlock, currentX, currentY + value, java.lang.Boolean.TRUE)) {
                currentY += value
                currentForm = newBlock
                underLocation()
                return
            }
        }
        reflection(currentForm, currentX, currentY, java.lang.Boolean.TRUE)
        underLocation()
    }
}