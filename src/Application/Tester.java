package Application;

import java.util.*;

import Iterator.*;
import Model.*;
import Strategy.*;

public class Tester {

	public static void main(String[] args) {

        User henok = new User("1","Henok");
        User bob = new User("2","Bob");
        User naya = new User("3", "Naya");
        
        List<Item> itemList = new ArrayList<>();
        
        AuctionStrategy auctionStrategy = new Absolute();
        
        auctionStrategy.placeItemForBid(henok, "K11", "Car","\"year 2019, New car \"", 20, 10, 1000);
        auctionStrategy.placeItemForBid(bob, "K12", "Car","\"year 2019, New car \"", 40, 10, 1000);

        // iAuctionServer.placeItemForBid("Abera", "K12", "Car", "\"year 2019, New car \"", 21, 10);
//
//
        auctionStrategy.bidOnItem(henok, "K11", 999,0 );
//        auctionStrategy.bidOnItem(bob, "K11", 22, 999);
        auctionStrategy.bidOnItem(henok, "K11", 1001,0 );
//        auctionStrategy.bidOnItem(bob, "K11", 22, 2000.0);
        auctionStrategy.bidOnItem(bob, "K12", 22, 1000.0);

        List<Bid> bidList =  ((Absolute) auctionStrategy).getPlacedBids();;

        double highBid =  ((Absolute) auctionStrategy).getCurrentWinningBid("K11");
        double highBid2 =  ((Absolute) auctionStrategy).getCurrentWinningBid("K12");

//        itemList = auctionStrategy.getItemList();
//
//        AIterator il = new ItemCollection(itemList).getIterator();
//        
//        while(il.hasNext()) {
//        	Item b = (Item) il.next();
//        	System.out.println("Starting price: " +b.getItemPrice() +  "  " + "Item Id  :" + b.getItemId() );
//        }
//
//        //System.out.println(highBid);
//        System.out.println("The high bid is :" + highBid);
//        System.out.println("The high bid is :" + highBid2);

        
//        ACollection collection = new ItemCollection(bidList);
//        AIterator itt = collection.getIterator();
        
        System.out.println(auctionStrategy.getObservers());
	
	}
}
