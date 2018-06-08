package iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyList<T> implements Iterable<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyList<Integer> list = new MyList<Integer>(new ArrayList<Integer>(Arrays.asList(1,2,3,4,3,2,4,5,6,8,7,5)), v -> v%2==0);
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new MyListIterator();
	}
	
	private List<T> values;
	public MyList(List<T> values, Predicate<T> pred) {
		this.values = (List<T>) values.stream().filter(pred).collect(Collectors.toList());
	}
	
	
	class MyListIterator implements Iterator<T>{

		int current = 0;

		@Override
		public boolean hasNext() {
			if(current < values.size()) return true;
			return false;
		}

		@Override
		public T next() {
			return values.get(current++);
		}
	}
}
