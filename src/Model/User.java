package Model;

import Observer.*;
import State.AccountType;

import java.util.List;
import Strategy.*;
import State.*;

public class User implements AuctionUser{

    String UserName;
    String userId;
    private AccountType currentType;

    public User(String userId, String UserName){
        this.UserName = UserName;
        this.userId = userId;
        currentType = new Free(this);
    }
    public User(Absolute absolute){
    }
    
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public void createItem() {
    	currentType.createItem();
    }
    
    public List<AuctionItem> getItems() {
    	return currentType.getItems();
    }
    public void setState(AccountType type) {
    	this.currentType = type;
    }

    @Override
    public void update(String message, List<Bid> bidList) {
        Bid bid = bidList.get(bidList.size()-1);
        System.out.println("************** " + message + " ***************");
        System.out.println("Current bid Status  :  ");
        System.out.println("Bidder name : "+ this.UserName);
        System.out.println("Bidder UserId : "+ this.userId);
        System.out.println("Item Id-number "+ bid.getItem().getItemId());
        System.out.println("Item type  : " + bid.getItem().getItemType());
        System.out.println("Current highest Price  : " + bid.getPrice());
        System.out.println("Pay now and Win : " + bid.getFinalPrice());
        System.out.println("************** " + "end of notify" + " ***************");

        // System.out.println("Current bid Status  :  "+  "Item Id-Number "+ bid.getItemId() +" Item type  : " + bid.getItemType()+ " Current highest Price  : " + bid.getPrice() + " Final price  : " + bid.getFinalPrice());
    }

}
