package Factory;

import Model.AuctionItem;
import Model.Item;

public enum ItemCreator implements ItemFactory{
    INSTANCE;
	
	@Override
	public AuctionItem createItem() {
		return new Item();
	}
}
