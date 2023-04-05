package Database.GenericTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestOneGenericTest {

	@Test
	public void test() {
		TestOneGeneric<Integer> testOneGeneric = new TestOneGeneric<Integer>(50);
		testOneGeneric.print();
		TestOneGeneric<String> testOneGenericString = new TestOneGeneric<String>("50");
		testOneGenericString.print();
	}

}
