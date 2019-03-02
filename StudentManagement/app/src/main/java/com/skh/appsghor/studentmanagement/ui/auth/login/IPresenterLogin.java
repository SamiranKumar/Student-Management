package com.skh.appsghor.studentmanagement.ui.auth.login;


public interface IPresenterLogin {

    void setTittle();

    void registrationUserDetailsWithReferral(
            String user_name,
            String password

    );
}
