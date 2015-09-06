package com.sinewavemultimedia.teoria;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.sinewavemultimedia.teoria.interfaces.Interval;
import com.sinewavemultimedia.teoria.interfaces.Note;
import com.sinewavemultimedia.teoria.interfaces.Scale;

public class NoteJso extends JavaScriptObject implements Note {

	protected NoteJso() {
	}
	/**
	 * Returns a Note instance
	 * @param coord a coord array
	 * @return a note instance
	 */
	public static native NoteJso create(JsArrayString coord) /*-{
		return $wnd.teoria.note(coord);
	}-*/;
	/**
	 * Returns a Note instance
	 * @param coord a coord array
	 * @param duration object argument. The object has two also optional parameters:<br/>
     * &nbsp;&nbsp;&nbsp;value - A number corresponding to the value of the duration, such that: 1 = whole, 2 = half (minim), 4 = quarter, 8 = eight<br/>
     * &nbsp;&nbsp;&nbsp;dots - The number of dots attached to the note. Defaults to 0.<br/>
	 * @return a note instance
	 */
	public static native NoteJso create(JsArrayString coord,JavaScriptObject duration) /*-{
		return $wnd.teoria.note(coord,duration);
	}-*/;
	/**
	 * Returns a Note instance
	 * @param name The name argument is the note name as a string. The note can both be expressed in scientific and 
	 *  Helmholtz notation. Some examples of valid note names: Eb4, C#,,, C4, d#'', Ab2
	 * @return a note instance
	 */
	public static native NoteJso create(String name) /*-{
			return $wnd.teoria.note(name);
	}-*/;
	/**
	 * A static method that returns an instance of Note set to the note at the given piano key, where A0 is key number 1. See Wikipedia's piano key article for more information.
	 * @param name the note at the given piano key
	 * @return an instance of Note
	 */
	public static native NoteJso fromKey(int name) /*-{
		return $wnd.teoria.note.fromKey(name);
	}-*/;
	/**
	 * A static method returns an object containing two elements:<br/>
	 * note - A Note which corresponds to the closest note with the given frequency<br/>
	 * cents - A number value of how many cents the note is out of tune<br/>
	 * @param fq a frequency
	 * @return a javascript object containing 2 keys, 'note' and 'cents'
	 */
	public static native JavaScriptObject fromFrequency(String fq) /*-{
		return $wnd.teoria.note.fromKey(name);
	}-*/;
	/**
	 * Returns an instance of Note set to the corresponding MIDI note value.
	 * @param note A number ranging from 0-127 representing a MIDI note value
	 * @return an instance of Note
	 */
	public static native NoteJso fromMIDI(int note) /*-{
		return $wnd.teoria.note.fromMIDI(note);
	}-*/;
	/**
	 * Returns an instance of Note representing the note name
	 * @param note The name argument is the note name as a string. The note can both be expressed in scientific and Helmholtz notation. Some examples of valid note names: Eb4, C#,,, C4, d#'', Ab2
	 * @return an instance of Note
	 */
	public static native NoteJso fromString(String note) /*-{
		return $wnd.teoria.note.fromString(note);
	}-*/;
	
	@Override
	public final native String name() /*-{
		return this.name();
	}-*/;

	@Override
	public final native int octave()  /*-{
		return this.octave();
	}-*/;

	/**
	 * @see #create(JsArrayString, JavaScriptObject)
	 */
	@Override
	public final native JavaScriptObject duration() /*-{
		return this.duration();
	}-*/;

	@Override
	public final native String accidental() /*-{
		return this.accidental();
	}-*/;

	@Override
	public final native int accidentalValue() /*-{
		return this.accidentalValue();
	}-*/;

	@Override
	public final native int key(boolean whitenotes) /*-{
		return this.key(whitenotes);
	}-*/;

	@Override
	public final native int midi() /*-{
		return this.midi();
	}-*/;

	@Override
	public final native int fq(int concertPitch) /*-{
		return this.fq(concertPitch);
	}-*/;
	@Override
	public final native int fq() /*-{
		return this.fq();
	}-*/;

	@Override
	public final native int chroma() /*-{
		return this.chroma();
	}-*/;

	@Override
	public final native ScaleJso scale(String scaleName) /*-{
		return this.scale(scaleName);
	}-*/;

	@Override
	public final native NoteJso interval(String interval) /*-{
		return this.interval(interval);
	}-*/;
	@Override
	public final Interval interval(Note interval)  {
		return _interval(interval.toJavaScriptObject());
	}
	protected final native IntervalJso _interval(JavaScriptObject interval)  /*-{
		return this.interval(interval);
	}-*/;

	@Override
	public final Interval transpose(Interval interval) {
		return _transpose(interval.toJavaScriptObject());
	}
	protected final native IntervalJso _transpose(JavaScriptObject interval)  /*-{
		return this.transpose(interval);
	}-*/;

	@Override
	public final native ChordJso chord(String name) /*-{
		return name!==null?this.chord(name):this.chord();
	}-*/;

	@Override
	public final native String helmholtz() /*-{
		return this.helmholtz();
	}-*/;

	@Override
	public final native String scientific() /*-{
		return this.scientific();
	}-*/;

	@Override
	public final native String enharmonics(boolean oneAccidental) /*-{
		return this.enharmonics(oneAccidental);
	}-*/;

	@Override
	public final native int durationInSeconds(int bpm, int beatUnit) /*-{
		return this.durationInSeconds(bpm,beatUnit);
	}-*/;

	public final int solfege(Scale scale, boolean showOctaves) {
		return _solfege(scale.toJavaScriptObject(),showOctaves);
	}
	protected final native int _solfege(JavaScriptObject scale, boolean showOctaves) /*-{
		return this.solfege(scale,showOctaves);
	}-*/;

	@Override
	public final native String durationName() /*-{
		return this.durationName();
	}-*/;

	@Override
	public final int scaleDegree(Scale scale) {
		return _scaleDegree(scale.toJavaScriptObject());
	}
	protected final native int _scaleDegree(JavaScriptObject scale) /*-{
		return this.scaleDegree(scale);
	}-*/;

	@Override
	public final native String toString(boolean dontShow) /*-{
		return this.toString(dontShow);
	}-*/;

	@Override
	public final JavaScriptObject toJavaScriptObject() {
		return this;
	}
}
