package com.surirobot.services.azure;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import com.surirobot.services.microsoftazure.Parser;
/**
 * 
 * @author jussieu
 * 
 * Cette class permet de tester les methodes définies dans la classe {@link Parser}.
 *
 */
public class ParserTest {

	
	String s;
	String face;

	@Before
	public void beforeTest() {
		 face =
				"  {" + 
				"    \"faceRectangle\": {" + 
				"      \"top\": 114," + 
				"      \"left\": 212," + 
				"      \"width\": 65," + 
				"      \"height\": 65" + 
				"    }," + 
				"    \"scores\": {" + 
				"      \"anger\": 0.1," + 
				"      \"contempt\": 0.1," + 
				"      \"disgust\": 0.1," + 
				"      \"fear\": 0.1," + 
				"      \"happiness\": 0.1," + 
				"      \"neutral\": 0.1," + 
				"      \"sadness\": 0.1," + 
				"      \"surprise\": 0.1" + 
				"    }" + 
				"  }";
		 s = "["+face+"]";
	}


	@Test
	public void parseEmptyArrayResponseTest() {
		JSONArray json = new Parser().parse("[]");
		assertTrue(json.similar(new JSONArray("[]")));
	}
	
	@Test (expected = JSONException.class)
	public void parseTestFail() {
		new Parser().parse("{}");
	}
	
	@Test (expected = JSONException.class)
	public void parseTestFail1() {
		new Parser().parse("test");
	}
	
	@Test (expected = JSONException.class)
	public void parseTestFail2() {
		new Parser().parse("{result:results{}}");
	}
	
	@Test (expected = ClassCastException.class)
	public void parseTestFail3() {
		new Parser().parse("[test,test]");
	}

}
