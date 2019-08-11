package Observer;

import java.util.List;

import Model.AuctionItem;
import Model.Bid;
import State.AccountType;

public interface AuctionUser {
    public String getUserName();
    public void setUserName(String userName);
    public String getUserId();
    public void setUserId(String userId);
    public void createItem();
    public List<AuctionItem> getItems();
    public void setState(AccountType type);
	public void update(String message, List<Bid> bids);
}
