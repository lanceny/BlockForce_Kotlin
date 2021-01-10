package com.example.blockforce_kotlin

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ScoreDialog(private val ScoreText: StringBuilder) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        return builder.setTitle("Score")
                .setMessage(ScoreText)
                .setNeutralButton("Cancel"
                ) { dialog, which -> }
                .create()
    }
}