package com.skh.appsghor.studentmanagement.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.skh.appsghor.studentmanagement.R;
import com.skh.appsghor.studentmanagement.ui.auth.reg.RegistrationDetailsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(getApplicationContext(), RegistrationDetailsActivity.class));
    }
}
