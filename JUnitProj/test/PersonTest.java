import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class PersonTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testExpectedException() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage(containsString("Invalid age"));
		new Person("Joe", -1);
	}
	
	//Another Way
	@Test(expected = IllegalArgumentException.class)
	public void testPerson() {
		new Person("Joe", -1);
	}

	@Test
	public void testExpectedException3() {
	  try {
	    new Person("Joe", -1);
	    fail("Should have thrown an IllegalArgumentException because age is invalid!");
	  } catch (IllegalArgumentException e) {
	    assertThat(e.getMessage(), containsString("Invalid age"));
	  }
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("==setUpBeforeClass==");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("==setUp==");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("==tearDown==");
	}

}
