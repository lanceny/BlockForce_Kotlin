package com.example.blockforce_kotlin

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class HowToPlayDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        return builder.setTitle(resources.getString(R.string.how_to_play))
                .setMessage(resources.getString(R.string.explain))
                .setNeutralButton("Cancel"
                ) { dialog, which -> }
                .create()
    }
}