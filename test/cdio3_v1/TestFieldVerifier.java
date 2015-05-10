package cdio3_v1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.gwt.dev.protobuf.UnknownFieldSet.Field;

import cdio3_v1.shared.*;
import cdio3_v1.server.*;
import cdio3_v1.client.*;
import cdio3_v1.client.controller.*;
import cdio3_v1.views.*;
public class TestFieldVerifier {

//name-test
	@Test
	public void testIsNameValid() throws DALException
	{
		boolean actual = FieldVerifier.isNameValid("Hans Hansen");
		
		assertTrue(actual);
	}
	
	@Test
	public void testIsNameValidTooLong() throws DALException
	{
		boolean actual = FieldVerifier.isNameValid("Hans Hansen Hansensen Hansen");
		
		assertFalse(actual);
	}
	
	@Test
	public void testIsNameValidTooShort() throws DALException
	{
		boolean actual = FieldVerifier.isNameValid("H");
		
		assertFalse(actual);
	}
	
//id-test
	@Test
	public void testIsNewIdValid () throws DALException
	{
		boolean actual = FieldVerifier.isNewIdValid(20);
	
		assertTrue(actual);
	}

	@Test
	public void testIsNewIdValidOnBounds1() throws DALException
	{
		boolean actual = FieldVerifier.isNewIdValid(99999999);
	
		assertTrue(actual);
	}
	

	@Test
	public void testIsNewIdValidOnBounds2() throws DALException
	{
		boolean actual = FieldVerifier.isNewIdValid(1);
	
		assertTrue(actual);
	}
	
	@Test
	public void testIsNewIdValidWrongChar() throws DALException
	{
		boolean actual = FieldVerifier.isNewIdValid(-1223);
	
		assertFalse(actual);
	}
	@Test
	public void testIsNewIdValidOutOfBounds() throws DALException
	{
		boolean actual = FieldVerifier.isNewIdValid(100000000);
	
		assertFalse(actual);
	}
//ini-test
	@Test
	public void testIsIniValid() throws DALException
	{
		boolean actual = FieldVerifier.isIniValid("HH");
		
		assertTrue(actual);
	}
	
	@Test
	public void testIsIniValidTooLong() throws DALException
	{
		boolean actual = FieldVerifier.isIniValid("HHHH");
		
		assertFalse(actual);
	}
	
	@Test
	public void testIsIniValidTooShort() throws DALException
	{
		boolean actual = FieldVerifier.isIniValid("H");
		
		assertFalse(actual);
	}
	
	@Test
	public void testIsIniValidNoLetters() throws DALException
	{
		boolean actual = FieldVerifier.isIniValid("123");
		
		assertTrue(actual);
	}
	
//cpr-test
	@Test
	public void testIsCprValid() throws DALException
	{
		boolean actual = FieldVerifier.isCprValid("010101-1111");
		
		assertTrue(actual);
	}
	
	@Test
	public void testIsCprValidTooLong() throws DALException
	{
		boolean actual = FieldVerifier.isCprValid("010101-11111");
		
		assertFalse(actual);
		
	}
	@Test
	public void testIsCprValidTooShort() throws DALException
	{
		boolean actual = FieldVerifier.isCprValid("01010-111");
		
		assertFalse(actual);
	}
	
	@Test
	public void testIsCprValidNoHyphen() throws DALException
	{
		boolean actual = FieldVerifier.isCprValid("0101011111");
		
		assertTrue(actual);
	}

//Password-tests
	@Test
	public void testIsPasswordValid() throws DALException
	{
		boolean actual = FieldVerifier.isPasswordValid("AaBb12?");
		
		assertTrue(actual);
	}
	
	@Test
	public void testIsPasswordValidTooMany() throws DALException
	{
		boolean actual = FieldVerifier.isPasswordValid("AaBb12?89");
		
		assertFalse(actual);
	}
	
	@Test
	public void testIsPasswordValidTooFew() throws DALException
	{
		boolean actual = FieldVerifier.isPasswordValid("AaB?56");
		
		assertFalse(actual);
	}
	
	@Test
	public void testIsPasswordValidRightAmountWrongChars() throws DALException
	{
		boolean actual = FieldVerifier.isPasswordValid("ABABAB?!");
		
		assertFalse(actual);
	}
}
