package Model;

import java.util.Objects;

public class Bid {

    private String bidder;
    private String itemId;
    private double price;
    private int time;
    private double finalPrice;
    private String itemType;

    public Bid(String bidder, String itemId, double price, int time, String itemType, double finalPrice ) {
        this.itemType = itemType;
        this.time = time;
        this.bidder = bidder;
        this.itemId = itemId;
        this.price = price;
        this.finalPrice= finalPrice;
    }
    public Bid(String bidder, String itemId, double price, int time, String itemType) {
        this.itemType = itemType;
        this.time = time;
        this.bidder = bidder;
        this.itemId = itemId;
        this.price = price;
    }
    public String getBidder() {
        return bidder;
    }

    public String getItemId() {
        return itemId;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bid bid = (Bid) o;
        return Double.compare(bid.price, price) == 0 &&
                Objects.equals(bidder, bid.bidder) &&
                Objects.equals(itemId, bid.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bidder, itemId, price);
    }


    public void setBidder(String bidder) {
        this.bidder = bidder;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }
}