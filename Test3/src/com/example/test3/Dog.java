package com.example.test3;

import android.util.Log;

public class Dog {

	private int legs;
	private String color;
	public Dog(int legs, String color) {
		super();
		this.legs = legs;
		this.color = color;
	}
	
	private ListenerOne mListenerOne;
	
	public interface ListenerOne{
		public int getLegs(int legs);
	}
	
	public void setListener(ListenerOne listener){
		mListenerOne = listener;
	}
	
	
	
	public void invoke(){
		if(mListenerOne!=null){
			Log.i("debug", "no null");
			mListenerOne.getLegs(1000);
		}else{
			Log.i("debug", "null");
		}
	}
}
