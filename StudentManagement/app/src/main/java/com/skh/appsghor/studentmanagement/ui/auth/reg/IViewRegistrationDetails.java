package com.skh.appsghor.studentmanagement.ui.auth.reg;


public interface IViewRegistrationDetails {

    void setTittle(String tittle);

    void setSubmitBtnEnableDisabled(boolean isActive);

    void reSetInputField(String first_name, String last_name, String email, String password, String confirmPassword);

    void setErrorFirstName(String message);

    void setErrorLastName(String message);

    void setErrorPassword(String message);

    void setErrorConfirmPassword(String message);

    void showProgressBar();

    void hideProgressBar();

}
