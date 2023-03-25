package library;

import java.util.*;
import library.FastIO;
import library.AbstractGraph;

final class MaxFlow { // V=numNode, E=numEdge
	public final class CapEdge {
		public int source, target;
		public long cap;
		public int rev;
		public CapEdge(final int source, final int target, final long cap, final int rev) {
			this.source = source;
			this.target = target;
			this.cap = cap;
			this.rev = rev;
		}
		public long getFlow() { return edges[target][rev].cap; }

		@Override public String toString() { return source+" - "+cap+" -> "+target; }
		@Override public int hashCode() { return Objects.hash(source, target); }
		@Override
		public boolean equals(final Object obj) {
			if(this == obj) return true;
			if(obj == null) return false;
			if(this.getClass() != obj.getClass()) return false;
			CapEdge that = (CapEdge) obj;
			if(this.source != that.source) return false;
			if(this.target != that.target) return false;
			return true;
		}
	}

	public final int numNode;
	public final List<CapEdge> edgesList;
	private final int len[];
	public final CapEdge edges[][];

	public MaxFlow(final int numNode) { // O(1)
		FastIO.nonNegativeCheck(numNode);
		this.numNode = numNode;

		edgesList = new ArrayList<>();
		len = new int[numNode];
		edges = new CapEdge[numNode][];
	}

	public final int numEdge() { return edgesList.size(); }

	public final void addAll(final Collection<WeightedEdge> edges) { for(WeightedEdge e : edges) add(e); } // O(M)
	// O(1)
	public final int add(final WeightedEdge e) { return add(e.source, e.target, e.cost); }
	public final int add(final int source, final int target, final long cap) {
		FastIO.rangeCheck(source, numNode);
		FastIO.rangeCheck(target, numNode);
		CapEdge e = new CapEdge(source, target, cap, len[target]);
		len[source] ++;
		len[target] ++;
		edgesList.add(e);
		return edgesList.size() - 1;
	}

	public final void changeEdge(final int i, final long newCap, final long newFlow) { // O(1)
		FastIO.rangeCheck(i, edgesList.size());
		FastIO.nonNegativeCheck(newFlow);
		FastIO.assertion(newFlow <= newCap, "newFlow is larger than newCap.");
		CapEdge e = edgesList.get(i);
		CapEdge er = edges[e.target][e.rev];
		e.cap = newCap - newFlow;
		er.cap = newFlow;
	}

	private final void init() { // O(E)
		for(int i = 0; i < numNode; i ++) edges[i] = new CapEdge[len[i]];
		int idx[] = new int[numNode];
		for(CapEdge e : edgesList) {
			edges[e.target][idx[e.target] ++] = new CapEdge(e.target, e.source, 0, idx[e.source]);
			edges[e.source][idx[e.source] ++] = e;
		}
	}


	public final long maxFlow(final int s, final int t) { return flow(s, t, FastIO.INF); } // O(V^2E)
	public final long flow(final int s, final int t, final long flowLimit) {
		FastIO.rangeCheck(s, numNode);
		FastIO.rangeCheck(t, numNode);
		int iter[] = new int[numNode];
		init();
		long flow = 0;
		while(true) {
			long depth[] = dinicBFS(s, t);
			if(FastIO.isINF(depth[t])) return flow;
			Arrays.fill(iter, 0);
			long f = 0;
			do {
				f = dinicDFS(s, t, flowLimit - flow, depth, iter);
				flow += f;
			}while(f > 0);
		}
	}
	private final long[] dinicBFS(final int s, final int t) { // O(V)
		long depth[] = new long[numNode];
		Arrays.fill(depth, FastIO.INF);

		int dq[] = new int[numNode];
		int size = 0;
		int ptr = 0;

		dq[size ++] = s;
		depth[s] = 0;
		while(ptr < size) {
			int crt = dq[ptr ++];
			for(CapEdge e : edges[crt]) {
				if(e.cap <= 0 || !FastIO.isINF(depth[e.target])) continue;
				depth[e.target] = depth[e.source] + 1;
				if(e.target == t) return depth;
				dq[size ++] = e.target;
			}
		}
		return depth;
	}
	private final long dinicDFS(final int v, final int t, final long f, final long[] depth, final int[] iter) { // O(VE)
		if(v == t) return f;
		for(; iter[v] < len[v]; iter[v] ++) {
			CapEdge e = edges[v][iter[v]];
			if(e.cap <= 0 || depth[e.source] >= depth[e.target]) continue;
			long d = dinicDFS(e.target, t, Math.min(f, e.cap), depth, iter);
			if(d <= 0) continue;
			e.cap -= d;
			edges[e.target][e.rev].cap += d;
			return d;
		}
		return 0;
	}

	// O(Ef)
	public final long fordFulkersonMaxFlow(final int s, final int t) { return fordFulkersonFlow(s, t, FastIO.INF); }
	public final long fordFulkersonFlow(final int s, final int t, final long flowLimit) {
		FastIO.rangeCheck(s, numNode);
		FastIO.rangeCheck(t, numNode);
		init();
		boolean[] used = new boolean[numNode];
		long flow = 0;
		while(true) {
			Arrays.fill(used, false);
			long f = fordFulkersonDFS(s, t, flowLimit - flow, used);
			if(f <= 0) return flow;
			flow += f;
		}
	}
	private final long fordFulkersonDFS(final int v, final int t, final long f, final boolean[] used) { // O(V)
		if(v == t) return f;
		used[v] = true;
		for(CapEdge e : edges[v]) {
			if(e.cap <= 0 || used[e.target]) continue;
			long d = fordFulkersonDFS(e.target, t, Math.min(f, e.cap), used);
			if(d <= 0) continue;
			e.cap -= d;
			edges[e.target][e.rev].cap += d;
			return d;
		}
		return 0;
	}

	public final boolean[] minCut(final int s) { // O(V)
		FastIO.rangeCheck(s, numNode);
		boolean[] reachable = new boolean[numNode];
		int[] dq = new int[numNode];
		int ptr = 0;
		dq[ptr ++] = s;
		reachable[s] = true;
		while(ptr > 0) {
			int crt = dq[-- ptr];
			for(CapEdge e : edges[crt]) {
				if(reachable[e.target] || e.cap <= 0) continue;
				reachable[e.target] = true;
				dq[ptr ++] = e.target;
			}
		}
		return reachable;
	}
}