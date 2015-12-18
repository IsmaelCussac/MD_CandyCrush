package test.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.enums.Action;
import com.enums.Color;
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
		candy.setColor(Color.BLUE);
		assertEquals(Color.BLUE, candy.getColor());
	}
	
	@Test
	public void setColorTest(){
		candy.setColor(Color.RED);
		assertEquals(Color.RED, candy.getColor());
	}
	
	@Test
	public void getActionTest(){
		candy.setAction(Action.NORMAL);
		assertEquals(Action.NORMAL, candy.getAction());
	}
	
	@Test
	public void setActionTest(){
		candy.setAction(Action.PACKED);
		assertEquals(Action.PACKED, candy.getAction());
	}
}
