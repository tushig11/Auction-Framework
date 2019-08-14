package FineCalculator;

public class Book implements Product{
	@Override
	public void accept(Calculator calculator) {
		calculator.visit(this);
	}
}
