package br.com.richardcsantana.reader;

import org.junit.Assert;
import org.junit.Test;

import br.com.richardcsantana.model.Stream;
import br.com.richardcsantana.model.StreamMock;

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

}
