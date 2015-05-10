package cdio3_v1;

import static org.junit.Assert.*;

import org.junit.*;

import cdio3_v1.server.*;

public class TestWeightFunctions {
	
	@Test
	public void testTara() throws Exception{
		WeightFunctions weight = new WeightFunctions();
		double actual = weight.tara();
		boolean condition = false;
		if(actual != 0){
			condition = true;
		}
		assertTrue(condition);
	}

	@Test
	public void testGetWeight() throws Exception{
		WeightFunctions weight = new WeightFunctions();
		double actual = weight.getWeight();
		boolean condition = false;
		if(actual != 0){
			condition = true;
		}
		assertTrue(condition);
	}
	
	@Test
	public void testSendMessage() throws Exception{
		WeightFunctions weight = new WeightFunctions();
		boolean condition = weight.sendMessage("thisBeATest");
		
		assertTrue(condition);
	}
	
	@Test
	public void testSendRM20() throws Exception{
		WeightFunctions weight = new WeightFunctions();
		String str = weight.sendRM20("thisBeATest");
		boolean condition;
		if(str.isEmpty()){
			condition = false;
		}else{
			condition = true;
		}
		
		assertTrue(condition);
	}
}
