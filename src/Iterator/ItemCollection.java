package Iterator;

import java.util.List;

public class ItemCollection implements ACollection{
	private List<? extends Object> items;
	
	public ItemCollection(List<? extends Object> items){
		this.items = items;
	}
	
	@Override
	public AIterator getIterator() {
		return new ItemIterator(items);
	}
}
