package com.sinewavemultimedia.teoria;

import com.google.gwt.core.client.JavaScriptObject;
import com.sinewavemultimedia.teoria.interfaces.Interval;

public class IntervalJso extends JavaScriptObject implements Interval {

	protected IntervalJso() {
	}
	/**
	 * Returns the inversion of the interval provided represented as a string.<br/> <br/>
	 * Examples:<br/>
	 * 'm3' = minor third<br/>
	 * 'P4' = perfect fourth<br/>
	 * 'A4' = augmented fifth<br/>
	 * 'd7' = diminished seventh<br/>
	 * 'M6' = major sixth.<br/>
	 * 'm' = minor, 'M' = major, 'A' = augmented and 'd' = diminished<br/>
	 *<br/>
	 * The number may be prefixed with a <b>'-'</b> to signify that its direction is down. <br/>
	 * E.g.:<br/>
 	 * m-3 means a descending minor third, and P-5 means a descending perfect fifth.<br/>
 	 * 
	 * @param simpleInterval An interval represented in simple string form.
	 * @return the inversion of the interval provided
	 */
	public static native IntervalJso invert(String simpleInterval)/*-{
		return $wnd.teoria.Interval.invert(simpleInterval);
	}-*/;
	/**
	 * Returns an interval object which represents the interval between two notes.
	 * from and to are two Notes which are the notes that the interval is measured from.<br/> 
	 * For example if 'a' and 'c' are given, the resulting interval object would represent a minor third.<br/>
	 * <code>
	 * Interval.between(teoria.note("a"), teoria.note("c'")) -> teoria.interval('m3')
	 * </code> 
	 * @param from The Note which is the start of the measuring
	 * @param to The Note which is the end of the measuring
	 * @return an interval object which represents the interval between two notes.
	 */
	public static native IntervalJso between(NoteJso from,NoteJso to) /*-{
		return $wnd.teoria.Interval.between(from,to);
	}-*/;
	/**
	 * Returns an interval object which represents the interval between two notes.
	 * from and to are two Notes which are the notes that the interval is measured from.<br/> 
	 * For example if 'a' and 'c' are given, the resulting interval object would represent a minor third.<br/>
	 * <code>
	 * Interval.between(teoria.note("a"), "c'") -> teoria.interval('m3')
	 * </code> 
	 * @param from The Note which is the start of the measuring
	 * @param to The Note which is the end of the measuring
	 * @return an interval object which represents the interval between two notes.
	 */
	public static native NoteJso between(NoteJso from,String to) /*-{
		return $wnd.teoria.Interval.between(from,to);
	}-*/;
	
	/**
	 * Returns a note which is a given interval away from a root note. 
	 * @param from The Note which is the root of the measuring
	 * @param to A Interval
	 * @return a note which is a given interval away from a root note.
	 */
	public static native IntervalJso from(NoteJso from,IntervalJso to)/*-{
		return $wnd.teoria.Interval.from(from,to);
	}-*/;
	/**
	 * Returns a Interval representing the interval expressed in string form.
	 * @param from the interval to transform
	 * @return interval expressed in string form.
	 */
	public static native String toCoord(IntervalJso from) /*-{
		return $wnd.teoria.toCoord(from);
	}-*/;

	/**
	 * TODO
	 * @param note
	 * @param coord
	 * @return
	 */
	public static native NoteJso create(NoteJso note,String coord ) /*-{
		return new $wnd.teoria.interval(note,coord);
	}-*/;
	/**
	 * TODO
	 * @param from
	 * @param to
	 * @return
	 */
	public static native IntervalJso create(NoteJso from,NoteJso to ) /*-{
		return new $wnd.teoria.interval(from,to);
	}-*/;

	/**
	 * A representation of a music interval
	 * @param coord the string representation of the Interval
	 * @return the interval instance
	 */
	public static native IntervalJso create(String coord ) /*-{
		return $wnd.teoria.Interval(coord);
	}-*/;
	@Override
	public final native String coord() /*-{
		return this.coord;
	}-*/;
	@Override
	public final native int number() /*-{
		return this.number();
	}-*/;

	@Override
	public final native int value() /*-{
		return this.value();
	}-*/;

	@Override
	public final native String base() /*-{
		return this.base();
	}-*/;

	@Override
	public final native String type() /*-{
		return this.type();
	}-*/;

	@Override
	public final native String quality(boolean verbose) /*-{
		return this.quality(verbose);
	}-*/;

	@Override
	public final native String direction() /*-{
		return this.direction();
	}-*/;

	@Override
	public final native void setDirection(String dir) /*-{
		this.direction(dir);
	}-*/;

	@Override
	public final native int semitones() /*-{
		return this.semitones();
	}-*/;

	@Override
	public final native String simple(boolean ignoreDirection) /*-{
		return this.simple(ignoreDirection);
	}-*/;

	@Override
	public final native int octaves() /*-{
		return this.octaves();
	}-*/;

	@Override
	public final native boolean isCompound() /*-{
		return this.isCompound();
	}-*/;

	@Override
	public final IntervalJso add(Interval interval) {
		return _add(interval.toJavaScriptObject());
	};
	protected final native IntervalJso _add(JavaScriptObject interval) /*-{
		return this.add(interval);
	}-*/;

	@Override
	public final boolean equal(Interval interval) {
		return _equal(interval.toJavaScriptObject());
	}
	protected final native boolean _equal(JavaScriptObject interval) /*-{
		return this.equal(interval);
	}-*/;

	@Override
	public final boolean greater(Interval interval) {
		return _greater(interval.toJavaScriptObject());
	}
	protected final native boolean _greater(JavaScriptObject interval) /*-{
		return this.greater(interval);
	}-*/;

	@Override
	public final boolean smaller(Interval interval) {
		return _smaller(interval.toJavaScriptObject());
	}
	protected final native boolean _smaller(JavaScriptObject interval) /*-{
		return this.smaller(interval);
	}-*/;

	@Override
	public final native Interval invert() /*-{
		return this.invert();
	}-*/;

	@Override
	public final JavaScriptObject toJavaScriptObject() {
		return this;
	}

}
