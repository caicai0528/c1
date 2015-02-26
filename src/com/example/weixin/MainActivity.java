package com.example.weixin;

import http.HttpClientJson;

import java.util.List;

import org.xml.sax.Parser;

import util.NetWork;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

import com.example.adapter.MyAdapter;
import com.example.weixin.parser.GsonParser;
import com.example.weixin.vo.Myvo;

public class MainActivity extends Activity {
	ListView lv;
	Handler hand;
	List<Myvo> list;
	MyAdapter ma;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv=(ListView) findViewById(R.id.main_listview);
		 hand=new Handler(){

				@Override
				public void handleMessage(Message msg) {
					// TODO Auto-generated method stub
					super.handleMessage(msg);
					if(msg.what==11){
						ma=new MyAdapter(MainActivity.this, list);
						lv.setAdapter(ma);
					}
				}
	        };
	        new Thread(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					super.run();
					if(NetWork.isNetavable(MainActivity.this)){
						String url="http://192.172.10.5:8080/app/new.json";
						String in=HttpClientJson.getJson(url);
						
						Log.i("mainactivityÀïµÄurl",url);
						try{
							list=GsonParser.getGson(in);
							Message msg=hand.obtainMessage(11,list);
							hand.sendMessage(msg);
						}catch(Exception e){
							e.printStackTrace();
						}
					}else{
						hand.sendEmptyMessage(22);
					}
				}
	        	
	        }.start();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
