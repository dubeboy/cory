package za.co.dubedivine.androidapps.cory.feature.extension

import android.app.Activity
import android.content.DialogInterface
import com.google.android.material.dialog.MaterialAlertDialogBuilder

private fun Activity.createDialog() {

}

fun Activity.showDialog(title: String, message: String) {
    MaterialAlertDialogBuilder(this)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton("Ok") { dialog, _ ->
            dialog.dismiss()
        }
        .show();
}
