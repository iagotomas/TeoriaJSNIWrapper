package com.sinewavemultimedia.teoria;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.junit.client.GWTTestCase;

public class ChordJsoTest extends GWTTestCase {

	private static final int TEST_DELAY = 10000;

	public void testChordJso() {
	    delayTestFinish(TEST_DELAY);
	    String scriptUrl = GWT.getModuleBaseForStaticFiles() + "node_modules/teoria/teoria.js";
	    scriptUrl = "http://saebekassebil.github.io/teoria/teoria.js";
	    ScriptInjector.fromUrl(scriptUrl).setWindow(ScriptInjector.TOP_WINDOW).setCallback(new Callback<Void,Exception>() {
			
			@Override
			public void onSuccess(Void result) {
				NoteJso a4 = NoteJso.create("a4");
				try{
					assertEquals("Scientific notation creation not working","Ab#5b9", ChordJso.chord("Ab#5b9").toString());
				}
				catch(Exception e){
			        fail("Scientific notation creation not working:"+e.getMessage());
				}
				try{
					assertEquals("Chord creation from Note not working","Eb", ChordJso.chord(NoteJso.create("Eb4")).name());
				}
				catch(Exception e){
			        fail("Chord creation from Note not working:"+e.getMessage());
				}
				try{
					assertEquals("Chord creation from Note,symbol not working","Eb6", ChordJso.chord(NoteJso.create("Eb4"),"6").name());
				}
				catch(Exception e){
			        fail("Chord creation from Note,symbol not working"+e.getMessage());
				}
				try{
					assertEquals("Chord creation from name,octave not working","Ab7", ChordJso.chord("Ab7",6).name());
				}
				catch(Exception e){
			        fail("Chord creation from name,octave not working"+e.getMessage());
				}
				try{
					assertEquals("Chord creation from Note,chord not working","Am7b5", ChordJso.create(a4, "m7b5").name());
				}
				catch(Exception e){
			        fail("Chord creation from Note,chord not working"+e.getMessage());
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
