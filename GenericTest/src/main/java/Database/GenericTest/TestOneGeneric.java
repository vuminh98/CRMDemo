package Database.GenericTest;

public class TestOneGeneric<T> {
	
	private T sound;
	
	/**
	 * @param sound
	 */
	public TestOneGeneric(T sound) {
		this.sound = sound;
	}

	public void print() {
		System.out.println("Sound: " + sound);
	}

}
