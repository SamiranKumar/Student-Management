package com.skh.appsghor.studentmanagement.util;

import android.widget.EditText;

public class ViewUtil {
    public static String getTextFormEditText(EditText editText) {
        return editText.getText().toString().trim();
    }

    public static void setRequestFocus(EditText editText) {
        editText.requestFocus();

    }
}
