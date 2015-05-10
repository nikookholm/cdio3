package cdio3_v1;

import static org.junit.Assert.*;

import org.junit.*;

import cdio3_v1.server.*;

public class TestWeightFunctions {
	
	@Test
	public void testTara() throws Exception{
		WeightFunctions weight = new WeightFunctions();
		double actual = weight.tara();
		double expected = 1.0;
		double delta = 0.2;

		assertEquals(expected, actual, delta);
	}
	
	//Needs the weight to be set to 1.0kg
	@Test
	public void testGetWeight() throws Exception{
		WeightFunctions weight = new WeightFunctions();
		
		double actual = weight.tara();
		double expected = 1.0;
		double delta = 0.2;

		assertEquals(expected, actual, delta);
	}
	
	@Test
	public void testSendMessage() throws Exception{
		WeightFunctions weight = new WeightFunctions();
		boolean condition = true;
		condition = weight.sendMessage("thisBeATest");
		
		assertTrue(condition);
	}
	
}
