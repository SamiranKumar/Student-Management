package com.skh.appsghor.studentmanagement.ui.auth.login;


import static com.skh.appsghor.studentmanagement.ui.auth.reg.PresenterRegistrationValidation.PASSWORD_MAX_LENGTH;
import static com.skh.appsghor.studentmanagement.ui.auth.reg.PresenterRegistrationValidation.PASSWORD_MIN_LENGTH;
import static com.skh.appsghor.studentmanagement.ui.auth.reg.PresenterRegistrationValidation.PASSWORD_PROVIDE;

public class PresenterLoginValidation {


    public static String User_NAME_VALIDATION = "Please Provide Your Valid User Name!";

    private IViewLogin iViewLogin;


    public PresenterLoginValidation(IViewLogin iViewLogin) {
        this.iViewLogin = iViewLogin;
    }

    public boolean loginUserValidation(String user_name, String password) {
        if (userNameValidation(user_name) && passwordValidation(password)) {
            return true;
        } else {
            iViewLogin.hideProgressBar();
            return false;
        }

    }


    private boolean userNameValidation(CharSequence text) {
        if (text.length() > 0) {
            return true;
        } else {
            iViewLogin.setErrorFirstName(User_NAME_VALIDATION);
            return false;
        }
    }


    private boolean passwordValidation(CharSequence text) {
        if (text.length() >= PASSWORD_MIN_LENGTH && text.length() <= PASSWORD_MAX_LENGTH) {
            return true;
        } else {
            iViewLogin.setErrorPassword(PASSWORD_PROVIDE);
            return false;
        }
    }

}
