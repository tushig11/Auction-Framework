package Model;

import java.time.LocalDate;
import java.util.Objects;

import Observer.AuctionUser;

public class Bid {

    private AuctionUser bidder;
    private AuctionItem item;
    private double price;
    private LocalDate time;
    private double finalPrice;


    public Bid(AuctionUser bidder, AuctionItem item, double price, LocalDate time, double finalPrice) {
        this.item = item;
        this.time = time;
        this.bidder = bidder;
        this.price = price;
        this.finalPrice= finalPrice;
    }
    public Bid(AuctionUser bidder, AuctionItem item, double price, LocalDate time) {
        this.item = item;
        this.time = time;
        this.bidder = bidder;
        this.price = price;
    }
    public AuctionUser getBidder() {
        return bidder;
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
                Objects.equals(item, bid.getItem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(bidder, item.getItemId(), price);
    }

    public AuctionItem getItem() {
    	return this.item;
	}
    public void setBidder(AuctionUser bidder) {
        this.bidder = bidder;
    }

    public void setItemId(AuctionItem item) {
        this.item = item;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }
}