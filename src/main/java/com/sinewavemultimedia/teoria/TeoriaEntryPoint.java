package com.sinewavemultimedia.teoria;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.user.client.Window;





/*
 * Example on how https://github.com/saebekassebil/teoria JSNI wrapper works
 */
public class TeoriaEntryPoint implements EntryPoint {

	private void printArray(List<String> data){
		String out = "";
		for(String value:data){
			out += ("".equals(out)?"":",")+value;
		}
		printOut("["+out+"]");
	}
	private void printOut(String msg){
		Window.alert(msg);
	}
	@Override
	public void onModuleLoad() {
		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			@Override
			public void onUncaughtException(Throwable e) {
				GWT.log("Unknown error",e);
			}
		});
		// Create notes:
		/*
		var a4 = teoria.note('a4');       // Scientific notation
		var g5 = teoria.note("g''");      // Helmholtz notation
		var c3 = teoria.note.fromKey(28); // From a piano key number
		*/
		NoteJso a4 = NoteJso.create("a4");
		printOut(a4.name()+" fq "+a4.fq());
		NoteJso g5 = NoteJso.create("g''");
		printOut(g5.name()+" fq "+g5.fq());
		NoteJso c3 = NoteJso.fromKey(28);
		printOut(c3.name()+" fq "+c3.fq());
		// Find and create notes based on intervals
		/*
		teoria.interval(a4, g5);    // Returns a Interval object representing a minor seventh
		teoria.interval(a4, 'M6');  // Returns a Note representing F#5
		a4.interval('m3');          // Returns a Note representing C#4
		a4.interval(g5);            // Returns a Interval object representing a minor seventh
		a4.interval(teoria.note('bb5')).invert(); // Returns a Interval representing a major seventh
		 */
		printOut(IntervalJso.create(a4, g5).toString());
		printOut(IntervalJso.create(a4, "M6").toString());
		printOut(a4.interval("m3").scientific());
		printOut(a4.interval(g5).toString());
		printOut(a4.interval(NoteJso.create("bb5")).invert().toString());
		
		// Create scales, based on notes.
		/*
		a4.scale('mixolydian').simple();  // Returns: ["a", "b", "c#", "d", "e", "f#", "g"]
		a4.scale('aeolian').simple();     // Returns: ["a", "b", "c", "d", "e", "f", "g"]
		g5.scale('ionian').simple();      // Returns: ["g", "a", "b", "c", "d", "e", "f#"]
		g5.scale('dorian');               // Returns a Scale object
		 */
		printArray(a4.scale("mixolydian").simple());
		printArray(a4.scale("aeolian").simple());
		printArray(g5.scale("ionian").simple());
		printOut(g5.scale("dorian").name());

		// Create chords with the powerful chord parser
		/*
		a4.chord('sus2').name;    // Returns the name of the chord: 'Asus2'
		c3.chord('m').name;       // Returns 'Cm'
		teoria.chord('Ab#5b9');   // Returns a Chord object, representing a Ab#5b9 chord
		g5.chord('dim');          // Returns a Chord object, representing a Gdim chord
		 */
		printOut(a4.chord("sus2").name());
		printOut(c3.chord("m").name());
		printOut(ChordJso.chord("Ab#5b9").toString());
		printOut(ChordJso.create(a4, "m7b5").name());
		printOut(g5.chord("dim").toString());
		
		// Calculate note frequencies or find the note corresponding to a frequency
		/*
		teoria.note.fromFrequency(467); // Returns: {'note':{...},'cents':3.102831} -> A4# a little out of tune.
		a4.fq(); // Outputs 440
		g5.fq(); // Outputs 783.9908719634985 
		 */
		printOut(a4.fq()+"");
		printOut(g5.fq()+"");

		// teoria allows for crazy chaining:
		/*
		teoria.note('a')    // Create a note, A3
		  .scale('lydian')  // Create a lydian scale with that note as root (A lydian)
		  .interval('M2')   // Transpose the whole scale a major second up (B lydian)
		  .get('third')     // Get the third note of the scale (D#4)
		  .chord('maj9')    // Create a maj9 chord with that note as root (D#maj9)
		  .toString();      // Make a string representation: 'D#maj9'
		 */
		
		printOut(NoteJso.create("a")
				.scale("lydian")
				.interval("M2")
				.get("third")
				.chord("maj9")
				.toString());
		
	}
}
