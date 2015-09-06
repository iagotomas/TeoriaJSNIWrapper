package com.sinewavemultimedia.teoria;

import com.google.gwt.core.client.Callback;

public class ChordJsoTest extends AbstractGwtTestCase {

	
	public void testCreateChordJso() {
	    addCallback(new Callback<Void,Exception>() {
			
			@Override
			public void onSuccess(Void result) {
				try{
					assertEquals("Chord creation from Note,chord not working","Am7b5", ChordJso.create(NoteJso.create("a4"), "m7b5").name());
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
		});
	}
	public void testChordJsoFromName() {
	    addCallback(new Callback<Void,Exception>() {
			
			@Override
			public void onSuccess(Void result) {
				try{
					assertEquals("Scientific notation creation not working","Ab#5b9", ChordJso.chord("Ab#5b9").toString());
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

	public void testChordJsoFromNote() {
	    addCallback(new Callback<Void,Exception>() {
			
			@Override
			public void onSuccess(Void result) {
				try{
					assertEquals("Chord creation from Note not working","Eb", ChordJso.chord(NoteJso.create("Eb4")).name());
				}
				catch(Exception e){
			        fail("Chord creation from Note not working:"+e.getMessage());
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
	public void testChordJsoFromNoteAndSymbol() {
	    addCallback(new Callback<Void,Exception>() {
			
			@Override
			public void onSuccess(Void result) {
				try{
					assertEquals("Chord creation from Note,symbol not working","Eb6", ChordJso.chord(NoteJso.create("Eb4"),"6").name());
				}
				catch(Exception e){
			        fail("Chord creation from Note,symbol not working"+e.getMessage());
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
	public void testChordJsoFromNameAndOctave() {
	    addCallback(new Callback<Void,Exception>() {
			
			@Override
			public void onSuccess(Void result) {
				try{
					assertEquals("Chord creation from name,octave not working","Ab7", ChordJso.chord("Ab7",6).name());
				}
				catch(Exception e){
			        fail("Chord creation from name,octave not working"+e.getMessage());
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
