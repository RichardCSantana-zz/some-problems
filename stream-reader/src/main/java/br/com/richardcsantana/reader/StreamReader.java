package br.com.richardcsantana.reader;

import java.util.ArrayList;
import java.util.List;

import br.com.richardcsantana.model.Stream;

/**
 * 
 * 
 * @author richard
 *
 */
public class StreamReader {

	/**
	 * This method receives an array of char in a {@link Stream} and returns the
	 * first char that doesn't repeat
	 * 
	 * @param input
	 *            a object from interface {@link Stream}
	 * @return the first char that doesn't repeat
	 */
	public static char firstChar(Stream input) {
		List<Character> chars = new ArrayList<>();
		while (input.hasNext()) {
			Character actual = input.getNext();
			if (chars.contains(actual)) {
				chars.remove(actual);
			} else {
				chars.add(actual);
			}
		}
		return chars.get(0);
	}

}
