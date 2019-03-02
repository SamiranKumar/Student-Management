package com.skh.appsghor.studentmanagement.ui.auth.reg;


public class PresenterRegistrationDetailsValidation {

    public static int PASSWORD_MIN_LENGTH = 4;
    public static int PASSWORD_MAX_LENGTH = 15;

    private static int mmnChar = PASSWORD_MIN_LENGTH + 1;

    public static String NAME_VALIDATION = "Please Provide Name";

    public static String GENDER_VALIDATION = "Please Provide Your Gender";
    public static String NOT_SAME_PASSWORD = "New Password & Confirm Password are Not Same!";
    public static String PASSWORD_PROVIDE = "Please Provide Password at last " + mmnChar + " char";
    public static String CONFIRM_PASSWORD_PROVIDE = "Please Provide Confirm Password at last " + mmnChar + " char";


    private IViewRegistrationDetails iViewRegistrationDetails;


    public PresenterRegistrationDetailsValidation(IViewRegistrationDetails iViewRegistrationDetails) {
        this.iViewRegistrationDetails = iViewRegistrationDetails;
    }

    public boolean registrationUserDtailsValidation(String first_name, String last_name, String password, String confirmPassword) {
        if (firstNameValidation(first_name) && lastNameValidation(last_name) &&
                passwordValidation(password) && confirmPasswordValidation(confirmPassword, password)) {
            return true;
        } else {
            iViewRegistrationDetails.hideProgressBar();
            return false;
        }

    }


    private boolean firstNameValidation(CharSequence text) {
        if (text.length() > 0) {
            return true;
        } else {
            iViewRegistrationDetails.setErrorFirstName(NAME_VALIDATION);
            return false;
        }
    }

    private boolean lastNameValidation(CharSequence text) {
        if (text.length() > 0) {
            return true;
        } else {
            iViewRegistrationDetails.setErrorLastName(NAME_VALIDATION);
            return false;

        }
    }


    private boolean passwordValidation(CharSequence text) {
        if (text.length() >= PASSWORD_MIN_LENGTH && text.length() <= PASSWORD_MAX_LENGTH) {
            return true;
        } else {
            iViewRegistrationDetails.setErrorPassword(PASSWORD_PROVIDE);
            return false;
        }
    }

    private boolean confirmPasswordValidation(String confirmPassword, String password) {
        if (confirmPassword.length() >= PASSWORD_MIN_LENGTH && confirmPassword.length() <= PASSWORD_MAX_LENGTH) {

            if (confirmPassword.equals(password)) {
                return true;
            } else {
                iViewRegistrationDetails.setErrorConfirmPassword(NOT_SAME_PASSWORD);
                return false;
            }
        } else {

            iViewRegistrationDetails.setErrorConfirmPassword(CONFIRM_PASSWORD_PROVIDE);
            return false;
        }
    }


}
