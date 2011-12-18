import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class distanceTest {

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
	public void testFind_distance() {
		point a = new point(7, 9);
		point b = new point(1, 1);
		
			
		double testDis = distance.find_distance(a,b);
		assertTrue(testDis == 10);
		
		//fail("Not yet implemented");
	}

	
}
