package com.example.weixin.vo;

public class Myvo {
private String content;
private String username;
private String img;
private String time;
public Myvo(String content, String username, String img, String time) {
	super();
	this.content = content;
	this.username = username;
	this.img = img;
	this.time = time;
}
public Myvo() {
	super();
}
@Override
public String toString() {
	return "Myvo [content=" + content + ", username=" + username + ", img="
			+ img + ", time=" + time + "]";
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}

}
