package com.skh.appsghor.studentmanagement.db;

import android.os.AsyncTask;
import com.skh.appsghor.studentmanagement.util.DemoData;

import static com.skh.appsghor.studentmanagement.util.LogUtil.logPrint;


public class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final IUserDao iUserDao;

    public PopulateDbAsync(StudentManagementDB instance) {
        iUserDao = instance.iUserDao();
    }


    @Override
    protected void onPreExecute() {
        logPrint("Start.....");
    }

    @Override
    protected void onPostExecute(Void result) {
        logPrint("End.....");
    }


    @Override
    protected Void doInBackground(Void... voids) {

        iUserDao.deleteAll();

        long isInsert = iUserDao.insert(DemoData.getDemoAdmin());

        if (isInsert > 0) {
            logPrint("isInsert: SUCCESS >> " + isInsert);
        }


        return null;
    }
}