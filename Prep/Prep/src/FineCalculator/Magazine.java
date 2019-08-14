package FineCalculator;

public class Magazine implements Product{
	@Override
	public void accept(Calculator calculator) {
		calculator.visit(this);
	}
}
