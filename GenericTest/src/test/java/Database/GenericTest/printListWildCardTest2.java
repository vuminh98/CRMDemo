package Database.GenericTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class printListWildCardTest2 {

	@Test
	public void testSound() {
		printListWildCard.Sound("meoow", "red");
		printListWildCard.Sound("alla", 3.5);
	}

	@Test
	public void testReturnGeneric() {
		assertEquals(printListWildCard.returnGeneric("Hello", 10000), "Hello");
	}

	@Test
	public void testPrintList() {
		List<Double> list = new ArrayList<Double>();
		list.add(3.5);
		list.add(7.6);
		printListWildCard.printList(list);
	}

	@Test
	public void testPrintList1() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(7);
		printListWildCard.printList1(list);
	}

}
