package com.sinewavemultimedia.teoria;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.junit.client.GWTTestCase;

public class NoteJsoTest extends GWTTestCase {

	private static final int TEST_DELAY = 10000;
	public void testNoteJso() {
	    delayTestFinish(TEST_DELAY);
	    String scriptUrl = GWT.getModuleBaseForStaticFiles() + "node_modules/teoria/teoria.js";
	    scriptUrl = "http://saebekassebil.github.io/teoria/teoria.js";
	    ScriptInjector.fromUrl(scriptUrl).setWindow(ScriptInjector.TOP_WINDOW).setCallback(new Callback<Void,Exception>() {
			
			@Override
			public void onSuccess(Void result) {
				try{
					assertEquals("Scientific notation creation not working","a4", NoteJso.create("a4").toString(false));
				}
				catch(Exception e){
			        fail("Scientific notation creation not working:"+e.getMessage());
				}
				try{
					assertEquals("Note from piano key number not working","c3", NoteJso.fromKey(28).toString(false));
				}
				catch(Exception e){
			        fail("Note from piano key number not working:"+e.getMessage());
				}
				
				finishTest();
			}
			
			@Override
			public void onFailure(Exception reason) {
				assertNotNull(reason);
		        fail("Injection failed: " + reason.getMessage());
			}
		}).inject();
	}

	public String getModuleName() {
		return "com.sinewavemultimedia.Teoria";
	}
}
