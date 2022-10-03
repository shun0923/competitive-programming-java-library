package library;

import java.util.*;
import library.SimpleUtil;
import library.AbstractGraph;
import library.PathRestoration;
import java.util.function.*;

final class TemplateDijkstra<T extends Comparable<T>> {
	private final class Dist implements Comparable<Dist> {
		public int target;
		public T cost;
		public Dist(final int target, final T cost) { this.target = target; this.cost = cost; }
		@Override public final String toString() { return " - "+cost.toString()+" -> "+target; }
		@Override public final int hashCode() { return Objects.hash(target, cost); }
		@Override
		@SuppressWarnings("unchecked")
		public final boolean equals(final Object obj) {
			if(this == obj) return true;
			if(obj == null) return false;
			if(this.getClass() != obj.getClass()) return false;
			Dist that = (Dist) obj;
			if(this.target != that.target) return false;
			if(this.cost != that.cost) return false;
			return true;
		}
		@Override
		public final int compareTo(final Dist that) {
			int c = cmp.compare(this.cost, that.cost);
			if(c == 0) c = Integer.compare(this.target, that.target);
			return c;
		}
	}

	private int prv[];
	private TemplateEdge<T> prvEdge[];
	private Supplier<T> eSupplier;
	private T e;
	private BinaryOperator<T> f;
	private Comparator<T> cmp;

	public TemplateDijkstra(final Supplier<T> eSupplier, final BinaryOperator<T> f, final Comparator<T> cmp) {
		this.eSupplier = eSupplier;
		this.e = eSupplier.get();
		this.f = f;
		this.cmp = cmp;
	}

	// O((E+V)logV)
	public final <Node extends TemplateNode<T>> ArrayList<T> dist(final TemplateGraph<T, Node> g, final int start) { return dist(g, start, false); }
	public final <Node extends TemplateNode<T>> ArrayList<T> dist(final TemplateGraph<T, Node> g, final int start, final boolean memoize) { return dist(g.numNode, g.nodes(), start, memoize); }
	public final ArrayList<T> dist(final int numNode, final TemplateNode<T>[] nodes, final int start) { return dist(numNode, nodes, start, false); }
	@SuppressWarnings("unchecked")
	public final ArrayList<T> dist(final int numNode, final TemplateNode<T>[] nodes, final int start, final boolean memoize) {
		SimpleUtil.rangeCheck(start, numNode);
		final ArrayList<T> dist = new ArrayList<>(numNode);
		if(memoize) {
			prv = new int[numNode];
			Arrays.fill(prv, -1);
			prvEdge = new TemplateEdge[numNode];
		}
		Queue<Dist> q = new PriorityQueue<>();

		for(int i = 0; i < numNode; i ++) dist.add(null);
		dist.set(start, eSupplier.get());
		q.add(new Dist(start, dist.get(start)));
		while(!q.isEmpty()) {
			Dist crt = q.poll();
			if(cmp.compare(dist.get(crt.target), crt.cost) < 0) continue;
			T tmp = dist.get(crt.target);
			for(TemplateEdge<T> e : nodes[crt.target]) {
				T updated = f.apply(tmp, e.cost);
				if(dist.get(e.target) == null || cmp.compare(dist.get(e.target), updated) > 0) {
					dist.set(e.target, updated);
					q.add(new Dist(e.target, updated));
					if(memoize) {
						prv[e.target] = e.source;
						prvEdge[e.target] = e;
					}
				}
			}
		}
		return dist;
	}

	public final int[] path(final int start, final int goal) { return PathRestoration.path(prv, start, goal); }
	public final ArrayTemplateNode<T> pathEdge(final int start, final int goal) { return PathRestoration.pathEdge(new ArrayTemplateNode<T>(-1), prv, prvEdge, start, goal); }
}