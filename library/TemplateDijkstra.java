package library;

import java.util.*;
import java.util.function.*;
import library.FastIO;
import library.AbstractGraph;

final class TemplateDijkstra<T> {
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
	public final ArrayList<T> dist(final AbstractGraph<? extends TemplateNode<T>, TemplateEdge<T>> g, final int start) { return dist(g, start, null, null); }
	public final ArrayList<T> dist(final AbstractGraph<? extends TemplateNode<T>, TemplateEdge<T>> g, final int start, final int[] prv) { return dist(g, start, prv, null); }
	public final ArrayList<T> dist(final AbstractGraph<? extends TemplateNode<T>, TemplateEdge<T>> g, final int start, final int[] prv, final TemplateEdge<T>[] prvEdge) { return dist(g.numNode, g.nodes(), start, prv, prvEdge); }
	public final ArrayList<T> dist(final int numNode, final TemplateNode<T>[] nodes, final int start) { return dist(numNode, nodes, start, null, null); }
	public final ArrayList<T> dist(final int numNode, final TemplateNode<T>[] nodes, final int start, final int[] prv) { return dist(numNode, nodes, start, prv, null); }
	public final ArrayList<T> dist(final int numNode, final TemplateNode<T>[] nodes, final int start, final int[] prv, final TemplateEdge<T>[] prvEdge) {
		FastIO.rangeCheck(start, numNode);
		final ArrayList<T> dist = new ArrayList<>(numNode);
		if(prv != null) Arrays.fill(prv, -1);
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
					if(prv != null) prv[e.target] = e.source;
					if(prvEdge != null) prvEdge[e.target] = e;
				}
			}
		}
		return dist;
	}
}