package com.skh.appsghor.studentmanagement.ui.auth.reg;


public interface IPresenterRegistration {

    void setTittle();

    void registrationUserDetailsWithReferral(
            String first_name,
            String last_name,
            String password,
            String confirmPassword
    );
}
