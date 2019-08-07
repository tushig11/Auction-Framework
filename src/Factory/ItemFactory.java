package Factory;

import Model.AuctionItem;

public interface ItemFactory {
	public AuctionItem createItem(String name, double price);
}
