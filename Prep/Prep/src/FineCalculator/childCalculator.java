package FineCalculator;

public class childCalculator implements Calculator{
	
	private double totalFee = 0.0;
	
	@Override
	public void visit(Book book) {
		totalFee += 0.1;
	}
	
	@Override
	public void visit(Magazine magazine) {
		totalFee += 0.15;
	}
	
	@Override
	public void visit(Media media) {
		totalFee += 0.20;
	}

	public double getTotalFee() {
		if(totalFee > 3.0)
			return 3;
		else
			return totalFee;
	}
}
