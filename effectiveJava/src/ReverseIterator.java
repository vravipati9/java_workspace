import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ReverseIterator {

	public static void main(String[] args) {
		for (Integer var : ReverseIterator.reverseIterator(Arrays.asList(41, 23, 12, 19))) {
			System.out.println(var);
		}
		Iterator<Integer> it = ReverseIterator.reverseIterator(Arrays.asList(41, 23, 12, 19)).iterator();
		while(it.hasNext()) {
			Integer i = it.next();
			it.remove();
		}
	}
	public static<T> Iterable<T> reverseIterator(final List<T> elements) {
		Iterable it = new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>() {
					int size = elements.size() - 1;
					@Override
					public boolean hasNext() {
						return  size >= 0;
					}
					@Override
					public T next() {
						if (hasNext()) {
							return elements.get(size--);
						} else {
							throw new NoSuchElementException();
						}
					}
					@Override
					public void remove() {
						throw new UnsupportedOperationException("Can't remove with reverse iterator");
					}
				};
			}
		};
		return it;
	}
}
