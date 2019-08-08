package Model;
import Visitor.Visitor;

public class Item implements AuctionItem {

    String ItemName;
    String ItemId;
    String ItemType;
    double ItemPrice;
    String ItemOwner;
    String OwnerName;
    String ItemDiscription;

    double finalPrice;

    public Item(){
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemNAme(String itemNAme) {
        ItemName = itemNAme;
    }

    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String itemId) {
        ItemId = itemId;
    }

    public String getItemType() {
        return ItemType;
    }

    public void setItemType(String itemType) {
        ItemType = itemType;
    }

    public double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(double itemPrice) {
        ItemPrice = itemPrice;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getItemDiscription() {
        return ItemDiscription;
    }

    public void setItemDiscription(String itemDiscription) {
        ItemDiscription = itemDiscription;
    }

    public String getItemOwner() {
        return ItemOwner;
    }

    public void setItemOwner(String itemOwner) {
        ItemOwner = itemOwner;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
