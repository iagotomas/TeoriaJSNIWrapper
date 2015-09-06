package com.sinewavemultimedia.teoria.interfaces;

import com.google.gwt.core.client.JavaScriptObject;
import com.sinewavemultimedia.teoria.NoteJso;

/**
 * A note object (teoria.Note), which understands alterations, octaves, key number, frequency and
 * etc. and Helmholtz notation
 * 
 * @author iago
 *
 */
public interface Note {
	JavaScriptObject toJavaScriptObject();

	/**
	 * The name of the note, in lowercase letter (only the name, not the accidental signs)
	 * 
	 * @return The name of the note
	 */
	String name();

	/**
	 * The numeric value of the octave of the note
	 * 
	 * @return The numeric value of the octave of the note
	 */
	int octave();

	/**
	 * The duration object with two optional properties:<br/>
	 * value - A number corresponding to the value of the duration, such that: 1 = whole, 2 = half
	 * (minim), 4 = quarter, 8 = eight<br/>
	 * dots - The number of dots attached to the note. Defaults to 0.<br/>
	 * 
	 * @return The duration object
	 */
	JavaScriptObject duration();

	/**
	 * Returns the string symbolic of the accidental sign (x, #, b or bb)
	 * 
	 * @return
	 */
	String accidental();

	/**
	 * Returns the numeric value (mostly used internally) of the sign: x = 2, # = 1, b = -1, bb = -2
	 * 
	 * @return
	 */
	int accidentalValue();

	/**
	 * Returns the piano key number. E.g. A4 would return 49
	 * 
	 * @param whitenotes If this parameter is set to true only the white keys will be counted when
	 *            finding the key number. This is mostly for internal use.
	 * @return the piano key number
	 */
	int key(boolean whitenotes);

	/**
	 * Returns a number ranging from 0-127 representing a MIDI note value
	 * 
	 * @return Returns a number ranging from 0-127
	 */
	int midi();

	/**
	 * Calculates and returns the frequency of the note.
	 * 
	 * @param concertPitch this number will be used instead of the normal concert
	 *            pitch which is 440hz. This is useful for some classical music.
	 * @return the frequency of the note.
	 */
	int fq(int concertPitch);
	/**
	 * Calculates and returns the frequency of the note.
	 * @return the frequency of the note.
	 */
	int fq();

	/**
	 * Returns the pitch class (index) of the note.<br/>
	 * This allows for easy enharmonic checking:<br/>
	 * <blockquote> <code>
	 * 	teoria.note('e').chroma() === teoria.note('fb').chroma();
	 * </code> </blockquote> The chroma number is ranging from pitch class C which is 0 to 11 which
	 * is B<br/>
	 * 
	 * @return The chroma number
	 */
	int chroma();

	/**
	 * Returns an instance of Scale, with the tonic/root set to this note.
	 * 
	 * @param scaleName The name of the scale to be returned. 'minor', 'chromatic', 'ionian' and
	 *            others are valid scale names.
	 * @return an instance of Scale, with the tonic/root set to this note.
	 */
	Scale scale(String scaleName);

	/**
	 * A sugar function for calling teoria.interval(note, interval); Look at the documentation for
	 * teoria.interval
	 * 
	 * @param interval the Interval instance
	 * @return a Note
	 */
	Note interval(String interval);
	/**
	 * A sugar function for calling teoria.interval(note, interval); Look at the documentation for
	 * teoria.interval
	 * 
	 * @param interval a Note instance
	 * @return an Interval instance with current Note
	 */
	Interval interval(Note interval);

	/**
	 * Like the #interval method, but changes this note, instead of returning a new
	 * 
	 * @param interval the Interval instance
	 * @return an Interval instance with current transposed Note
	 */
	Interval transpose(Interval interval);

	/**
	 * Returns an instance of Chord, with root note set to this note
	 * 
	 * @param name The name attribute is the last part of the chord symbol. Examples: 'm7', '#5b9',
	 *            'major'. If the name parameter is null, a standard major chord will be returned.
	 * @return
	 */
	Chord chord(String name);

	/**
	 * Returns the note name formatted in Helmholtz notation. Example: teoria.note('A5').helmholtz()
	 * -> "a''"
	 * 
	 * @return the note name formatted in Helmholtz notation.
	 */
	String helmholtz();

	/**
	 * Returns the note name formatted in scientific notation. Example:
	 * teoria.note("ab'").scientific() -> "Ab4"
	 * 
	 * @return the note name formatted in scientific notation.
	 */
	String scientific();

	/**
	 * Returns all notes that are enharmonic with the note <br/>
	 * teoria.note('c').enharmonics().toString(); <br/>
	 * // -> 'dbb, b#' <br/>
	 *
	 * teoria.note('c').enharmonics(true).toString(); <br/>
	 * // -> 'b#' <br/>
	 * 
	 * @param oneAccidental Boolean, if set to true, only enharmonic notes with one accidental is
	 *            returned. E.g. results such as 'eb' and 'c#' but not 'ebb' and 'cx'
	 * @return all notes that are enharmonic with the note
	 */
	String enharmonics(boolean oneAccidental);

	/**
	 * Returns the duration of the note, given a tempo (in bpm) and a beat unit (the lower numeral
	 * of the time signature)
	 * 
	 * @param bpm a tempo (in bpm)
	 * @param beatUnit a beat unit
	 * @return the duration of the note
	 */
	int durationInSeconds(int bpm, int beatUnit);

	/**
	 * Returns the solfege step in the given scale context
	 * 
	 * @param scale An instance of Scale, which is the context of the solfege step measuring
	 * @param showOctaves A boolean. If set to true, a "Helmholtz-like" notation will be used if
	 *            there's bigger intervals than an octave
	 * @return the solfege step in the given scale context
	 */
	int solfege(Scale scale, boolean showOctaves);

	/**
	 * Returns the duration name. Examples: teoria.note('A', 8).durationName() -> 'eighth',
	 * teoria.note('C', 16).durationName() -> 'sixteenth'
	 * 
	 * @return the duration name
	 */
	String durationName();

	/**
	 * Returns this note's degree in a given scale (Scale). For example a D in a C major scale will
	 * return 2 as it is the second degree of that scale. If however the note isn't a part of the
	 * scale, the degree returned will be 0, meaning that the degree doesn't exist. This allows this
	 * method to be both a scale degree index finder and an "isNoteInScale" method.
	 * 
	 * @param scale An instance of Scale which is the context of the degree measuring
	 * @return this note's degree in a given scale
	 */
	int scaleDegree(Scale scale);

	/**
	 * Usability function for returning the note as a string
	 * 
	 * @param dontShow If set to true the octave will not be included in the returned string.
	 * @return
	 */
	String toString(boolean dontShow);
}