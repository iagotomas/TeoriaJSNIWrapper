package com.sinewavemultimedia.teoria;

import com.google.gwt.core.client.Callback;

public class IntervalJsoTest extends AbstractGwtTestCase {

	public void testBetweenNoteJsoNoteJso() {
		addCallback(new Callback<Void, Exception>() {

			@Override
			public void onSuccess(Void result) {
				try {
					assertEquals("Interval between notes not working", 2, IntervalJso.between(NoteJso.create("a"), NoteJso.create("c'")).coord().get(0));
				} catch (Exception e) {
					fail("Interval between notes not working:" + e.getMessage());
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


	public void testCreateFromString() {
		addCallback(new Callback<Void, Exception>() {

			@Override
			public void onSuccess(Void result) {
				try {
					assertEquals("Interval from string not working", "m7b5", IntervalJso.create("m7b5").coordAsString());
				} catch (Exception e) {
					fail("Interval from string not working:" + e.getMessage());
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

	public void testCreateFromNoteJsoNoteJso() {
		addCallback(new Callback<Void, Exception>() {

			@Override
			public void onSuccess(Void result) {
				try {
					assertEquals("Interval from note to note not working", 2, IntervalJso.create(NoteJso.create("a4"), NoteJso.create("g5")).coord().get(0));
				} catch (Exception e) {
					fail("Interval from note to note not working:" + e.getMessage());
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

	public void testInvertString() {
		addCallback(new Callback<Void, Exception>() {

			@Override
			public void onSuccess(Void result) {
				try {
					assertEquals("Interval invert from string not working","dd6", IntervalJso.invert("AA3"));
				} catch (Exception e) {
					fail("Interval invert from string not working:" + e.getMessage());
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

	public void testInvert() {
		addCallback(new Callback<Void, Exception>() {

			@Override
			public void onSuccess(Void result) {
				try {
					assertEquals("Interval invert not working", -2, IntervalJso.create("b5").invert().coord().get(0));
				} catch (Exception e) {
					fail("Interval invert not working:" + e.getMessage());
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
