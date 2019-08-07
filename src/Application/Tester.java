package Application;

import java.util.*;
import Factory.*;
import Iterator.*;
import Model.*;
import Timer.*;
import Visitor.*;

public class Tester {

	public static void main(String[] args) {
		//dumb data
		List<AuctionItem> items = new ArrayList<>();
		ItemFactory creator = ItemCreator.INSTANCE;
		AuctionItem item1 = creator.createItem("Car", 10000);
		AuctionItem item2 = creator.createItem("House", 100000);
		AuctionItem item3 = creator.createItem("Book", 5000);
		items.add(item1);
		items.add(item2);
		items.add(item3);
		
		//iterator test
		ACollection myCollection = new ItemCollection(items);
		AIterator it = myCollection.getIterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());	
		}
		
		//visitor test
		Visitor visitor = new ItemPrice();
		for(AuctionItem i: items) {
			i.accept(visitor);
		}
		
		//timer test
		BidTimer timer = new BidTimer(5);
		
	}

}
