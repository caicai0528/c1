package com.example.weixin.parser;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

import com.example.weixin.vo.Myvo;

public class GsonParser {
public static List<Myvo> getGson(String url){
	List<Myvo> list=new ArrayList<Myvo>();
	Myvo myvo=null;
	try{
		JSONObject j1=new JSONObject(url);
		JSONArray j2=j1.getJSONArray("data");
		for(int i=0;i<j2.length();i++){
		myvo=new Myvo();
		JSONObject j3=j2.getJSONObject(i);
		myvo =new Myvo();
		myvo.setContent(j3.getString("content"));
		myvo.setTime(j3.getString("created_at"));
		JSONObject j4=j3.getJSONObject("author");
		myvo.setUsername(j4.getString("username"));
		myvo.setImg(j4.getString("avatar"));
		list.add(myvo);
		}
		
		
	}catch(Exception e){
		e.printStackTrace();
	}
	Log.i("list",list+"");
	return list;
	
}
}
