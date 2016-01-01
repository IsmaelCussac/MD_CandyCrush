package test.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.enums.CandyAction;
import com.enums.CandyColor;
import com.model.Candy;

public class TestCandy {
	
	private static Candy candy;
	
	@Before
	public static void setUp(){
		candy = new Candy();
	}
	
	@After
	public void tearDown(){
		
	}
	
	@Test
	public void getColorTest(){
		candy.setColor(CandyColor.BLUE);
		assertEquals(CandyColor.BLUE, candy.getColor());
	}
	
	@Test
	public void setColorTest(){
		candy.setColor(CandyColor.RED);
		assertEquals(CandyColor.RED, candy.getColor());
	}
	
	@Test
	public void getActionTest(){
		candy.setAction(CandyAction.NORMAL);
		assertEquals(CandyAction.NORMAL, candy.getAction());
	}
	
	@Test
	public void setActionTest(){
		candy.setAction(CandyAction.PACKED);
		assertEquals(CandyAction.PACKED, candy.getAction());
	}
}
