package State;

import java.util.List;

import Model.AuctionItem;

public interface AccountType {
	public void createItem();
	public String getState();
	public List<AuctionItem> getItems();
}
