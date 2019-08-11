package Strategy;

import Observer.AuctionUser;
import Model.AuctionItem;

import java.time.LocalDate;
import java.util.List;

public interface AuctionStrategy {

    public void placeItemForBid(AuctionUser owner, AuctionItem item, double startBid, LocalDate auctionTime, double finalPrice);
    public void bidOnItem(AuctionUser bidder, AuctionItem item, double bid, double finalPrice);
    public List<AuctionItem> getItemList();
    public AuctionItem getItem(AuctionItem item);
	public void register(AuctionUser observer);
	public void unregister(AuctionUser observer);
	public void notifyObservers(String message);
	public List<AuctionUser> getObservers();
}
