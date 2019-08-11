package State;

import java.util.*;

import Factory.ItemCreator;
import Model.AuctionItem;
import Model.User;

public class Free implements AccountType{

	private User user;
	private String name = "Paid";
	private List<AuctionItem> items = new ArrayList<>();
	
	public Free(User user) {
		this.user = user;
	}

	@Override
	public String getState() {
		return this.name;
	}

	public void checkForUpdate(){
		
	}

	@Override
	public void createItem() {
		if(items.size() < 1)
			items.add(ItemCreator.INSTANCE.createItem());
		else
			System.out.println("You already own 1 item");
	}
	
	public List<AuctionItem> getItems() {
		return items;
	}
	
	public User getUser() {
		return user;
	}
}
