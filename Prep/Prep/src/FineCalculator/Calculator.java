package FineCalculator;

public interface Calculator {
	public void visit(Book book);
	public void visit(Magazine magazine);
	public void visit(Media media);
	public double getTotalFee();
}
