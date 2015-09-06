package com.sinewavemultimedia.teoria;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.sinewavemultimedia.teoria.interfaces.Chord;
import com.sinewavemultimedia.teoria.interfaces.Interval;
import com.sinewavemultimedia.teoria.interfaces.Note;



public class ChordJso extends JavaScriptObject implements Chord {

	protected ChordJso(){
		
	}
	/**
	 * A simple function for getting the notes, no matter the octave, in a chord
	 * @param name A string containing the full chord symbol, with note name. Examples: 'Ab7', 'F#(#11b5)'
	 * @return the Chord instance
	 */
	public static native ChordJso chord(String name) /*-{
		return $wnd.teoria.chord(name);
	}-*/;
	/**
	 * A simple function for getting the notes, no matter the octave, in a chord
	 * @param name A string containing the full chord symbol, with note name. Examples: 'Ab7', 'F#(#11b5)'
	 * @param octave octave number of the root.
	 * @return the Chord instance
	 */
	public static native ChordJso chord(String name,int octave) /*-{
		return $wnd.teoria.chord(name,octave);
	}-*/;

	/**
	 * A simple function for getting the notes, no matter the octave, in a chord
	 * @param note The note will be considered root in the new chord object
	 * @return the Chord instance
	 */
	public static native ChordJso chord(NoteJso note) /*-{
		return $wnd.teoria.chord(note);
	}-*/;
	/**
	 * A simple function for getting the notes, no matter the octave, in a chord
	 * @param note The note will be considered root in the new chord object
	 * @param symbol string containing the chord symbol (excluding the note name)
	 * @return the Chord instance
	 */
	public static native ChordJso chord(NoteJso note,String symbol) /*-{
		return $wnd.teoria.chord(note,symbol);
	}-*/;
	/**
	 * Create a chord class with a lot of functionality to alter and analyze the chord.
	 * @param root A Note instance which is to be the root of the chord
	 * @param chord A string containing the chord symbol. This can be anything from simple chords, to super-advanced jazz chords thanks to the detailed and robust chord parser engine. Example values: 'm', 'm7', '#5b9', '9sus4 and '#11b5#9'
	 * @return Chord instance
	 */
	public static native ChordJso create(NoteJso root,String chord)/*-{
		return $wnd.teoria.Chord(root,chord);
	}-*/;
	@Override
	public final native String name() /*-{
		return this.name;
	}-*/;

	@Override
	public final native NoteJso root() /*-{
		return this.root;
	}-*/;

	@Override
	public final List<Note> notes() {
		JsArray<NoteJso> notes = _notes();
		ArrayList<Note> out = new ArrayList<Note>();
		for(int index=0;index<notes.length();index++){
			out.add(notes.get(index));
		}
		return out;
	}
	private final native JsArray<NoteJso> _notes() /*-{
		return this.notes();
	}-*/;

	@Override
	public final String[] simple() {
		JsArrayString data = _simple();
		String[] out = new String[data.length()];
		for(int index=0;index<data.length();index++){
			out[index] = data.get(index);
		}
		return out;
	}
	private final native JsArrayString _simple() /*-{
		return this.simple();
	}-*/;

	@Override
	public final native NoteJso bass() /*-{
		return this.bass();
	}-*/;

	@Override
	public final List<Interval> voicing() {
		JsArray<IntervalJso> data = _voicing(null);
		ArrayList<Interval> out = new ArrayList<Interval>();
		for(int index=0;index<data.length();index++){
			out.add(data.get(index));
		}
		return out;
	}

	private final native JsArray<IntervalJso> _voicing(String[] intervals) /*-{
		return interval!==null?this.voicing(intervals):this.voicing();
	}-*/;
	@Override
	public final void voicing(List<String> intervals) {
		_voicing(intervals.toArray(new String[0]));
	}

	@Override
	public final native String quality() /*-{
		return this.quality();
	}-*/;

	@Override
	public final native String dominant(String additional) /*-{
		return additional!==null?this.dominant(additional):this.dominant();
	}-*/;

	@Override
	public final native String subdominant(String additional) /*-{
		return additional!==null?this.subdominant(additional):this.subdominant();
	}-*/;

	@Override
	public final native String parallel(String additional) /*-{
		return additional!==null?this.parallel(additional):this.parallel();
	}-*/;


	@Override
	public final native String chordType() /*-{
		return this.chordType();
	}-*/;

	@Override
	public final ChordJso interval(Interval interval) {
		return _interval(interval.toJavaScriptObject());
	}
	private final native ChordJso _interval(JavaScriptObject o) /*-{
		return this.interval(o);
	}-*/;

	@Override
	public final ChordJso transpose(Interval interval) {
		return _transpose(interval.toJavaScriptObject());
	}
	private final native ChordJso _transpose(JavaScriptObject o) /*-{
		return this.transpose(o);
	}-*/;
	@Override
	public final JavaScriptObject toJavaScriptObject() {
		return this;
	}

}
