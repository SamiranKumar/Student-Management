package com.skh.appsghor.studentmanagement.ui.auth.login;

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
import com.skh.appsghor.studentmanagement.ui.auth.reg.RegistrationActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.skh.appsghor.studentmanagement.util.ViewUtil.getTextFormEditText;
import static com.skh.appsghor.studentmanagement.util.ViewUtil.setRequestFocus;


public class LoginActivity extends AppCompatActivity implements IViewLogin {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.button_submit)
    Button button_submit;

    @BindView(R.id.button_reg)
    Button button_reg;

    @BindView(R.id.et_first_name)
    EditText et_first_name;


    @BindView(R.id.et_password)
    EditText et_password;


    private Activity activity;

    private IPresenterLogin iPresenterLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        activity = this;
        iPresenterLogin = new PresenterLogin(this);
        iPresenterLogin.setTittle();

        et_first_name.addTextChangedListener(textWatcher);
        et_password.addTextChangedListener(textWatcher);
        
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
    public void reSetInputField(String user_name, String password) {
        et_first_name.setText(user_name);
        et_password.setText(password);

    }

    @Override
    public void setErrorFirstName(String message) {
        et_first_name.setError(message);
        setRequestFocus(et_first_name);
    }



    @Override
    public void setErrorPassword(String message) {
        et_password.setError(message);
        setRequestFocus(et_password);
    }


    @Override
    public void regSuccess(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
    }


    @OnClick(R.id.button_submit)
    void clickReg() {

        iPresenterLogin.registrationUserDetailsWithReferral(
                getTextFormEditText(et_first_name),
                getTextFormEditText(et_password)

        );

    }

    @OnClick(R.id.button_reg)
    void clickLogin() {
        startActivity(new Intent(getApplicationContext(), RegistrationActivity.class));
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

            }  else if (et_password.getText().hashCode() == editable.hashCode()) {
                et_password.setError(null);
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
