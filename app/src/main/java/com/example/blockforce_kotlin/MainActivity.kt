package com.example.blockforce_kotlin

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var helper: ScoreDatabaseHelper? = null
    private val ScoreText: StringBuilder = StringBuilder()
    private val cols: Array<String> = arrayOf("Lines", "date", "Latest")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        helper = ScoreDatabaseHelper(this)
    }

    fun Start_onClick(view: View) {
        val i = Intent(this, Play::class.java)
        startActivityForResult(i, 1)
        overridePendingTransition(0, 0)
    }

    fun How_onClick(view: View) {
        val dialog: DialogFragment = HowToPlayDialog()
        dialog.show(supportFragmentManager, "dialog_how")
    }

    fun score_onClick(view: View) {
        ScoreText.setLength(0)
        helper?.getWritableDatabase().use { db ->
            db?.beginTransaction()
            val search = db?.query("score", cols, "Latest = ?", arrayOf<String?>("1"), null, null, null, null)
            if (search?.count != 0) {
                search?.moveToFirst()
                ScoreText.append("Latest score\nLines : ")?.append(search?.getString(0))?.append("   Date : ")?.append(search?.getString(1))?.append("\n\n")
                val cs = db?.query("score", cols, null, null, null, null, "Lines DESC", null)
                var eol = cs?.moveToFirst()
                while (eol!!) {
                    ScoreText.append("Lines : ")?.append(cs?.getString(0))?.append("   Date : ")?.append(cs?.getString(1))?.append("\n")
                    eol = cs?.moveToNext()
                }
                cs?.close()
            }
            search?.close()
            db?.setTransactionSuccessful()
            db?.endTransaction()
        }
        val dialog: DialogFragment = ScoreDialog(ScoreText!!)
        dialog.show(supportFragmentManager, "dialog_score")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        @SuppressLint("SimpleDateFormat") val df: DateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
        val date = df.format(Date(System.currentTimeMillis()))
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val Lines = data?.getIntExtra("Lines", 0)
            helper?.getWritableDatabase().use { db ->
                db?.beginTransaction()
                var cv = ContentValues()
                cv.put("Latest", 0)
                db?.update("score", cv, "Latest = 1", null)
                cv = ContentValues()
                cv.put("Lines", Lines)
                cv.put("date", date)
                cv.put("Latest", 1)
                db?.insertWithOnConflict("score", null, cv, SQLiteDatabase.CONFLICT_REPLACE)
                db?.setTransactionSuccessful()
                db?.endTransaction()
            }
            Toast.makeText(this, "Game Over !!  Lines $Lines", Toast.LENGTH_LONG).show()
        }
    }
}