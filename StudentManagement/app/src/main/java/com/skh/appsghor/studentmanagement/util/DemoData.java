package com.skh.appsghor.studentdemotest.util;

import com.skh.appsghor.studentdemotest.db.entity.User;

public class DemoData {

    private static String adminUsarName = "SM_ADMIN";
    private static String adminPassword = "123456";

    public static User getDemoAdmin() {
        User user = new User(adminUsarName, adminPassword, UserType.U_ADMIN.name());

        return user;
    }
}
