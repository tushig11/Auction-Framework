package Strategy;

import Model.*;
import Observer.*;
import Observer.Observer;
import Timer.*;
import java.util.*;
import java.util.stream.Collectors;

public class Absolute implements AuctionStrategy{

    List<Item> itemList;
    List<User> userList;
    public List<Bid> placedBids;
    private List<Observer> observers = new ArrayList<>();
    private final Object MUTEX = new Object();

    public Absolute(){
        itemList = new ArrayList<>();
        userList = new ArrayList<>();
        placedBids = new ArrayList<>();
    }

    @Override
    public void placeItemForBid(User owner, String itemId, String itemType, String itemDesc, double startBid, int auctionTime, double finalPrice) {

    	attach(owner);
        Item item = getItem(itemId);
        Bid bid = getBid(itemId);

        if (!this.getItemList().contains(item)){
            Item newItem = new Item();
            newItem.setItemDiscription(itemDesc);
            newItem.setItemId(itemId);
            newItem.setItemOwner(owner.getName());
            newItem.setItemPrice(startBid);
            newItem.setItemType(itemType);
            newItem.setFinalPrice(finalPrice);
            addItem(newItem);
            System.out.println("The Item is add to the list");

        } else{
            System.out.println("The Item is already on the list ");
        }

        if(!this.getItemList().contains(item)){
            if(!this.getPlacedBids().contains(bid)){
                Bid newBid = new Bid(owner.getName(), itemId, startBid, auctionTime, itemType, finalPrice );
                addBids(newBid);
                System.out.println("The Item is add to the Bid List ");
                System.out.println("Beginning price of the auction : " + startBid );
                System.out.println("Pay Now  : " + finalPrice );
                BidTimer bidTimer = new BidTimer(auctionTime);
                bidTimer.isActive();
                notifyObservers("New Item placed on Auction");
            }

        }else {System.out.println("The Item is not add to the bid List");}
    }

    @Override
    public void bidOnItem(User bidder, String itemId, double bidPrice, double finalPrice) {

    	attach(bidder);
        // fine the bid item and the item id is the same ! so find the item and update the price and
        // then notify to the whole memebres
        List<Bid> bidList = this.placedBids;
        List<Item> itemList = this.itemList;

        Bid i = getBid(itemId);
        Item ii = getItem(itemId);
        if(bidList.contains(i) && itemList.contains(ii)){

            if(ii.getFinalPrice() == finalPrice || bidPrice > ii.getFinalPrice()){
            	
                updateBid(bidder.getName(),itemId, bidPrice, finalPrice);
                System.out.println("The Auction is Over  : " +i.getItemId() + ": " + i.getPrice()  +" : "+"Item is type  : "+ i.getItemType() +"The new Price is : " + i.getPrice()+ "Final Price is :" +i.getFinalPrice());
                notifyObservers("Item sold out");
                removeBid(itemId);
                System.out.println("---------------Winner is: " + i.getBidder() + " Sold price: " + i.getPrice());
            }

            else if(i.getPrice() < bidPrice){
                updateBid(bidder.getName(),itemId, bidPrice, finalPrice);
                System.out.println("The Item is updated, Item Id is : " +i.getItemId() + ": " + i.getPrice()  +"Item is type  : "+ i.getItemType() +"The new Price is : " + i.getPrice());
                notifyObservers("Highest bid changed");
            }else {
                System.out.println("Your price is lower put your higher price");

            }

        }
        else {
            System.out.println("There is no Item with the Id in the BidList: " + itemId + "Check it again");
        }

    }

    @Override
    public List<Item> getItemList() {
        return this.itemList;
    }

    @Override
    public Item getItem(String itemId) {
        return this.getItemList().stream().filter(x-> x.getItemId().equals(itemId)).findFirst().orElse(null);
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Bid> getPlacedBids() {
        if(this.placedBids == null){
            System.out.println("Null bid list");
        }
        return this.placedBids;

    }

    public double getCurrentWinningBid(String ItemId){

        return this.getPlacedBids().stream()
                .filter(bid->ItemId.equals(bid.getItemId()))
                .map(bid -> bid.getPrice())
                .max(Double::compare)
                .orElse(0.0);
    }

    private Bid getBid(String ItemId){

        if(this.getPlacedBids() != null){
            for(Bid i : this.getPlacedBids()){
                if(ItemId == i.getItemId()){
                    return i;
                }
            }

        }
        return null;

    }

    private void addBids(Bid bids) {
        this.placedBids.add(bids);
    }

    private void addItem(Item item){
        this.itemList.add(item);
    }

    private void updateBid(String bidderName, String id, double price, double finalPrice){
        Bid b = this.getBid(id);
        b.setPrice(price);
        b.setBidder(bidderName);
        b.setFinalPrice(finalPrice);
        this.addBids(b);

    }

    public void removeBid(String ItemId){
      this.placedBids = this.placedBids.stream().filter(x->!x.getItemId().equals(ItemId)).collect(Collectors.toList());
    }

	@Override
	public void registerListener(IAuctionListener al, String itemName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attach(Observer observer) {
		synchronized (MUTEX) {
			if (!observers.contains(observer))
				observers.add(observer);
		}
	}
	@Override
	public void detach(Observer observer) {
		synchronized (MUTEX) {
			int i = observers.indexOf(observer);
			if (i >= 0)
				observers.remove(i);
		}
	}
	@Override
	public void notifyObservers(String message) {
		synchronized (MUTEX){
			int n = observers.size();
			for (int i = 0; i < n; ++i) {
				Observer observer = (Observer)
				observers.get(i);
				observer.update(message, this.placedBids);
			}
		}
	}
	
	public List<Observer> getObservers() {
		return observers;
	}
}
