package FineCalculator;

import java.util.Arrays;
import java.util.List;

public class Library {
	public static void main(String[] args) {
		Calculator childVisitor = new childCalculator();
		Calculator adultVisitor = new adultCalculator();
		
		List<Product> items = Arrays.asList(
				new Book(),
				new Book(),
				new Magazine(),
				new Magazine(),
				new Media(),
				new Media()
		);
		
		User child = new Child("Child" , items);
		User adult = new Adult("Adult", items);
		
		FineCalculator childCalc = new FineCalculator(child);
		FineCalculator adultCalc = new FineCalculator(adult);
		
		System.out.println(childCalc.calculateFine(childVisitor));
		System.out.println(adultCalc.calculateFine(adultVisitor));
	}
}
