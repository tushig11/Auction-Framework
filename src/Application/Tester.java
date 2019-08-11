package Application;

import java.time.LocalDate;
import java.util.*;

import Model.*;
import Strategy.*;

public class Tester {

	public static void main(String[] args) {

        System.out.println();
        System.out.println("-- Auction Quote Application --");
        System.out.println();
        
        User henok = new User("1","Henok");
        User bob = new User("2","Bob");
        
        henok.createItem();
        henok.createItem();
        List<AuctionItem> henokItems = henok.getItems();
        AuctionItem henokItem = henokItems.get(0);
        
        henokItem.setItemName("Car");
        henokItem.setItemType("\"year 2019, New car \"");
        henokItem.setItemId("k11");
        henokItem.setItemDiscription("This is very cool one");
        
//        List<Item> itemList = new ArrayList<>();
        
        AuctionStrategy auction = new Absolute();
//      
        auction.placeItemForBid(henok, henokItem, 20, LocalDate.of(2019, 8, 12), 1000);
        
//        auctionStrategy.placeItemForBid(bob, "K12", "Car","\"year 2019, New car \"", 40, LocalDate.of(2019, 8, 8), 1500);
//
//        // iAuctionServer.placeItemForBid("Abera", "K12", "Car", "\"year 2019, New car \"", 21, 10);
////
////
        auction.bidOnItem(henok, henokItem, 300, 0);
        auction.bidOnItem(bob, henokItem, 101, 0);
        auction.bidOnItem(henok, henokItem, 1001, 0);

//        auctionStrategy.bidOnItem(bob, "K12", 22, 1000.0);
//
//        List<Bid> bidList =  ((Absolute1) auctionStrategy).getPlacedBids();;
	
	}
}
