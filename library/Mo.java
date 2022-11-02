package library;

import java.util.*;

class Mo {
	public abstract class Operators {
		Operators() {  }

		abstract void addFirst(int idx);
		abstract void addLast(int idx);
		abstract void removeFirst(int idx);
		abstract void removeLast(int idx);
		abstract void find(int idx);
	}

	public final int n;
	public final Operators op;

	// O(1)
	Mo(int n, Operators op) {
		this.n = n;
		this.op = op;
	}

	// O(QlogQ+aNQ^(1/2))
	// [l, r) query
	public final void query(final Pair.II[] query) {
		int q = query.length;
		int blockSize = n / Math.min(Math.max((int)Math.ceil(Math.sqrt(q)), 1), n);
		
		Integer ord[] = new Integer[q];
		for(int i = 0; i < q; i ++) ord[i] = i;
		Comparator<Integer> cmp = (sort1, sort2) -> {
			int aBlock = query[sort1].a / blockSize;
			int bBlock = query[sort2].a / blockSize;
			if(aBlock != bBlock) return Integer.compare(aBlock, bBlock);
			return ((aBlock & 1) == 0 ? 1 : -1) * Integer.compare(query[sort1].b, query[sort2].b);
		};
		Arrays.sort(ord, cmp);
		
		int l = 0;
		int r = 0;
		for(int idx : ord) {
			while(l > query[idx].a) op.addFirst(-- l);
			while(r < query[idx].b) op.addLast(r ++);
			while(l < query[idx].a) op.removeFirst(l ++);
			while(r > query[idx].b) op.removeLast(-- r);
			op.find(idx);
		}
	}
}