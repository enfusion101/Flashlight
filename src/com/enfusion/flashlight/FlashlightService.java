package com.enfusion.flashlight;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class FlashlightService extends Service {

	//Create a binder so that the service can bind to an activity
	//You can then call methods within this service
	private final IBinder flashlightBinder = new FlashlightBinder();
	
	public class FlashlightBinder extends Binder 
	{
		FlashlightService getService()
		{
			return FlashlightService.this;			
		}
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return flashlightBinder;
	}
	
	
	//Service states
	Flashlight flashlight;
	
	
	public void onCreate()
	{
		flashlight = new Flashlight();
		Toast.makeText(this, "Service created", Toast.LENGTH_LONG).show();
	}
	
	public void onDestroy()
	{
		Toast.makeText(this, "Service destroyed", Toast.LENGTH_LONG).show();
	}
	
	public int onStartCommand(Intent intent, int flags, int startid)
	{
		Toast.makeText(this, "Service started by user", Toast.LENGTH_LONG).show();
		return Service.START_STICKY;
	}
	
	public void turnOnFlash()
	{
		flashlight.turnOnFlash();
	}
	
	

}
