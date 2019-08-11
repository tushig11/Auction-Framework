package Application;

import java.time.LocalDate;
import java.util.*;

import Model.*;
import Observer.AuctionUser;
import Strategy.*;

public class Tester {

	public static void main(String[] args){

        System.out.println();
        System.out.println("-- Auction Quote Application --");
        System.out.println();
        
        AuctionUser henok = new User("1","Henok");
        AuctionUser bob = new User("2","Bob");
        
        henok.createItem();
        henok.createItem();
        
        List<AuctionItem> henokItems = henok.getItems();
        AuctionItem henokItem = henokItems.get(0);
        
        henokItem.setItemName("Car");
        henokItem.setItemType("\"year 2019, New car \"");
        henokItem.setItemId("k11");
        henokItem.setItemDiscription("This is very cool one");

        
        AuctionStrategy auction = new Absolute();
        
        auction.placeItemForBid(henok, henokItem, 20, LocalDate.of(2019, 8, 12), 1000);

        auction.bidOnItem(henok, henokItem, 300, 0);
        auction.bidOnItem(bob, henokItem, 101, 0);
        auction.bidOnItem(henok, henokItem, 1001, 0);

	
	}
}
