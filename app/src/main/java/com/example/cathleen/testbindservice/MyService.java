package com.example.cathleen.testbindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG="myServiceTag";
    public MyService() {
    }

    private LocalBinder myBinder=new LocalBinder();

     public class LocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }
    //加法
    public int add(int x,int y){
        return x+y;
    }
    //减法
    public int sub(int x,int y){
        return x-y;
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.v(TAG, "onBind()");
        return myBinder;
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.v(TAG, "onUnbind()");
        return super.onUnbind(intent);
    }
}
