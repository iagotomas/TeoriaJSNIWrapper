package com.sinewavemultimedia.teoria;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayString;
import com.sinewavemultimedia.teoria.interfaces.Interval;
import com.sinewavemultimedia.teoria.interfaces.Note;
import com.sinewavemultimedia.teoria.interfaces.Scale;

public class ScaleJso extends JavaScriptObject implements Scale {

	protected ScaleJso() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Create a teoria representation of a scale, with a given tonic.<br/> 
	 * The scales supported by default are:<br/>
	 * <ul>
	 * <li>major </li>
	 * <li>minor </li>
	 * <li>ionian (Alias for major)</li>
	 * <li>dorian</li>
	 * <li>phrygian</li>
	 * <li>lydian</li>
	 * <li>mixolydian</li>
	 * <li>aeolian (Alias for minor)</li>
	 * <li>locrian</li>
	 * <li>majorpentatonic</li>
	 * <li>minorpentatonic</li>
	 * <li>chromatic</li>
	 * <li>harmonicchromatic (Alias for chromatic)</li>
	 * <li>blues</li>
	 * <li>doubleharmonic</li>
	 * <li>flamenco</li>
	 * <li>harmonicminor</li>
	 * <li>melodicminor</li>
	 * </ul>
	 * 
	 * 
	 * @param tonic A Note which is to be the tonic of the scale
	 * @param scale a name of a scale
	 * @return representation of a scale, with a given tonic
	 */
	public static native ScaleJso create(NoteJso tonic,String scale) /*-{
		return new $wnd.teoria.scale(tonic,scale);
	}-*/;
	/**
	 * Create a teoria representation of a scale, with a given tonic.
	 * @param tonic A Note which is to be the tonic of the scale
	 * @param scale an array of absolute intervals that defines the scale
	 * @return representation of a scale, with a given tonic
	 */
	public static native ScaleJso create(NoteJso tonic,JsArrayInteger scale) /*-{
		return new $wnd.teoria.scale(tonic,scale);
	}-*/;
	@Override
	public final JavaScriptObject toJavaScriptObject() {
		return this;
	}

	@Override
	public final List<Note> notes() {
		ArrayList<Note> out = new ArrayList<Note>();
		JsArray<NoteJso> notes = _notes();
		for(int i=0;i<notes.length();i++){
			out.add(notes.get(i));
		}
		return out;
	}
	protected final native JsArray<NoteJso> _notes() /*-{
		return this.notes();
	}-*/;

	@Override
	public final native String name() /*-{
		return this.name;
	}-*/;

	@Override
	public final native NoteJso tonic() /*-{
		return this.tonic;
	}-*/;
	@Override
	public final List<String> simple() {
		ArrayList<String> out = new ArrayList<String>();
		JsArrayString notes = _simple();
		for(int i=0;i<notes.length();i++){
			out.add(notes.get(i));
		}
		return out;
	}
	protected final native JsArrayString _simple() /*-{
		return this.simple();
	}-*/;

	@Override
	public final native String type() /*-{
		return this.type();
	}-*/;

	@Override
	public final native NoteJso get(int index) /*-{
		return this.get(index);
	}-*/;

	@Override
	public final native NoteJso get(String step) /*-{
		return this.get(step);
	}-*/;

	@Override
	public final native String solfege(int index, boolean showOctaves) /*-{
		return this.solfege(index,showOctaves);
	}-*/;

	@Override
	public final Scale interval(Interval interval) {
		return _interval(interval.toJavaScriptObject());
	}
	protected final native ScaleJso _interval(JavaScriptObject o)/*-{
		return this.interval(o);
	}-*/;
	@Override
	public final native ScaleJso interval(String interval) /*-{
		return this.interval(interval);
	}-*/;
	@Override
	public final native String solfege(String step, boolean showOctaves) /*-{
		return this.solfege(step,showOctaves);
	}-*/;

}
