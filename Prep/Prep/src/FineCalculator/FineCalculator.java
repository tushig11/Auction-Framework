package FineCalculator;

public class FineCalculator {
	private User user;
	
	FineCalculator(User user){
		this.user = user;
	}
	public double calculateFine(Calculator calculator) {
		for(Product item: user.getItems()) {
			item.accept(calculator);
		}
		return calculator.getTotalFee();
	}
	
	public User getUser() {
		return user;
	}
}
