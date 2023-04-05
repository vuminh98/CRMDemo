package Database.ReflectionDemo;

import java.awt.color.ICC_ColorSpace;

public class Car {
	private String name;
	private int quantity;
	private String color;
	private boolean isAvaiable;
	/**
	 * @param name
	 * @param quantity
	 * @param color
	 * @param isAvaiable
	 */
	public Car(String name, int quantity, String color, boolean isAvaiable) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.color = color;
		this.isAvaiable = isAvaiable;
	}
	
	public void buy() {
		System.out.println("Price: 500$");
	}
	
	private void sell() {
		System.out.println("Price: 300$");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isAvaiable() {
		return isAvaiable;
	}
	public void setAvaiable(boolean isAvaiable) {
		this.isAvaiable = isAvaiable;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", quantity=" + quantity + ", color=" + color + ", isAvaiable=" + isAvaiable + "]";
	}
	
	
	
	
	
	

}
