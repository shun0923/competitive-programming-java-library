package library;

import java.util.*;
import library.SimpleUtil;

abstract class AbstractGraph<Node extends AbstractNode<Edge>, Edge extends AbstractEdge<Edge>> {
	public int numNode;
	public boolean directed;
	private Node edges;
	private Node nodes[];
	private Node reversedEdges;
	private Node reversedNodes[];

	protected abstract Node createNode(final int id);
	protected abstract Node[] createNodeList(final int size);

	public AbstractGraph(final int numNode, final boolean directed) {
		SimpleUtil.nonNegativeCheck(numNode);
		this.numNode = numNode;
		this.directed = directed;
		edges = createNode(-1);
		nodes = createNodeList(numNode);
		for(int i = 0; i < numNode; i ++) nodes[i] = createNode(i);
	}

	public final int numEdge() { return edges.size(); }
	public Node edges() { return edges; }
	public Node[] nodes() { return nodes; }
	public Node reverseEdges() {
		if(reversedEdges == null) {
			reversedEdges = createNode(-1);
			for(Edge e : edges) reversedEdges.add(e.reverse());
		}
		return reversedEdges;
	}
	public Node[] reverseNodes() {
		if(reversedNodes == null) {
			reversedNodes = createNodeList(numNode);
			for(int i = 0; i < numNode; i ++) reversedNodes[i] = createNode(i);
			for(Edge e : edges) reversedNodes[e.target].add(e.reverse());
		}
		return reversedNodes;
	}

	public final void addAll(final Collection<? extends Edge> edges) { for(Edge e : edges) add(e); }
	public final void add(final Edge e) {
		edges.add(e);
		nodes[e.source].add(e);
		if(reversedEdges != null) reversedEdges.add(e.reverse());
		if(reversedNodes != null) reversedNodes[e.target].add(e.reverse());
		if(!directed) nodes[e.target].add(e.reverse());
	}

	public final void remove(final Edge e) {
		edges.remove(e);
		nodes[e.source].remove(e);
		if(reversedEdges != null) reversedEdges.add(e.reverse());
		if(reversedNodes != null) reversedNodes[e.target].remove(e.reverse());
		if(!directed) nodes[e.target].remove(e.reverse());
	}

	public final void clear() { edges.clear(); for(Node n : nodes) n.clear(); reversedEdges = null; reversedNodes = null; }
}
abstract class UnweightedGraph<Node extends UnweightedNode> extends AbstractGraph<Node, UnweightedEdge> {
	public UnweightedGraph(final int numNode, final boolean directed) { super(numNode, directed); }
	public void add(final int source, final int target) { add(new UnweightedEdge(source, target)); }
	@Override public Node edges() { return super.edges(); }
	@Override public Node[] nodes() { return super.nodes(); }
	@Override public Node[] reverseNodes() { return super.reverseNodes(); }
}
abstract class WeightedGraph<Node extends WeightedNode> extends AbstractGraph<Node, WeightedEdge> {
	public WeightedGraph(final int numNode, final boolean directed) { super(numNode, directed); }
	public void add(final int source, final int target, final long cost) { add(new WeightedEdge(source, target, cost)); }
	public void update(final WeightedEdge e, final long cost) { remove(e); e.cost = cost; add(e); }
	@Override public Node edges() { return super.edges(); }
	@Override public Node[] nodes() { return super.nodes(); }
	@Override public Node[] reverseNodes() { return super.reverseNodes(); }
}
abstract class TemplateGraph<T extends Comparable<T>, Node extends TemplateNode<T>> extends AbstractGraph<Node, TemplateEdge<T>> {
	public TemplateGraph(final int numNode, final boolean directed) { super(numNode, directed); }
	public void add(final int source, final int target, final T cost) { add(new TemplateEdge<T>(source, target, cost)); }
	public void update(final TemplateEdge<T> e, final T cost) { remove(e); e.cost = cost; add(e); }
	@Override public Node edges() { return super.edges(); }
	@Override public Node[] nodes() { return super.nodes(); }
	@Override public Node[] reverseNodes() { return super.reverseNodes(); }
}
class ArrayUnweightedGraph extends UnweightedGraph<ArrayUnweightedNode> {
	public ArrayUnweightedGraph(final int numNode, final boolean directed) { super(numNode, directed); }
	@Override protected final ArrayUnweightedNode createNode(final int id) { return new ArrayUnweightedNode(id); }
	@Override protected final ArrayUnweightedNode[] createNodeList(final int size) { return new ArrayUnweightedNode[size]; }
	@Override public ArrayUnweightedNode edges() { return super.edges(); }
	@Override public ArrayUnweightedNode[] nodes() { return super.nodes(); }
	@Override public ArrayUnweightedNode[] reverseNodes() { return super.reverseNodes(); }
}
class ArrayWeightedGraph extends WeightedGraph<ArrayWeightedNode> {
	public ArrayWeightedGraph(final int numNode, final boolean directed) { super(numNode, directed); }
	@Override protected final ArrayWeightedNode createNode(final int id) { return new ArrayWeightedNode(id); }
	@Override protected final ArrayWeightedNode[] createNodeList(final int size) { return new ArrayWeightedNode[size]; }
	@Override public ArrayWeightedNode edges() { return super.edges(); }
	@Override public ArrayWeightedNode[] nodes() { return super.nodes(); }
	@Override public ArrayWeightedNode[] reverseNodes() { return super.reverseNodes(); }
}
class ArrayTemplateGraph<T extends Comparable<T>> extends TemplateGraph<T, ArrayTemplateNode<T>> {
	public ArrayTemplateGraph(final int numNode, final boolean directed) { super(numNode, directed); }
	@Override protected final ArrayTemplateNode<T> createNode(final int id) { return new ArrayTemplateNode<T>(id); }
	@Override @SuppressWarnings("unchecked") protected final ArrayTemplateNode<T>[] createNodeList(final int size) { return new ArrayTemplateNode[size]; }
	@Override public ArrayTemplateNode<T> edges() { return super.edges(); }
	@Override public ArrayTemplateNode<T>[] nodes() { return super.nodes(); }
	@Override public ArrayTemplateNode<T>[] reverseNodes() { return super.reverseNodes(); }
}
class HashUnweightedGraph extends UnweightedGraph<HashUnweightedNode> {
	public HashUnweightedGraph(final int numNode, final boolean directed) { super(numNode, directed); }
	@Override protected final HashUnweightedNode createNode(final int id) { return new HashUnweightedNode(id); }
	@Override protected final HashUnweightedNode[] createNodeList(final int size) { return new HashUnweightedNode[size]; }
	@Override public HashUnweightedNode edges() { return super.edges(); }
	@Override public HashUnweightedNode[] nodes() { return super.nodes(); }
	@Override public HashUnweightedNode[] reverseNodes() { return super.reverseNodes(); }
}
class HashWeightedGraph extends WeightedGraph<HashWeightedNode> {
	public HashWeightedGraph(final int numNode, final boolean directed) { super(numNode, directed); }
	@Override protected final HashWeightedNode createNode(final int id) { return new HashWeightedNode(id); }
	@Override protected final HashWeightedNode[] createNodeList(final int size) { return new HashWeightedNode[size]; }
	@Override public HashWeightedNode edges() { return super.edges(); }
	@Override public HashWeightedNode[] nodes() { return super.nodes(); }
	@Override public HashWeightedNode[] reverseNodes() { return super.reverseNodes(); }
}
class HashTemplateGraph<T extends Comparable<T>> extends TemplateGraph<T, HashTemplateNode<T>> {
	public HashTemplateGraph(final int numNode, final boolean directed) { super(numNode, directed); }
	@Override protected final HashTemplateNode<T> createNode(final int id) { return new HashTemplateNode<T>(id); }
	@Override @SuppressWarnings("unchecked") protected final HashTemplateNode<T>[] createNodeList(final int size) { return new HashTemplateNode[size]; }
	@Override public HashTemplateNode<T> edges() { return super.edges(); }
	@Override public HashTemplateNode<T>[] nodes() { return super.nodes(); }
	@Override public HashTemplateNode<T>[] reverseNodes() { return super.reverseNodes(); }
}

interface AbstractNode<Edge extends AbstractEdge<Edge>> extends Collection<Edge> {  }
interface UnweightedNode extends AbstractNode<UnweightedEdge> { public boolean add(final int source, final int target); }
interface WeightedNode extends AbstractNode<WeightedEdge> { public boolean add(final int source, final int target, final long cost); }
interface TemplateNode<T extends Comparable<T>> extends AbstractNode<TemplateEdge<T>> { public boolean add(final int source, final int target, final T cost); }
class ArrayUnweightedNode extends ArrayList<UnweightedEdge> implements UnweightedNode {
	public final int id;
	public ArrayUnweightedNode(final int id) { this.id = id; }
	@Override public final boolean add(final int source, final int target) { return add(new UnweightedEdge(source, target)); }
}
class ArrayWeightedNode extends ArrayList<WeightedEdge> implements WeightedNode {
	public final int id;
	public ArrayWeightedNode(final int id) { this.id = id; }
	@Override public final boolean add(final int source, final int target, final long cost) { return add(new WeightedEdge(source, target, cost)); }
}
class ArrayTemplateNode<T extends Comparable<T>> extends ArrayList<TemplateEdge<T>> implements TemplateNode<T> {
	public final int id;
	public ArrayTemplateNode(final int id) { this.id = id; }
	@Override public final boolean add(final int source, final int target, final T cost) { return add(new TemplateEdge<T>(source, target, cost)); }
}
class HashUnweightedNode extends HashSet<UnweightedEdge> implements UnweightedNode {
	public final int id;
	public HashUnweightedNode(final int id) { this.id = id; }
	@Override public final boolean add(final int source, final int target) { return add(new UnweightedEdge(source, target)); }
}
class HashWeightedNode extends HashSet<WeightedEdge> implements WeightedNode {
	public final int id;
	public HashWeightedNode(final int id) { this.id = id; }
	@Override public final boolean add(final int source, final int target, final long cost) { return add(new WeightedEdge(source, target, cost)); }
}
class HashTemplateNode<T extends Comparable<T>> extends HashSet<TemplateEdge<T>> implements TemplateNode<T> {
	public final int id;
	public HashTemplateNode(final int id) { this.id = id; }
	@Override public final boolean add(final int source, final int target, final T cost) { return add(new TemplateEdge<T>(source, target, cost)); }
}

abstract class AbstractEdge<Edge extends AbstractEdge> {
	public int source, target;
	protected Edge reversed = null;
	public AbstractEdge(final int source, final int target) { this.source = source; this.target = target; }
	public final Edge reverse() { return reversed == null ? reversed = createReversed() : reversed; }
	protected abstract Edge createReversed();
	@Override public abstract String toString();
	@Override public final int hashCode() { return Objects.hash(source, target); }
	@Override public abstract boolean equals(final Object obj);
}
class UnweightedEdge extends AbstractEdge<UnweightedEdge> implements Comparable<UnweightedEdge> {
	public UnweightedEdge(final int source, final int target) { super(source, target); }
	public UnweightedEdge(final int source, final int target, final UnweightedEdge reversed) { this(source, target); this.reversed = reversed; }

	@Override protected final UnweightedEdge createReversed() { return new UnweightedEdge(target, source, this); }
	@Override public final String toString() { return source+" -> "+target; }
	@Override
	public final boolean equals(final Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		UnweightedEdge that = (UnweightedEdge) obj;
		if(this.source != that.source) return false;
		if(this.target != that.target) return false;
		return true;
	}
	@Override
	public final int compareTo(final UnweightedEdge that) {
		int c = Integer.compare(this.source, that.source);
		if(c == 0) c = Integer.compare(this.target, that.target);
		return c;
	}
}
class WeightedEdge extends AbstractEdge<WeightedEdge> implements Comparable<WeightedEdge> {
	public long cost;
	public WeightedEdge(final int source, final int target, final long cost) { super(source, target); this.cost = cost; }
	public WeightedEdge(final int source, final int target, final long cost, final WeightedEdge reversed) { this(source, target, cost); this.reversed = reversed; }
	@Override protected final WeightedEdge createReversed() { return new WeightedEdge(target, source, cost, this); }
	@Override public final String toString() { return source+" - "+cost+" -> "+target; }
	@Override
	public final boolean equals(final Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		WeightedEdge that = (WeightedEdge) obj;
		if(this.source != that.source) return false;
		if(this.target != that.target) return false;
		if(this.cost != that.cost) return false;
		return true;
	}
	@Override
	public final int compareTo(final WeightedEdge that) {
		int c = Long.compare(this.cost, that.cost);
		if(c == 0) c = Integer.compare(this.source, that.source);
		if(c == 0) c = Integer.compare(this.target, that.target);
		return c;
	}
}
class TemplateEdge<T extends Comparable<T>> extends AbstractEdge<TemplateEdge<T>> implements Comparable<TemplateEdge<T>> {
	public T cost;
	public TemplateEdge(final int source, final int target, final T cost) { super(source, target); this.cost = cost; }
	public TemplateEdge(final int source, final int target, final T cost, final TemplateEdge<T> reversed) { this(source, target, cost); this.reversed = reversed; }

	@Override protected final TemplateEdge<T> createReversed() { return new TemplateEdge<T>(target, source, cost, this); }
	@Override public final String toString() { return source+" - "+cost.toString()+" -> "+target; }
	@Override
	@SuppressWarnings("unchecked")
	public final boolean equals(final Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		TemplateEdge<T> that = (TemplateEdge<T>) obj;
		if(this.source != that.source) return false;
		if(this.target != that.target) return false;
		if(!this.cost.equals(that.cost)) return false;
		return true;
	}
	@Override
	public final int compareTo(final TemplateEdge<T> that) {
		int c = this.cost.compareTo(that.cost);
		if(c == 0) c = Integer.compare(this.source, that.source);
		if(c == 0) c = Integer.compare(this.target, that.target);
		return c;
	}
}