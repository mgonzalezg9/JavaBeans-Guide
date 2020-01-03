package usage;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import component.Bean;

/**
 * Class to test JavaBean's subscriber list
 * 
 * @author Manuel González
 */
class TestClass {
	private static Bean component;
	private static Subscriber sub;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		component = new Bean();
		sub = new Subscriber();

		// sub is component's value listener
		component.addListener(sub);
	}

	/**
	 * Changes Bean's value and check if the subscriber has received the new value.
	 */
	@Test
	void firstChange() {
		component.changeValue();
		assertEquals(component.getValue(), sub.getNewValue());
	}

	/**
	 * Changes Bean's value and check if the subscriber has received the new value.
	 */
	@Test
	void secondChange() {
		component.changeValue();
		assertEquals(component.getValue(), sub.getNewValue());
	}

	@Test
	void subNotNotificated() {
		// Remove sub from listeners list
		component.removeListener(sub);
		component.changeValue();
		assertNotEquals(component.getValue(), sub.getNewValue());
		
		// Undo the change
		component.addListener(sub);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		component.removeListener(sub);
	}

}
