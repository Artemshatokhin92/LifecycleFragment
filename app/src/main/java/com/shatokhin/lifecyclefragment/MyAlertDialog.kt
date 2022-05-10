package com.shatokhin.lifecyclefragment

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class MyAlertDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = activity?.let { AlertDialog.Builder(it) }

        builder?.setMessage("This dialog is intended for testing LifeCycle")
            ?.setPositiveButton("OK") { dialog, id -> }

        return builder?.create() ?: throw IllegalStateException("Activity cannot be null")
    }
}