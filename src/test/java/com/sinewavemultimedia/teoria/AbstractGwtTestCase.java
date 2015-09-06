package com.sinewavemultimedia.teoria;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.junit.client.GWTTestCase;

public abstract class AbstractGwtTestCase extends GWTTestCase {

	protected static final int TEST_DELAY = 10000;

	protected String getScriptUrl() {
		// scriptUrl = "http://saebekassebil.github.io/teoria/teoria.js";
		return GWT.getHostPageBaseURL() + "node_modules/teoria/teoria.js";
	}

	@Override
	public String getModuleName() {
		return "com.sinewavemultimedia.Teoria";
	}

	protected void addCallback(Callback<Void, Exception> callback) {
		delayTestFinish(TEST_DELAY);
		ScriptInjector.fromUrl(getScriptUrl()).setWindow(ScriptInjector.TOP_WINDOW).setCallback(callback).inject();
	}
}
