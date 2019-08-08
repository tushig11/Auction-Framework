package Model;

import java.util.List;

import Observer.Observer;
import State.AccountType;

public class User implements Observer{
    String name;
    String userId;
    
    AccountType type;
    
    public User(String id, String name) {
    	this.name = name;
    	this.userId = id;
    	this.type = new Free(this);
    }
	@Override
	public void update(String message, List<Bid> bids) {
		Bid bid = bids.get(bids.size()-1);
		System.out.println(message + "--------------------------------------> Hi I'm Observer: " + this.getName() + " - - - " + bid.getItemId() + "-" + bid.getPrice());
	}
    
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
}
