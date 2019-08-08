package Model;

import java.util.List;

import Observer.Observer;

public class User implements Observer{
    String name;
    String userId;
    
    public User(String id, String name) {
    	this.name = name;
    	this.userId = id;
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
