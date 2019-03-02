package com.skh.appsghor.studentmanagement.ui.auth.login;


import com.skh.appsghor.studentmanagement.db.IUserDao;
import com.skh.appsghor.studentmanagement.db.StudentManagementDB;
import com.skh.appsghor.studentmanagement.db.entity.User;

import static com.skh.appsghor.studentmanagement.util.LogUtil.logPrint;

public class PresenterLogin implements IPresenterLogin {

    private IViewLogin iViewLogin;
    private PresenterLoginValidation presenterLoginValidation;
    private final IUserDao iUserDao;

    public PresenterLogin(IViewLogin iViewLogin) {
        this.iViewLogin = iViewLogin;
        presenterLoginValidation = new PresenterLoginValidation(iViewLogin);
        iUserDao = StudentManagementDB.getDatabase().iUserDao();

    }

    @Override
    public void setTittle() {
        iViewLogin.setTittle("User Registration");
    }


    @Override
    public void registrationUserDetailsWithReferral(String user_name, String password) {
        iViewLogin.showProgressBar();


        logPrint("user_name :" + " " + user_name);
        logPrint("password :" + " " + password);


        if (!presenterLoginValidation.loginUserValidation(
                user_name, password)) {
            return;
        }

        User user = iUserDao.findUserByNamePass(user_name, password);
        if (user != null) {

            iViewLogin.regSuccess("Login successfully!");
            logPrint("isInsert: SUCCESS >> " + user);
            logPrint("User SUCCESS >> " + user);
        }

    }

}
