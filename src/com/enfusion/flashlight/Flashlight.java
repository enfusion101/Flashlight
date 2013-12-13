package com.enfusion.flashlight;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.util.Log;

public class Flashlight {
	
	boolean flashLightOn = false;
	private Camera camera = null;
	private Parameters params = null;	
	
	public Flashlight()
	{
		if(camera == null)
		{
			try
			{
				camera = Camera.open();		
				params = camera.getParameters();
			}
			catch(RuntimeException e)
			{
				Log.e("Camera Error could not open", e.getMessage());
			}			
		}		
	}
	
	public void turnOnFlash()
	{
		if(camera != null && params != null)
		{
			params.setFlashMode(Parameters.FLASH_MODE_TORCH);
			camera.setParameters(params);
			camera.startPreview();
			flashLightOn = true;
		}		
	}
	
	public void turnOffFlash()
	{
		if(camera != null && params != null)
		{
			camera.stopPreview();
			flashLightOn = false;
		}
	}
	
	public void restoreLastState()
	{
		if(flashLightOn)
		{
			turnOnFlash();
		}
	}
	
	public void releaseCamera()
	{
		if(camera != null)
		{
			camera.release();
			camera = null;		
		}
	}

}
