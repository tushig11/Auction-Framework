package State;

import java.time.LocalDate;
import java.util.List;

import Factory.ItemCreator;
import Model.*;

public class Paid implements AccountType{
	
	private String name = "Paid";
	private LocalDate duration;
	private User user;
	private List<AuctionItem> items;
	
	Paid(User user, LocalDate duration){
		this.user = user;
		this.duration = duration;
	}

	@Override
	public String getState() {
		return this.name;
	}

	@Override
	public List<AuctionItem> getItems() {
		return items;
	}
	
	@Override
	public void createItem() {
			checkDuration();
			AuctionItem item = ItemCreator.INSTANCE.createItem();
			items.add(item);
	}
	
	public void checkDuration() {
		if(this.duration.compareTo(LocalDate.now()) < 0) {
			user.setState(new Free(user));
		}
	}
}
