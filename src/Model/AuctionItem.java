package Model;
import Visitor.*;

public interface AuctionItem {
	public void accept(Visitor visitor);
}
