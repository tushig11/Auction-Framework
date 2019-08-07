package Factory;

import Model.AuctionItem;
import Model.Item;

public enum ItemCreator implements ItemFactory{
    INSTANCE;
	
	@Override
	public AuctionItem createItem(String name, double price) {
		return new Item(name, price);
	}
}
