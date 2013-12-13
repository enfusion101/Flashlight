package com.enfusion.flashlight;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);       
		Intent bindIntent = new Intent(this, FlashlightService.class);
        bindService(bindIntent, flashlightServiceConnection, Context.BIND_AUTO_CREATE);
        startService(new Intent(this, FlashlightService.class));        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    
    //Connect to the FlashlightService
    private FlashlightService flashlightServiceRef;
    
    private ServiceConnection flashlightServiceConnection = new ServiceConnection() {
    	public void onServiceConnected(ComponentName className, IBinder service)
    	{
    		flashlightServiceRef = ((FlashlightService.FlashlightBinder)service).getService();
    		flashlightServiceRef.turnOnFlash();
    	}
    	
    	public void onServiceDisconnected(ComponentName className)
    	{
    		flashlightServiceRef = null;
    	}
    };
    
    
}
