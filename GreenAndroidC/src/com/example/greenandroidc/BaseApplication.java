package com.example.greenandroidc;

import com.greenimitation.entity.DaoMaster;
import com.greenimitation.entity.DaoMaster.OpenHelper;
import com.greenimitation.entity.DaoSession;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {

	private BaseApplication mApplication;
	private static DaoMaster mDaoMaster;
	private static DaoSession mDaoSession;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		if(mApplication == null){
			mApplication = this;
		}
	}
	//好好学习
	public static DaoMaster getDaoMaster(Context context){
		if(mDaoMaster == null){
			//create database
			//获取Master对象
			OpenHelper helper = new DaoMaster.DevOpenHelper(context, "text", null);
			mDaoMaster = new DaoMaster(helper.getWritableDatabase());
		}
		return mDaoMaster;
	}
	
	public static DaoSession getDaoSession(Context context){
		if(mDaoSession == null){
			if(mDaoMaster == null){
				getDaoMaster(context);
			}
			mDaoSession = mDaoMaster.newSession();
		}
		
		return mDaoSession;
	}
}
