package library;

import java.util.*;
import library.FastIO;

abstract class AbstractGraph<Node extends AbstractNode<Edge>, Edge extends AbstractEdge<Edge>> {
	public int numNode;
	public boolean directed;
	private Node edges;
	private Node nodes[];
	private Node reversedEdges;
	private Node reversedNodes[];

	protected abstract Node createNode(final int id);
	protected abstract Node[] createNodes(final int size);

	public AbstractGraph(final int numNode, final boolean directed) {
		FastIO.nonNegativeCheck(numNode);
		this.numNode = numNode;
		this.directed = directed;
		edges = createNode(-1);
		nodes = createNodes(numNode);
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
			reversedNodes = createNodes(numNode);
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
abstract class ListGraph<Node extends ListNode<Edge>, Edge extends AbstractEdge<Edge>> extends AbstractGraph<Node, Edge> {
	public ListGraph(final int numNode, final boolean directed) { super(numNode, directed); }
}
final class UnweightedListGraph extends ListGraph<UnweightedListNode, UnweightedEdge> {
	public UnweightedListGraph(final int numNode, final boolean directed) { super(numNode, directed); }
	@Override protected final UnweightedListNode createNode(final int id) { return new UnweightedListNode(id); }
	@Override protected final UnweightedListNode[] createNodes(final int size) { return new UnweightedListNode[size]; }
	public void add(final int source, final int target) { add(new UnweightedEdge(source, target)); }
	@Override public UnweightedListNode edges() { return super.edges(); }
	@Override public UnweightedListNode[] nodes() { return super.nodes(); }
	@Override public UnweightedListNode[] reverseNodes() { return super.reverseNodes(); }
}
final class WeightedListGraph extends ListGraph<WeightedListNode, WeightedEdge> {
	public WeightedListGraph(final int numNode, final boolean directed) { super(numNode, directed); }
	@Override protected final WeightedListNode createNode(final int id) { return new WeightedListNode(id); }
	@Override protected final WeightedListNode[] createNodes(final int size) { return new WeightedListNode[size]; }
	public void add(final int source, final int target, final long cost) { add(new WeightedEdge(source, target, cost)); }
	@Override public WeightedListNode edges() { return super.edges(); }
	@Override public WeightedListNode[] nodes() { return super.nodes(); }
	@Override public WeightedListNode[] reverseNodes() { return super.reverseNodes(); }
}
final class TemplateListGraph<T> extends ListGraph<TemplateListNode<T>, TemplateEdge<T>> {
	public TemplateListGraph(final int numNode, final boolean directed) { super(numNode, directed); }
	@Override protected final TemplateListNode<T> createNode(final int id) { return new TemplateListNode<T>(id); }
	@Override @SuppressWarnings("unchecked") protected final TemplateListNode<T>[] createNodes(final int size) { return new TemplateListNode[size]; }
	public void add(final int source, final int target, final T cost) { add(new TemplateEdge<T>(source, target, cost)); }
	@Override public TemplateListNode<T> edges() { return super.edges(); }
	@Override public TemplateListNode<T>[] nodes() { return super.nodes(); }
	@Override public TemplateListNode<T>[] reverseNodes() { return super.reverseNodes(); }
}
final class ComparableTemplateListGraph<T extends Comparable<T>> extends ListGraph<ComparableTemplateListNode<T>, ComparableTemplateEdge<T>> {
	public ComparableTemplateListGraph(final int numNode, final boolean directed) { super(numNode, directed); }
	@Override protected final ComparableTemplateListNode<T> createNode(final int id) { return new ComparableTemplateListNode<T>(id); }
	@Override @SuppressWarnings("unchecked") protected final ComparableTemplateListNode<T>[] createNodes(final int size) { return new ComparableTemplateListNode[size]; }
	public void add(final int source, final int target, final T cost) { add(new ComparableTemplateEdge<T>(source, target, cost)); }
	@Override public ComparableTemplateListNode<T> edges() { return super.edges(); }
	@Override public ComparableTemplateListNode<T>[] nodes() { return super.nodes(); }
	@Override public ComparableTemplateListNode<T>[] reverseNodes() { return super.reverseNodes(); }
}
abstract class SetGraph<Node extends SetNode<Edge>, Edge extends AbstractEdge<Edge>> extends AbstractGraph<Node, Edge> {
	public SetGraph(final int numNode, final boolean directed) { super(numNode, directed); }
}
final class UnweightedSetGraph extends SetGraph<UnweightedSetNode, UnweightedEdge> {
	public UnweightedSetGraph(final int numNode, final boolean directed) { super(numNode, directed); }
	@Override protected final UnweightedSetNode createNode(final int id) { return new UnweightedSetNode(id); }
	@Override protected final UnweightedSetNode[] createNodes(final int size) { return new UnweightedSetNode[size]; }
	public void add(final int source, final int target) { add(new UnweightedEdge(source, target)); }
	@Override public UnweightedSetNode edges() { return super.edges(); }
	@Override public UnweightedSetNode[] nodes() { return super.nodes(); }
	@Override public UnweightedSetNode[] reverseNodes() { return super.reverseNodes(); }
}
final class WeightedSetGraph extends SetGraph<WeightedSetNode, WeightedEdge> {
	public WeightedSetGraph(final int numNode, final boolean directed) { super(numNode, directed); }
	@Override protected final WeightedSetNode createNode(final int id) { return new WeightedSetNode(id); }
	@Override protected final WeightedSetNode[] createNodes(final int size) { return new WeightedSetNode[size]; }
	public void add(final int source, final int target, final long cost) { add(new WeightedEdge(source, target, cost)); }
	@Override public WeightedSetNode edges() { return super.edges(); }
	@Override public WeightedSetNode[] nodes() { return super.nodes(); }
	@Override public WeightedSetNode[] reverseNodes() { return super.reverseNodes(); }
}
final class TemplateSetGraph<T> extends SetGraph<TemplateSetNode<T>, TemplateEdge<T>> {
	public TemplateSetGraph(final int numNode, final boolean directed) { super(numNode, directed); }
	@Override protected final TemplateSetNode<T> createNode(final int id) { return new TemplateSetNode<T>(id); }
	@Override @SuppressWarnings("unchecked") protected final TemplateSetNode<T>[] createNodes(final int size) { return new TemplateSetNode[size]; }
	public void add(final int source, final int target, final T cost) { add(new TemplateEdge<T>(source, target, cost)); }
	@Override public TemplateSetNode<T> edges() { return super.edges(); }
	@Override public TemplateSetNode<T>[] nodes() { return super.nodes(); }
	@Override public TemplateSetNode<T>[] reverseNodes() { return super.reverseNodes(); }
}
final class ComparableTemplateSetGraph<T extends Comparable<T>> extends SetGraph<ComparableTemplateSetNode<T>, ComparableTemplateEdge<T>> {
	public ComparableTemplateSetGraph(final int numNode, final boolean directed) { super(numNode, directed); }
	@Override protected final ComparableTemplateSetNode<T> createNode(final int id) { return new ComparableTemplateSetNode<T>(id); }
	@Override @SuppressWarnings("unchecked") protected final ComparableTemplateSetNode<T>[] createNodes(final int size) { return new ComparableTemplateSetNode[size]; }
	public void add(final int source, final int target, final T cost) { add(new ComparableTemplateEdge<T>(source, target, cost)); }
	@Override public ComparableTemplateSetNode<T> edges() { return super.edges(); }
	@Override public ComparableTemplateSetNode<T>[] nodes() { return super.nodes(); }
	@Override public ComparableTemplateSetNode<T>[] reverseNodes() { return super.reverseNodes(); }
}

interface AbstractNode<Edge extends AbstractEdge<Edge>> extends Collection<Edge> {  }
abstract class ListNode<Edge extends AbstractEdge<Edge>> extends ArrayList<Edge> implements AbstractNode<Edge> {
	public final int id;
	public ListNode(final int id) { this.id = id; }
}
abstract class SetNode<Edge extends AbstractEdge<Edge>> extends HashSet<Edge> implements AbstractNode<Edge> {
	public final int id;
	public SetNode(final int id) { this.id = id; }
}
interface UnweightedNode extends AbstractNode<UnweightedEdge> { public boolean add(final int source, final int target); }
interface WeightedNode extends AbstractNode<WeightedEdge> { public boolean add(final int source, final int target, final long cost); }
interface TemplateNode<T> extends AbstractNode<TemplateEdge<T>> { public boolean add(final int source, final int target, final T cost); }
interface ComparableTemplateNode<T extends Comparable<T>> extends AbstractNode<ComparableTemplateEdge<T>> { public boolean add(final int source, final int target, final T cost); }
final class UnweightedListNode extends ListNode<UnweightedEdge> implements UnweightedNode {
	public UnweightedListNode(final int id) { super(id); }
	@Override public final boolean add(final int source, final int target) { return add(new UnweightedEdge(source, target)); }
}
final class WeightedListNode extends ListNode<WeightedEdge> implements WeightedNode {
	public WeightedListNode(final int id) { super(id); }
	@Override public final boolean add(final int source, final int target, final long cost) { return add(new WeightedEdge(source, target, cost)); }
}
final class TemplateListNode<T> extends ListNode<TemplateEdge<T>> implements TemplateNode<T> {
	public TemplateListNode(final int id) { super(id); }
	@Override public final boolean add(final int source, final int target, final T cost) { return add(new TemplateEdge<T>(source, target, cost)); }
}
final class ComparableTemplateListNode<T extends Comparable<T>> extends ListNode<ComparableTemplateEdge<T>> implements ComparableTemplateNode<T> {
	public ComparableTemplateListNode(final int id) { super(id); }
	@Override public final boolean add(final int source, final int target, final T cost) { return add(new ComparableTemplateEdge<T>(source, target, cost)); }
}
final class UnweightedSetNode extends SetNode<UnweightedEdge> implements UnweightedNode {
	public UnweightedSetNode(final int id) { super(id); }
	@Override public final boolean add(final int source, final int target) { return add(new UnweightedEdge(source, target)); }
}
final class WeightedSetNode extends SetNode<WeightedEdge> implements WeightedNode {
	public WeightedSetNode(final int id) { super(id); }
	@Override public final boolean add(final int source, final int target, final long cost) { return add(new WeightedEdge(source, target, cost)); }
}
final class TemplateSetNode<T> extends SetNode<TemplateEdge<T>> implements TemplateNode<T> {
	public TemplateSetNode(final int id) { super(id); }
	@Override public final boolean add(final int source, final int target, final T cost) { return add(new TemplateEdge<T>(source, target, cost)); }
}
final class ComparableTemplateSetNode<T extends Comparable<T>> extends SetNode<ComparableTemplateEdge<T>> implements ComparableTemplateNode<T> {
	public ComparableTemplateSetNode(final int id) { super(id); }
	@Override public final boolean add(final int source, final int target, final T cost) { return add(new ComparableTemplateEdge<T>(source, target, cost)); }
}

abstract class AbstractEdge<Edge extends AbstractEdge> {
	public int source, target;
	protected Edge reversed = null;
	public AbstractEdge(final int source, final int target) { this.source = source; this.target = target; }
	public final Edge reverse() { return reversed == null ? reversed = createReversed() : reversed; }
	protected abstract Edge createReversed();
	@Override public abstract String toString();
	@Override public abstract boolean equals(final Object obj);
}
final class UnweightedEdge extends AbstractEdge<UnweightedEdge> implements Comparable<UnweightedEdge> {
	public UnweightedEdge(final int source, final int target) { super(source, target); }
	public UnweightedEdge(final int source, final int target, final UnweightedEdge reversed) { this(source, target); this.reversed = reversed; }

	@Override protected final UnweightedEdge createReversed() { return new UnweightedEdge(target, source, this); }
	@Override public final String toString() { return source+" -> "+target; }
	@Override public final int hashCode() { return Objects.hash(source, target); }
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
final class WeightedEdge extends AbstractEdge<WeightedEdge> implements Comparable<WeightedEdge> {
	public long cost;
	public WeightedEdge(final int source, final int target, final long cost) { super(source, target); this.cost = cost; }
	public WeightedEdge(final int source, final int target, final long cost, final WeightedEdge reversed) { this(source, target, cost); this.reversed = reversed; }
	@Override protected final WeightedEdge createReversed() { return new WeightedEdge(target, source, cost, this); }
	@Override public final String toString() { return source+" - "+cost+" -> "+target; }
	@Override public final int hashCode() { return Objects.hash(source, target, cost); }
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
final class TemplateEdge<T> extends AbstractEdge<TemplateEdge<T>> {
	public T cost;
	public TemplateEdge(final int source, final int target, final T cost) { super(source, target); this.cost = cost; }
	public TemplateEdge(final int source, final int target, final T cost, final TemplateEdge<T> reversed) { this(source, target, cost); this.reversed = reversed; }

	@Override protected final TemplateEdge<T> createReversed() { return new TemplateEdge<T>(target, source, cost, this); }
	@Override public final String toString() { return source+" - "+cost.toString()+" -> "+target; }
	@Override public final int hashCode() { return Objects.hash(source, target, cost); }
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
}
final class ComparableTemplateEdge<T extends Comparable<T>> extends AbstractEdge<ComparableTemplateEdge<T>> implements Comparable<ComparableTemplateEdge<T>> {
	public T cost;
	public ComparableTemplateEdge(final int source, final int target, final T cost) { super(source, target); this.cost = cost; }
	public ComparableTemplateEdge(final int source, final int target, final T cost, final ComparableTemplateEdge<T> reversed) { this(source, target, cost); this.reversed = reversed; }

	@Override protected final ComparableTemplateEdge<T> createReversed() { return new ComparableTemplateEdge<T>(target, source, cost, this); }
	@Override public final String toString() { return source+" - "+cost.toString()+" -> "+target; }
	@Override public final int hashCode() { return Objects.hash(source, target, cost); }
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
	public final int compareTo(final ComparableTemplateEdge<T> that) {
		int c = this.cost.compareTo(that.cost);
		if(c == 0) c = Integer.compare(this.source, that.source);
		if(c == 0) c = Integer.compare(this.target, that.target);
		return c;
	}
}