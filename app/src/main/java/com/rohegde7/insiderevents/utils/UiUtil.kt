package com.rohegde7.insiderevents.utils

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.os.Looper
import android.view.View

object UiUtil {

    private var dialog: ProgressDialog? = null

    fun displayProgress(context: Context, msg: String?) {
        // This has been called from worker thread
        if (Looper.myLooper() != Looper.getMainLooper()) return

        hideProgress()

        if (context is Activity) {
            val activity = context as Activity

            if (activity.isDestroyed || activity.isFinishing) return

            dialog = ProgressDialog(context, ProgressDialog.THEME_HOLO_LIGHT)

            dialog?.apply {
                isIndeterminate = true
                setCancelable(false)
                setMessage(msg)
                show()
            }
        }
    }

    fun hideProgress() {

        if (dialog != null && dialog!!.isShowing) {
            val window = dialog!!.window ?: return
            val decor: View = window.decorView

            if (decor.getParent() != null) {
                dialog!!.dismiss()
                dialog = null
            }
        }
    }
}