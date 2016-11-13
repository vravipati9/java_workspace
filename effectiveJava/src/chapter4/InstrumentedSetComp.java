package chapter4;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class InstrumentedSetComp<E> extends ForwardingSet<E> {
	
	public InstrumentedSetComp(Set<E> s) {
		super(s);
	}

	private int addCount = 0;

	public int getAddCount() {
		return addCount;
	}

	public boolean add(E e) {
		System.out.println("add() in InstrumentedSetComp");
		addCount++;
		return super.add(e);
	}

	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return addCount;
	}
	
}
