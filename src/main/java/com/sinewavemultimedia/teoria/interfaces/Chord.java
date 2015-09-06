package com.sinewavemultimedia.teoria.interfaces;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A chord object (teoria.Chord), which understands everything from simple major/minor chords to
 * advanced Jazz chords (Ab#5b9, F(#11) and such)
 * 
 * @author iago
 *
 */
public interface Chord {
	JavaScriptObject toJavaScriptObject();

	/**
	 * Returns the full chord symbol, inclusive the root name.
	 * 
	 * @return the full chord symbol
	 */
	String name();

	/**
	 * Returns the Note that is the root of the chord.
	 * 
	 * @return the Note that is the root of the chord
	 */
	Note root();

	/**
	 * Returns a list of Notes that the chord consists of.
	 * 
	 * @return a list of Notes
	 */
	List<Note> notes();

	/**
	 * Returns an Array of only the notes' names, not the full Note objects.
	 * 
	 * @return an Array of only the notes' names
	 */
	String[] simple();

	/**
	 * Returns the bass note of the chord (The note voiced the lowest)
	 * 
	 * @return the bass note of the chord
	 */
	Note bass();

	/**
	 * The current voicing is returned as an array of Intervals
	 * 
	 * @return an array of Intervals
	 */
	List<Interval> voicing();

	/**
	 * Sets the current voicing of the chord<br/>
	 * Here's an example: <br/>
	 * <code>
	 * var bbmaj = teoria.chord('Bbmaj7');<br/> 
	 * // Default voicing: <br/>
	 * bbmaj.voicing(); // #-> ['P1', 'M3', 'P5', 'M7'];<br/> 
	 * bbmaj.notes(); // #-> ['bb', 'd', 'f', 'a'];<br/>
	 * <br/>
	 * // New voicing<br/> 
	 * bbmaj.voicing(['P1', 'P5', 'M7', 'M10']);<br/> 
	 * bbmaj.notes(); // #-> ['bb', 'f', 'a', 'd']; <br/>
	 * </code> NB: Note that above returned
	 * results are pseudo-results, as they will be returned wrapped in Interval and Note objects.
	 * 
	 * @param intervals An array of intervals in simple-format that represents the current voicing
	 *            of the chord.
	 */
	void voicing(List<String> intervals);

	/**
	 * Returns a string which holds the quality of the chord, 'major', 'minor', 'augmented',
	 * 'diminished', 'half-diminished', 'dominant' or undefined Chord#get(interval)
	 * 
	 * @return a string which holds the quality of the chord
	 */
	String quality();

	/**
	 * Returns the naïvely chosen dominant which is a perfect fifth away.
	 * 
	 * @param additional Additional chord extension or null, for example: 'b9' or '#5'
	 * @return the naïvely chosen dominant
	 */
	String dominant(String additional);

	/**
	 * 
	 * Returns the naïvely chosen subdominant which is a perfect fourth away.
	 * 
	 * @param additional Like the dominant's.
	 * @return the naïvely chosen subdominant
	 */
	String subdominant(String additional);

	/**
	 * Returns the parallel chord for major and minor triads
	 * 
	 * @param additional Like the dominant's
	 * @return the parallel chord for major and minor triads
	 */
	String parallel(String additional);

	/**
	 * Returns the type of the chord: 'dyad', 'triad', 'trichord', 'tetrad' or 'unknown'.
	 * 
	 * @return the type of the chord
	 */
	String chordType();

	/**
	 * Returns the same chord, a interval away
	 * 
	 * @param interval the interval
	 * @return the same chord, a interval away
	 */
	Chord interval(Interval interval);

	/**
	 * Like the #interval method, except it's this chord that gets changed instead of returning a
	 * new chord.
	 * 
	 * @param interval the interval
	 * @return the transposed Chord
	 */
	Chord transpose(Interval interval);

	/**
	 * Simple usability function which is an alias for Chord.name
	 * 
	 * @return the Chord's name
	 */
	String toString();
}
