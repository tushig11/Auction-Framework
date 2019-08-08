package Strategy;

import Observer.IAuctionListener;
import Observer.Observer;
import Model.Item;
import Model.User;

import java.util.List;

public interface AuctionStrategy {

    public void placeItemForBid(User owner, String itemId, String itemType,
                                String itemDesc, double startBid, int auctionTime, double finalPrice);
    public void bidOnItem(User bidder, String Id, double bid, double finalPrice);
    public List<Item> getItemList();
    public Item getItem(String itemId);
    public void registerListener(IAuctionListener al, String itemName);

	public void attach(Observer observer);
	public void detach(Observer observer);
	public void notifyObservers(String message);
	public List<Observer> getObservers();
}
