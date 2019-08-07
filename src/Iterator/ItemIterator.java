package Iterator;

import java.util.*;

public class ItemIterator implements AIterator {
	
	private List<? extends Object> items;
	// maintains curr pos of iterator over the array 
    int pos = 0; 
    
    public ItemIterator(List<? extends Object> items2) {
    	this.items = items2;
    }
    public Object next(){ 
        // return next element in the list and increment pos 
        Object item =  items.get(pos); 
        pos += 1; 
        return item; 
    } 
  
    public boolean hasNext(){ 
        if (pos >= items.size() || items.get(pos) == null) 
            return false; 
        else
            return true; 
    }

}