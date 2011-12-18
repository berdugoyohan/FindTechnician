import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class pointTest {
//Perso Definition of 2 Points.
	boolean bSuccess = true;
	point a = new point(5, 5);
	point b = new point(1, 1);
	point c = new point(0, 0);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPointIntInt() {
		c.setX(9);
		c.setY(8);
		
		assertTrue(c.getX()==9 && c.getY() == 8);
		//fail("Not yet implemented");
	}

	@Test
	public void testSetX() {
		b.setX(2);
		assertTrue(b.getX() == 2);
		
		/*if(b.getX() != 2){
		bSuccess = false;
		}*/
		
		//fail("Not yet implemented");
	}

	@Test
	public void testSetY() {
		b.setY(2);
		assertTrue(b.getY() == 2);
		
		//fail("Not yet implemented");
	}

	@Test
	public void testGetX() {
		assertTrue(a.getX() == 5);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetY() {
		assertTrue(a.getY() == 5);
		//fail("Not yet implemented");
	}

}
