package FineCalculator;

public class adultCalculator implements Calculator{
	
	private double totalFee = 0.0;
	
	@Override
	public void visit(Book book) {
		totalFee += 0.2;
	}
	
	@Override
	public void visit(Magazine magazine) {
		totalFee += 0.5;
	}
	
	@Override
	public void visit(Media media) {
		totalFee += 1.0;
	}
	
	public double getTotalFee() {
		if(totalFee > 10.0)
			return 10;
		else
			return totalFee;
	}
	
}
