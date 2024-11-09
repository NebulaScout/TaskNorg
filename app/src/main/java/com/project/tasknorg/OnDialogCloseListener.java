package com.project.tasknorg;

import android.content.DialogInterface;

public interface OnDialogCloseListener {

    // Notify other components(activities and fragments) when a dialog has been closed
    void onDialogClose(DialogInterface dialogInterface);
}
