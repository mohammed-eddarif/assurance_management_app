package com.example.login_app.loginRegister.helpers;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;



import java.util.regex.Pattern;

public class InputValidationDem
{
    private Context context;
    public InputValidationDem(Context context) {
        this.context = context;
    }

    public boolean isInputEditTextFilledDem(EditText editText, String message) {
        String string = editText.getText().toString().trim();

        if(TextUtils.isEmpty(string)) {
            editText.setError(message);

            return false;
        }
        return true;
    }

    public boolean isValidMobile(EditText editText, String message) {
        String phone = editText.getText().toString();
        boolean check=false;
        if(!Pattern.matches("[a-zA-Z]+", phone)) {
            if(phone.length() < 6 || phone.length() > 13) {
                // if(phone.length() != 10) {
                check = false;
                editText.setError(message);
                hideKeyboardFrom(editText);
            } else {
                check = true;
            }
        } else {
            check=false;
        }
        return check;
    }
    private void hideKeyboardFrom(View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}

