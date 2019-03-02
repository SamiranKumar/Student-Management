package com.skh.appsghor.studentmanagement.ui.auth.reg;


import com.skh.appsghor.studentmanagement.db.IUserDao;
import com.skh.appsghor.studentmanagement.db.StudentManagementDB;
import com.skh.appsghor.studentmanagement.db.entity.User;
import com.skh.appsghor.studentmanagement.util.UserType;

import static com.skh.appsghor.studentmanagement.util.LogUtil.logPrint;

public class PresenterRegistration implements IPresenterRegistration {

    private IViewRegistrationDetails iViewRegistrationDetails;
    private PresenterRegistrationValidation presenterRegistrationValidation;
    private final IUserDao iUserDao;

    public PresenterRegistration(IViewRegistrationDetails iViewRegistrationDetails) {
        this.iViewRegistrationDetails = iViewRegistrationDetails;
        presenterRegistrationValidation = new PresenterRegistrationValidation(iViewRegistrationDetails);
        iUserDao = StudentManagementDB.getDatabase().iUserDao();

    }

    @Override
    public void setTittle() {
        iViewRegistrationDetails.setTittle("User Registration");
    }


    @Override
    public void registrationUserDetailsWithReferral(String first_name, String last_name, String password, String confirmPassword) {
        iViewRegistrationDetails.showProgressBar();


        logPrint("first_name :" + " " + first_name);
        logPrint("last_name :" + " " + last_name);
        logPrint("password :" + " " + password);
        logPrint("confirmPassword :" + " " + confirmPassword);


        if (!presenterRegistrationValidation.registrationUserDtailsValidation(
                first_name, last_name, password, confirmPassword)) {
            return;
        }

        long count = iUserDao.countUsers();

        String userName = first_name + "_" + count;
        String fullNAme = first_name + " " + last_name;
        String rollNo = (count + 100) + "";

        //User user = new User(userName, password, UserType.U_STUDENT.name());
        User user = new User(userName, password, UserType.U_STUDENT.name(), fullNAme, rollNo);

        long isInsert = iUserDao.insert(user);

        if (isInsert > 0) {

            iViewRegistrationDetails.regSuccess("Complete Your Registration! Your User Name is:" + userName);
            logPrint("isInsert: SUCCESS >> " + isInsert);
            logPrint("User SUCCESS >> " + user);
        }

    }

}
