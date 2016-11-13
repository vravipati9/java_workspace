package chapter4;

import java.util.Collection;
import java.util.HashSet;


/**
 * @author sra
 *
 * @param <E>
 */
/**
 * @author sra
 *
 * @param <E>
 */
/**
 * @author sra
 *
 * @param <E>
 */
/**
 * @author sra
 *
 * @param <E>
 */
/**
 * @author sra
 *
 * @param <E>
 */
/**
 * @author sra
 *
 * @param <E>
 */
/**
 * @author sra
 *
 * @param <E>
 */
public class InstrumentedHashSet<E> extends HashSet<E> {

	private static final long serialVersionUID = 3420501846178396589L;

	private int count;

	public InstrumentedHashSet(int initCap, float loadFactor) {
		super(initCap, loadFactor);
	}

	public int getCount() {
		return count;
	}

	public InstrumentedHashSet() {
		count = 0;
	}

	/* (non-Javadoc)
	 * @see java.util.HashSet#add(java.lang.Object)
	 */
	public boolean add(E e) {
		count = count + 1;
		return super.add(e);
	}

	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		count = count + c.size();
		return super.addAll(c);
	}
}
