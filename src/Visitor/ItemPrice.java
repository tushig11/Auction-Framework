package Visitor;

import Model.AuctionItem;
import Model.Item;

public class ItemPrice implements Visitor{

	private AuctionItem item;
	
	public AuctionItem getItem() {
		return item;
	}

	@Override
	public void visit(Object ob) {
		Item item = (Item) ob;
		System.out.println(item.getName());
		
		
		
		
		
		
	}

}
