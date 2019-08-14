package FineCalculator;

public class Media implements Product{
	@Override
	public void accept(Calculator calculator) {
		calculator.visit(this);
	}
}
