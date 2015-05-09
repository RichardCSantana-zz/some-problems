/**
 * 
 */
package br.com.richardcsantana.model;

/**
 * @author richard
 *
 */
public class StreamMock implements Stream {

	private char[] charsArray;
	public int pointer = 0;

	/**
	 * 
	 * This object is constructed using a String that will be used as a char
	 * array
	 * 
	 * @param charsArray
	 *            a {@link String} with the chars for the test
	 */
	public StreamMock(String input) {
		this.charsArray = input.toCharArray();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see netshoes.Stream#getNext()
	 */
	public char getNext() {
		char result = charsArray[pointer]; // poderia usar chars[actual++] mas
											// achei esse modo mais legível
		pointer++;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see netshoes.Stream#hasNext()
	 */
	public boolean hasNext() {
		return pointer < charsArray.length;
	}

}