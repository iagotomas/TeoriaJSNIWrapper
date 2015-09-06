package com.sinewavemultimedia.teoria;

import com.google.gwt.core.client.Callback;

public class NoteJsoTest extends AbstractGwtTestCase {

	
	public void testCreateNoteJso() {
	    addCallback(new Callback<Void,Exception>() {
			
			@Override
			public void onSuccess(Void result) {
				try{
					assertEquals("Scientific notation creation not working","a4", NoteJso.create("a4").toString(false));
				}
				catch(Exception e){
			        fail("Scientific notation creation not working:"+e.getMessage());
				}
				
				finishTest();
			}
			
			@Override
			public void onFailure(Exception reason) {
				assertNotNull(reason);
		        fail("Injection failed: " + reason.getMessage());
			}
		});
	}
	public void testNoteJsoFromKey() {
	    addCallback(new Callback<Void,Exception>() {
			
			@Override
			public void onSuccess(Void result) {
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
		});
	}
	public void testNoteJsoFromMIDI() {
	    addCallback(new Callback<Void,Exception>() {
			
			@Override
			public void onSuccess(Void result) {
				try{
					assertEquals("Note from MIDI number not working","e1", NoteJso.fromMIDI(28).toString(false));
				}
				catch(Exception e){
			        fail("Note from MIDI number not working:"+e.getMessage());
				}
				
				finishTest();
			}
			
			@Override
			public void onFailure(Exception reason) {
				assertNotNull(reason);
		        fail("Injection failed: " + reason.getMessage());
			}
		});
	}
	public void testNoteJsoFromString() {
	    addCallback(new Callback<Void,Exception>() {
			
			@Override
			public void onSuccess(Void result) {
				try{
					assertEquals("Note from string not working","a4", NoteJso.fromString("a4").toString(false));
				}
				catch(Exception e){
			        fail("Note from MIDI number not working:"+e.getMessage());
				}
				
				finishTest();
			}
			
			@Override
			public void onFailure(Exception reason) {
				assertNotNull(reason);
		        fail("Injection failed: " + reason.getMessage());
			}
		});
	}

}
