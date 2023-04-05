package Database.GenericTest;

import java.util.List;

import javax.sound.midi.Soundbank;

public class printListWildCard {
	
	
	protected static <T,V> void Sound(T thing, V overThing) {
		System.out.println("Sound: " + thing);
		System.out.println("Voice: " + overThing);
	}
	
	protected static <T,V> T returnGeneric(T thing, V overThing) {
		return thing;
	}
	
	protected static void printList(List<Object> myList) {
		System.out.println(myList);
	}
	
	protected static void printList1(List<?> myList) {
		System.out.println(myList);
	}
	
	

	

}
