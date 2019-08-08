package Observer;

import java.util.List;
import Model.Bid;

public interface Observer {
	public void update(String message, List<Bid> bids);
}
