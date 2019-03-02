package com.skh.appsghor.studentmanagement.ui.auth.reg;


import static com.skh.appsghor.studentmanagement.util.LogUtil.logPrint;

public class PresenterRegistrationDetails implements IPresenterRegistrationDetails {

    private IViewRegistrationDetails iViewRegistrationDetails;
    private PresenterRegistrationDetailsValidation presenterRegistrationDetailsValidation;

    public PresenterRegistrationDetails(IViewRegistrationDetails iViewRegistrationDetails) {
        this.iViewRegistrationDetails = iViewRegistrationDetails;
        presenterRegistrationDetailsValidation = new PresenterRegistrationDetailsValidation(iViewRegistrationDetails);
    }

    @Override
    public void setTittle() {
        iViewRegistrationDetails.setTittle("User Registration");
    }



    @Override
    public void registrationUserDetailsWithReferral(String first_name, String last_name,  String password, String confirmPassword) {
        iViewRegistrationDetails.showProgressBar();


        logPrint("first_name :" + " " + first_name);
        logPrint("last_name :" + " " + last_name);
        logPrint("password :" + " " + password);
        logPrint("confirmPassword :" + " " + confirmPassword);


        if (!presenterRegistrationDetailsValidation.registrationUserDtailsValidation(
                first_name, last_name, password, confirmPassword)) {
            return;
        }




    }

}
