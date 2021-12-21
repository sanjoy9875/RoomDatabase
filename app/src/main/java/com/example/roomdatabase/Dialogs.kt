package com.example.roomdatabase

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.content.res.AppCompatResources

class Dialogs {

    fun showDialog(context: Context){
        val builder = AlertDialog.Builder(context)
        val view = LayoutInflater.from(context)
            .inflate(R.layout.bottom_dialog_layout,null)

        builder.setView(view)
        val dialog = builder.create()
        dialog.window?.setBackgroundDrawable(
            AppCompatResources.getDrawable(
                context,
                R.drawable.dialog_shape
            )
        )
        val window = dialog.window
        val layoutParams = window?.attributes
        layoutParams?.gravity = Gravity.BOTTOM
        window?.attributes = layoutParams
        dialog.show()
    }

}