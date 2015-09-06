package com.sinewavemultimedia.teoria.interfaces;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * An interval object (teoria.Interval), which makes it easy to find the interval between two notes,
 * or find a note that is a given interval from a note. There's also support for counting the
 * interval span in semitones and inverting the interval.
 * 
 * @author iago
 *
 */
public interface Interval {
	JavaScriptObject toJavaScriptObject();

	/**
	 * The interval representation of the interval
	 * 
	 * @return the interval representation of the interval
	 */
	String coord();

	/**
	 * The interval number (A ninth = 9, A seventh = 7, fifteenth = 15)
	 * 
	 * @return The interval number
	 */
	int number();

	/**
	 * The value of the interval - That is a ninth = 9, but a downwards ninth is = -9
	 * 
	 * @return The value of the interval
	 */
	int value();

	/**
	 * Returns the simpleInterval representation of the interval. E.g. 'P5', 'M3', 'A9', etc.
	 * 
	 * @return the simpleInterval representation of the interval
	 */
	String toString();

	/**
	 * Returns the name of the simple interval (not compound)
	 * 
	 * @return the name of the simple interval (not compound)
	 */
	String base();

	/**
	 * Returns the type of array, either 'perfect' (1, 4, 5, 8) or 'minor' (2, 3, 6, 7)
	 * 
	 * @return the type of array
	 */
	String type();

	/**
	 * The quality of the interval ('dd', 'd' 'm', 'P', 'M', 'A' or 'AA')
	 * 
	 * @param verbose if is set to a truish value, then long quality names are returned: 'doubly
	 *            diminished', 'diminished', 'minor', etc.
	 * @return The quality of the interval
	 */
	String quality(boolean verbose);

	/**
	 * The direction of the interval
	 * 
	 * @return the interval's direction which is either 'up' or 'down'
	 */
	String direction();

	/**
	 * Set the direction of the interval
	 * 
	 * @param dir the interval's direction which is either 'up' or 'down'
	 */
	void setDirection(String dir);

	/**
	 * Returns the number of semitones the interval span.
	 * 
	 * @return the number of semitones the interval span.
	 */
	int semitones();

	/**
	 * Returns the simple part of the interval as a Interval Example: <code>

 teoria.interval('M17').simple();    // #-> 'M3'
 teoria.interval('m23').simple();    // #-> 'm2'
 teoria.interval('P5').simple();     // #-> 'P5'
 teoria.interval('P-4').simple();    // #-> 'P-4'

 // With ignoreDirection = true
 teoria.interval('M3').simple(true);     // #->'M3'
 teoria.interval('m-10').simple(true);   // #-> 'm3'
 NB: Note that above returned results are pseudo-results, as they will be returned wrapped in Interval objects.
 </code>
	 * 
	 * @param ignoreDirection if set to true, returns the "direction-agnostic" interval. That is the
	 *            interval with a positive number.
	 * @return
	 */
	String simple(boolean ignoreDirection);

	/**
	 * Returns the number of compound intervals
	 * 
	 * @return the number of compound intervals
	 */
	int octaves();

	/**
	 * Returns a boolean value, showing if the interval is a compound interval
	 * 
	 * @return a boolean value, showing if the interval is a compound interval
	 */
	boolean isCompound();

	/**
	 * Adds the interval to this interval, and returns a Interval representing the result of the
	 * addition
	 * 
	 * @param interval the interval to add
	 * @return a Interval representing the result of the addition
	 */
	Interval add(Interval interval);

	/**
	 * Returns true if the supplied interval is equal to this interval
	 * 
	 * @param interval the interval to compare
	 * @return true if the supplied interval is equal to this interval
	 */
	boolean equal(Interval interval);

	/**
	 * Returns true if the supplied interval is greater than this interval
	 * 
	 * @param interval the interval to compare
	 * @return true if the supplied interval is greater than this interval
	 */
	boolean greater(Interval interval);

	/**
	 * Returns true if the supplied interval is smaller than this interval
	 * 
	 * @param interval the interval to compare
	 * @return true if the supplied interval is smaller than this interval
	 */
	boolean smaller(Interval interval);

	/**
	 * Returns the inverted interval as a Interval
	 * 
	 * @return the inverted interval as a Interval
	 */
	Interval invert();
}
