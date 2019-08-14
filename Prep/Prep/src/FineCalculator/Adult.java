package FineCalculator;

import java.util.List;

public class Adult implements User{
	private String name;
	private List<Product> items;
	public Adult(String name, List<Product> items) {
		this.name = name;
		this.items = items;
	}
	public String getName() {
		return name;
	}
	
	public List<Product> getItems() {
		return items;
	}
}
