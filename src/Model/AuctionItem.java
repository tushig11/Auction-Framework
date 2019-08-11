package Model;
import Visitor.*;

public interface AuctionItem {
	public void accept(Visitor visitor);
	
    public String getItemName();
    public void setItemName(String itemName);
    public String getItemId();
    public void setItemId(String itemId) ;
    public String getItemType();
    public void setItemType(String itemType);
    public double getItemPrice() ;
    public void setItemPrice(double itemPrice) ;
    public String getOwnerName();
    public void setOwnerName(String ownerName) ;
    public String getItemDiscription() ;
    public void setItemDiscription(String itemDiscription);
    public String getItemOwner() ;
    public void setItemOwner(String itemOwner);
    public double getFinalPrice();
    public void setFinalPrice(double finalPrice);
}
