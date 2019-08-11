package Strategy;

import Observer.Observer;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import Model.*;

public class Absolute implements AuctionStrategy {

    List<AuctionItem> itemList;
    List<User> userList;
    private ArrayList<Observer> observers;
    private final Object MUTEX = new Object();

    List<Bid>  storeBidList;
    public List<Bid> placedBids;


    public Absolute(){
        itemList = new ArrayList<>();
        userList = new ArrayList<>();
        placedBids = new ArrayList<>();
        storeBidList = new ArrayList<>();
        observers = new ArrayList<>();
    }

    @Override
    public void placeItemForBid(User user, AuctionItem item, double startBid, LocalDate auctionTime, double finalPrice) {

    	item.setFinalPrice(finalPrice);
    	
        register(user);
        Bid bid = getBid(item.getItemId());

        if (!this.getItemList().contains(item)){
            addItem(item);
            System.out.println("The item is add to the list  : " + item.getItemType());
        }else{
            System.out.println("The item is already on the list ");
        }

        if(this.getItemList().contains(item)){
            if(!this.getPlacedBids().contains(bid)){
                Bid newBid = new Bid(user, item, startBid, auctionTime, item.getFinalPrice());
                addBids(newBid);
                System.out.println("The item is add to the bid List ");
                System.out.println("Beginning price of the auction : " + startBid );
                System.out.println("Pay now  : " + finalPrice );
                System.out.println("*************************************************************");
                notifyObservers("Notify new item add to the auction for bidding ");
                System.out.println("Number of bidder : "+ placedBids.size());
            }
        }else {System.out.println("The Item is not add to the bid List");}

    }
    
    @Override
    public void bidOnItem(User user, AuctionItem item, double bidPrice, double finalPrice) {
        // fine the bid item and the item id is the same ! so find the item and update the price and
        // then notify to the whole memebres
        List<Bid> bidList = this.placedBids;
        List<AuctionItem> itemList = this.itemList;
        register(user);
        Bid i = getBid(item.getItemId());
        AuctionItem ii = getItem(item);
        
        if(bidList.contains(i) && itemList.contains(ii) ){

            if(ii.getFinalPrice() == finalPrice || bidPrice > ii.getFinalPrice() && i.getTime().compareTo(LocalDate.now()) >= 0){
                updateBid(user, item.getItemId(), bidPrice, finalPrice);
                double highBid =  getCurrentWinningBid(i.getItem().getItemId());
                double PayNowfinalPrice  = i.getFinalPrice();
                System.out.println("==================================Auction Over  :" + i.getItem().getItemId() +"===================================================");
                System.out.println("The Auction is Over  : " +i.getItem().getItemId() + ": " + i.getPrice()  +" : "+"Item is type  : "+ i.getItem().getItemType() +"The new Price is : " + i.getPrice()+ "Final Price is :" +i.getFinalPrice());
                System.out.println("The highest Bid offer is : " +  highBid + ": "  +" : "+"Pay Now : "+ PayNowfinalPrice );

                System.out.println("==================================  ********** ===================================================");
                notifyObservers("Notify item Sold out");
                removeBid(item.getItemId());
                storeBidList.add(i);
                System.out.println(storeBidList.size());
            }

            else if(i.getPrice() < bidPrice){
                updateBid(user, item.getItemId(), bidPrice, finalPrice);
                storeBidList.add(i);
                System.out.println("==================================Auction Update===================================================");

                System.out.println("The item is updated, Item id is : " +i.getItem().getItemId() + " : " + " Bidder Name : " + i.getBidder().getUserName() +"Item type :"+ i.getItem().getItemType() +"The new price is :" + i.getPrice());
                notifyObservers("Notify item Update");

            }else {
                System.out.println("==================================Auction Denied ===================================================");
                System.out.println("Your price is lower put your higher price");
                System.out.println("================================== -----  ===================================================");
            }
            //call registerListener

        }
        else {
            System.out.println("There is no Item with the Id in the BidList: " + item.getItemId() + "   : Check it again");
        }

    }
    @Override
    public List<AuctionItem> getItemList() {
        return this.itemList;
    }

    @Override
    public AuctionItem getItem(AuctionItem item) {
        return this.getItemList().stream().filter(x-> x.equals(item)).findFirst().orElse(null);
    }

    public void setItemList(List<AuctionItem> itemList) {
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

        return this.getStoreBidList().stream()
                .filter(bid->ItemId.equals(bid.getItem().getItemId()))
                .map(bid -> bid.getPrice())
                .max(Double::compare)
                .orElse(0.0);

    }

    private Bid getBid(String id){
        if(this.getPlacedBids() != null){
            for(Bid i : this.getPlacedBids()){
                if(id == i.getItem().getItemId()){
                    return i;
                }

            }
        }
        return null;

    }
    private void addBids(Bid bids) {
        this.placedBids.add(bids);
    }

    private void addItem(AuctionItem newItem){
        this.itemList.add(newItem);
    }

    private void updateBid(User bidder, String id, double price, double finalPrice){

        Bid b = this.getBid(id);
        b.setPrice(price);
        b.setBidder(bidder);
        b.setFinalPrice(finalPrice);
        this.addBids(b);

    }

    public void removeBid(String ItemId){
      this.placedBids = this.placedBids.stream().filter(x->!x.getItem().getItemId().equals(ItemId)).collect(Collectors.toList());
    }

    public List<Bid> getStoreBidList() {
        return storeBidList;
    }

    public void setStoreBidList(List<Bid> storeBidList) {
        this.storeBidList = storeBidList;
    }

    public User getuser(String UserName, String userId){

        User user = new User(UserName, userId);
        user.setUserName(UserName);
        user.setUserId(userId);

        return user;
    }


    @Override
    public void register(Observer o) {
        synchronized (MUTEX) {
            if (!observers.contains(o))
                observers.add(o);
        }

    }

    @Override
    public void unregister(Observer o) {
        synchronized (MUTEX) {
            int i = observers.indexOf(o);
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
    
	@Override
	public List<Observer> getObservers() {
		return this.observers;
	}
}
