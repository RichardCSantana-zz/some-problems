package br.com.richardcsantana.reader;

import org.junit.Assert;
import org.junit.Test;

import br.com.richardcsantana.model.Stream;
import br.com.richardcsantana.model.StreamMock;

/**
 * @author richard
 *
 */
public class StreamTester {

	/**
	 * Test a char array with two chars that doesn't repeat
	 */
	@Test
	public void normalCase() {
		Stream stream = new StreamMock("aAbBABac");
		Character firstChar = StreamReader.firstChar(stream);
		Assert.assertEquals(new Character('b'), firstChar);
	}

	/**
	 * Test a char array with no chars that doesn't repeat
	 */
	@Test(expected = IllegalArgumentException.class)
	public void allRepeatCase() {
		Stream stream = new StreamMock("aABABa");
		try {
			StreamReader.firstChar(stream);
		} catch (IllegalArgumentException e) {
			Assert.assertEquals(
					"This method expect at least one char that doesn't repeat",
					e.getMessage());
			throw e;
		}
	}

	/**
	 * Test a char array with three equals chars
	 */
	@Test
	public void threeEqualsCharsCase() {
		Stream stream = new StreamMock("aABABaac");
		Character firstChar = StreamReader.firstChar(stream);
		Assert.assertEquals(new Character('c'), firstChar);
	}

	/**
	 * Test a empty char array
	 */
	@Test(expected = IllegalArgumentException.class)
	public void emptyCharArrayCase() {
		Stream stream = new StreamMock("");
		try {
			StreamReader.firstChar(stream);
		} catch (IllegalArgumentException e) {
			Assert.assertEquals(
					"The stream must contain at least one char for this method",
					e.getMessage());
			throw e;
		}
	}

}
