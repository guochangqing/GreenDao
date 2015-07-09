package com.example.greenandroidc;

import java.util.List;

import com.greenimitation.entity.DaoSession;
import com.greenimitation.entity.Text;
import com.greenimitation.entity.TextDao;

import android.content.Context;

public class DBService {

	private static DBService instance;
	private static Context appContext;
	private DaoSession mDaoSession;
	private TextDao mTextDao;
	
	private DBService(){}
	
	public static DBService getInstance(Context context){
		if(instance == null){
			instance = new DBService();
			if(appContext == null){
				appContext = context.getApplicationContext();
			}
			instance.mDaoSession = BaseApplication.getDaoSession(context);
//			instance.mTextDao = instance.mDaoSession.getTextDao();
		}
		return instance;
	}
	//add single data
	public long saveText(Text text){
		
		return mTextDao.insert(text);
	}
	//add multis data
	public void saveTextLists(List<Text> list){
		if(list != null ){
				for(int i=0;i<list.size();i++){
					Text text = list.get(i);
					mTextDao.insertOrReplace(text);
				}
			}
	}
	//query data 
	public List<Text> loadText(String where,String... params){
		
		return mTextDao.queryRaw(where, params);
	}
	
	//query all data
	//--->TextDao create getList();
	public List<Text> loadTextAll(){
		
		return mTextDao.loadAll();
	}
	public Text loadText(long id){
		return mTextDao.loadByRowId(id);
	}
	//delete all data 
	public void deleteText(){
		mTextDao.deleteAll();
	}
	//delete condition data
	public void deleteText(Text text){
		mTextDao.delete(text);
	}
	
}
