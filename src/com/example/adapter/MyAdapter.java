package com.example.adapter;

import java.util.List;

import com.example.weixin.R;
import com.example.weixin.vo.Myvo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{
	Context context;
	List<Myvo> list;
	Helper h;
	
	public MyAdapter(Context context, List<Myvo> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View v, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(v==null){
			h=new Helper();
			v=LayoutInflater.from(context).inflate(R.layout.activity_find, null);
			h.content=(TextView) v.findViewById(R.id.find_content);
			h.img=(ImageView) v.findViewById(R.id.find_img);
			h.time=(TextView) v.findViewById(R.id.find_time);
			h.username=(TextView) v.findViewById(R.id.find_username);
			v.setTag(h);
		}
		h=(Helper) v.getTag();
		h.content.setText(list.get(position).getContent());
		h.time.setText(list.get(position).getTime());
		h.username.setText(list.get(position).getUsername());
		return v;
	}
	class Helper{
		public View context;
		TextView username,content,time;
		ImageView img;
	}

}
