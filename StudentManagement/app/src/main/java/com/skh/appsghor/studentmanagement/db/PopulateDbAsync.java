package com.skh.appsghor.studentmanagement.db;

import android.os.AsyncTask;

import static com.skh.appsghor.studentmanagement.util.LogUtil.logPrint;


public class PopulateDbAsync extends AsyncTask<Void, Void, Void> {


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


        return null;
    }


}