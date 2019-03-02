package com.skh.appsghor.studentmanagement.util;
import com.skh.appsghor.studentmanagement.db.entity.User;

public class DemoData {

    private static String adminUserName = "SM_ADMIN";
    private static String adminPassword = "123456";

    public static User getDemoAdmin() {
        User user = new User(adminUserName, adminPassword, UserType.U_ADMIN.name());

        return user;
    }
}
