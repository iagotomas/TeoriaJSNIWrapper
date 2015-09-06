package com.sinewavemultimedia.teoria;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.JsArrayInteger;


public class ScaleJsoTest extends AbstractGwtTestCase{

  public void testCreateFromNoteJsoString() {
	  addCallback(new Callback<Void, Exception>() {
		
		@Override
		public void onSuccess(Void result) {
			try {
				assertEquals("Scale creation from note and scale not working","major", ScaleJso.create(NoteJso.create("a4"), "major").name());
			} catch (Exception e) {
				fail("Scale creation from note and scale not working:" + e.getMessage());
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

  private static native JsArrayInteger createScaleArray()/*-{
  	return [0,1,0,1];
  }-*/;
  public void testCreateFromNoteJsoJsArrayInteger() {
	  addCallback(new Callback<Void, Exception>() {
		
		@Override
		public void onSuccess(Void result) {
			try {
				assertEquals("Scale creation from note and scale not working",null, ScaleJso.create(NoteJso.create("a4"), createScaleArray()).name());
			} catch (Exception e) {
				fail("Scale creation from note and scale not working:" + e.getMessage());
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
