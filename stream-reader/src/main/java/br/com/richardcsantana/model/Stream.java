/**
 * 
 */
package br.com.richardcsantana.model;

/**
 * @author richard
 *
 */
public interface Stream {

	/**
	 * Return next char from the Stream
	 * 
	 * @return next char of the Stream
	 */
	char getNext();

	/**
	 * Return <code>true</code> if Stream has more chars
	 * 
	 * @return <code>true</code> if Stream has more chars <code>false</code>
	 *         otherwise
	 */
	boolean hasNext();

}
