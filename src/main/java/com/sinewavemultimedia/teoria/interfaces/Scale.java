package com.sinewavemultimedia.teoria.interfaces;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A scale object (teoria.Scale), The scale object is a powerful presentation of a scale, which
 * supports quite a few handy methods. A scale can either be constructed from the predefined scales,
 * which by default contains the 7 modes (Ionian, Dorian, Phrygian etc.) a major and minor
 * pentatonic and the harmonic chromatic scale or from an arbitrary array of intervals. The scale
 * object also supports solfège, which makes it perfect for tutorials on sight-reading.
 * 
 * @author iago
 *
 */
public interface Scale {
	JavaScriptObject toJavaScriptObject();

	/**
	 * Returns a list of Notes which is the scale's notes
	 * 
	 * @return a list of Notes
	 */
	List<Note> notes();

	/**
	 * The name of the scale (if available). Type string or null
	 * 
	 * @return
	 */
	String name();

	/**
	 * The Note which is the scale's tonic
	 * 
	 * @return the Note which is the scale's tonic
	 */
	Note tonic();

	/**
	 * Returns a list of only the notes' names, not the full Note objects.
	 * 
	 * @return a list of notes names
	 */
	List<String> simple();

	/**
	 * Returns the type of the scale, depending on the number of notes.<br/>
	 * A scale of length x gives y:<br/>
	 * 2 gives 'ditonic'<br/>
	 * 3 gives 'tritonic'<br/>
	 * 4 gives 'tetratonic'<br/>
	 * 5 gives 'pentatonic'<br/>
	 * 6 gives 'hexatonic'<br/>
	 * 7 gives 'heptatonic'<br/>
	 * 8 gives 'octatonic'
	 * 
	 * @return the type of the scale
	 */
	String type();

	/**
	 * Returns the note at the given scale index
	 * 
	 * @param index a number referring to the scale step
	 * @return the note at the given scale index
	 */
	Note get(int index);

	/**
	 * Returns the note at the given scale index
	 * 
	 * @param step the name (string) of the scale step. E.g. 'first', 'second', 'fourth', 'seventh'.
	 * @return the note at the given scale index
	 */
	Note get(String step);

	/**
	 * Returns the solfege name of the given scale step
	 * 
	 * @param index a number referring to the scale step
	 * @param showOctaves If set to true, a "Helmholtz-like" notation will be used if there's bigger
	 *            intervals than an octave
	 * @return the solfege name of the given scale step
	 */
	String solfege(int index, boolean showOctaves);

	/**
	 * Returns the solfege name of the given scale step
	 * 
	 * @param step the name (string) of the scale step. E.g. 'first', 'second', 'fourth', 'seventh'.
	 * @param showOctaves If set to true, a "Helmholtz-like" notation will be used if there's bigger
	 *            intervals than an octave
	 * @return the solfege name of the given scale step
	 */
	String solfege(String step, boolean showOctaves);
	
	/**
	 * 
	 * @param interval
	 * @return
	 */
	Scale interval(String interval);
	/**
	 * 
	 * @param interval
	 * @return
	 */
	Scale interval(Interval interval);
}
