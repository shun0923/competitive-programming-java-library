package library;

import java.util.*;
import java.util.function.*;
import library.SimpleUtil;

class TemplateDynamicSwag<T> {
	Supplier<T> eSupplier;
	BinaryOperator<T> f;

	Deque<T> frontVal = new ArrayDeque<>();
	T front;
	Deque<T> back = new ArrayDeque<>();

	// O(1)
	TemplateDynamicSwag(Supplier<T> eSupplier, BinaryOperator<T> f) {
		this.eSupplier = eSupplier;
		this.f = f;
		front = eSupplier.get();
	}

	// O(1)
	T fold() { return back.isEmpty() ? front : f.apply(back.getLast(), front); }
	// O(1)
	void push(T x) {
		frontVal.addLast(x);
		front = f.apply(front, x);
	}
	// O(1) amortized
	void pop() {
		if(back.isEmpty()) {
			T tmp = eSupplier.get();
			while(!frontVal.isEmpty()) {
				tmp = f.apply(frontVal.removeLast(), tmp);
				back.addLast(tmp);
			}
			front = eSupplier.get();
		}
		back.removeLast();
	}
}