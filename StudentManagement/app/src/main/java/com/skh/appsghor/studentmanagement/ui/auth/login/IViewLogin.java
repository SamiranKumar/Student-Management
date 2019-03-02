package com.skh.appsghor.studentmanagement.ui.auth.login;


public interface IViewLogin {

    void setTittle(String tittle);

    void setSubmitBtnEnableDisabled(boolean isActive);

    void reSetInputField(String user_name, String password);

    void setErrorFirstName(String message);

    void setErrorPassword(String message);


    void regSuccess(String message);

    void showProgressBar();

    void hideProgressBar();

}
