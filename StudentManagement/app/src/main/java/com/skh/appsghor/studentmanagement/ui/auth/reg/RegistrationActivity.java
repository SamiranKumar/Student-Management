package com.skh.appsghor.studentmanagement.ui.auth.reg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.skh.appsghor.studentmanagement.R;
import com.skh.appsghor.studentmanagement.ui.auth.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.skh.appsghor.studentmanagement.util.ViewUtil.getTextFormEditText;
import static com.skh.appsghor.studentmanagement.util.ViewUtil.setRequestFocus;


public class RegistrationActivity extends AppCompatActivity implements IViewRegistrationDetails {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.button_submit)
    Button button_submit;

    @BindView(R.id.button_login)
    Button button_login;


    @BindView(R.id.et_first_name)
    EditText et_first_name;
    @BindView(R.id.et_last_name)
    EditText et_last_name;

    @BindView(R.id.et_password)
    EditText et_password;
    @BindView(R.id.et_confirm_password)
    EditText et_confirm_password;

    private Activity activity;

    private IPresenterRegistration iPresenterRegistration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
        activity = this;
        iPresenterRegistration = new PresenterRegistration(this);
        iPresenterRegistration.setTittle();

        et_first_name.addTextChangedListener(textWatcher);
        et_last_name.addTextChangedListener(textWatcher);

        et_password.addTextChangedListener(textWatcher);
        et_confirm_password.addTextChangedListener(textWatcher);


        button_submit.setClickable(false);
        button_submit.setBackgroundResource(R.drawable.btn_submit_disabled_bg);

        setSubmitBtnEnableDisabled(true);

    }


    @Override
    public void setSubmitBtnEnableDisabled(boolean isActive) {
        if (isActive) {
            button_submit.setClickable(true);
            button_submit.setBackgroundResource(R.color.colorPrimary);
        } else {
            button_submit.setClickable(false);
            button_submit.setBackgroundResource(R.drawable.btn_submit_disabled_bg);
        }
    }

    @Override
    public void setTittle(String tittle) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);

    }

    @Override
    public void reSetInputField(String first_name, String last_name, String email, String password, String confirmPassword) {
        et_first_name.setText(first_name);
        et_last_name.setText(last_name);
        et_password.setText(password);
        et_confirm_password.setText(confirmPassword);
    }

    @Override
    public void setErrorFirstName(String message) {
        et_first_name.setError(message);
        setRequestFocus(et_first_name);
    }

    @Override
    public void setErrorLastName(String message) {
        et_last_name.setError(message);
        setRequestFocus(et_last_name);
    }


    @Override
    public void setErrorPassword(String message) {
        et_password.setError(message);
        setRequestFocus(et_password);
    }

    @Override
    public void setErrorConfirmPassword(String message) {
        et_confirm_password.setError(message);
        setRequestFocus(et_confirm_password);
    }

    @Override
    public void regSuccess(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
    }


    @OnClick(R.id.button_submit)
    void clickReg() {

        iPresenterRegistration.registrationUserDetailsWithReferral(
                getTextFormEditText(et_first_name),
                getTextFormEditText(et_last_name),
                getTextFormEditText(et_password),
                getTextFormEditText(et_confirm_password)
        );

    }


    @OnClick(R.id.button_login)
    void clickLogin() {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }


    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (et_first_name.getText().hashCode() == editable.hashCode()) {
                et_first_name.setError(null);

            } else if (et_last_name.getText().hashCode() == editable.hashCode()) {

                et_last_name.setError(null);
            } else if (et_password.getText().hashCode() == editable.hashCode()) {

                et_password.setError(null);

            } else if (et_confirm_password.getText().hashCode() == editable.hashCode()) {
                et_confirm_password.setError(null);

            }


        }
    };


    @Override
    public void showProgressBar() {


    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
