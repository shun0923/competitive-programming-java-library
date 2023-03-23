package library;

import java.util.*;
import library.FastIO;

class MultiSet<K> extends HashMap<K, Long> {
	long cnt = 0;
	public final Long add(K key) { return update(key, 1); }
	public final Long erase(K key) { return update(key, -1); }
	public final Long update(K key, long value) {
		cnt += value;
		Long prv = get(key);
		long crt = convert(prv) + value;
		if(crt < 0) throw new NoSuchElementException();
		else if(crt == 0) remove(key);
		else put(key, crt);
		return prv;
	}
	public final long count() { return cnt; }
	public final long count(K key) { return convert(get(key)); }

	private static final long convert(Long value) { return value == null ? 0 : value; }
}

class TreeMultiSet<K> extends TreeMap<K, Long> {
	private long cnt = 0;
	public final Long add(K key) { return update(key, 1); }
	public final Long erase(K key) { return update(key, -1); }
	public final Long update(K key, long value) {
		cnt += value;
		Long prv = get(key);
		long crt = convert(prv) + value;
		if(crt < 0) throw new NoSuchElementException();
		else if(crt == 0) remove(key);
		else put(key, crt);
		return prv;
	}
	public final long count() { return cnt; }
	public final long count(K key) { return convert(get(key)); }
	public final boolean contains(K key) { return containsKey(key); }

	public final K first() { return firstKey(); }
	public final long firstCount() { return convert(firstEntry().getValue()); }
	public final K last() { return lastKey(); }
	public final long lastCount() { return convert(lastEntry().getValue()); }
	public final K floor(K key) { return floorKey(key); }
	public final long floorCount(K key) { return convert(floorEntry(key).getValue()); }
	public final K ceiling(K key) { return ceilingKey(key); }
	public final long ceilingCount(K key) { return convert(ceilingEntry(key).getValue()); }
	public final K higher(K key) { return higherKey(key); }
	public final long higherCount(K key) { return convert(higherEntry(key).getValue()); }
	public final K lower(K key) { return lowerKey(key); }
	public final long lowerCount(K key) { return convert(lowerEntry(key).getValue()); }

	public final K eraseFirst() { K first = first(); erase(first); return first; }
	public final K removeFirst() { K first = first(); remove(first); return first; }
	public final K eraseLast() { K last = last(); erase(last); return last; }
	public final K removeLast() { K last = last(); remove(last); return last; }

	private static final long convert(Long value) { return value == null ? 0 : value; }
}