package Model;

import Visitor.Visitor;

public class Item implements AuctionItem{

	private String name;
	private Double price;
	
	public Item(String name, double price){
		this.name = name;
		this.price = price;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public String getName() {
		return name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return this.name + ": " + this.price;
	}
}
