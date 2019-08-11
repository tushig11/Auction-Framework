package Strategy;

import Observer.Observer;
import Model.AuctionItem;
import Model.User;

import java.time.LocalDate;
import java.util.List;

public interface AuctionStrategy {

    public void placeItemForBid(User owner, AuctionItem item, double startBid, LocalDate auctionTime, double finalPrice);
    public void bidOnItem(User bidder, AuctionItem item, double bid, double finalPrice);
    public List<AuctionItem> getItemList();
    public AuctionItem getItem(AuctionItem item);
	public void register(Observer observer);
	public void unregister(Observer observer);
	public void notifyObservers(String message);
	public List<Observer> getObservers();
}
