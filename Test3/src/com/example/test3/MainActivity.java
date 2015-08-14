package com.example.test3;

import java.util.ArrayList;
import java.util.List;

import com.example.test3.Dog.ListenerOne;

import android.os.Bundle;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity  {

	private Button mButton;
	private Dog mdog;
//	private ListenerOne mlistener;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mdog = new Dog(5, "black");
		
		mdog.setListener(listener);
		mButton=(Button) findViewById(R.id.btn);
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//			  mdog.invoke();
				getAllTasks(MainActivity.this);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private ListenerOne listener = new ListenerOne() {
		
		@Override
		public int getLegs(int legs) {
			Log.i("debug", "leg:"+legs);
			mButton.setText("legs:"+legs);
			return 0;
		}
	};
	
	 public static void getAllTasks(Context ctx) {
		 String packagename;
		 String name;
	        PackageManager pm = ctx.getPackageManager();
	        List<PackageInfo> infos = pm.getInstalledPackages(0);
	        for(int i=0;i<infos.size();i++){
	        	packagename=infos.get(i).packageName;
	        	name = infos.get(i).applicationInfo.loadLabel(pm).toString();
	        	Log.i("debug", "packagename:"+packagename+" appname:"+name);
	        }
	        
	    }
	 
//	@Override
//	public int getLegs(int legs) {
//		Log.i("debug", "leg:"+legs);
//		mButton.setText("legs:"+legs);
//		return 0;
//	}

}
