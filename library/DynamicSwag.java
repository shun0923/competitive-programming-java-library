package library;

import java.util.*;
import java.util.function.*;
import library.SimpleUtil;
import library.Pair;

class DynamicSwag {
	long e;
	LongBinaryOperator f;

	Deque<Long> frontVal = new ArrayDeque<>();
	long front;
	Deque<Long> back = new ArrayDeque<>();

	// O(1)
	DynamicSwag(long e, LongBinaryOperator f) {
		this.e = e;
		this.f = f;
		front = e;
	}

	// O(1)
	long fold() { return back.isEmpty() ? front : f.applyAsLong(back.getLast(), front); }
	// O(1)
	void push(long x) {
		frontVal.addLast(x);
		front = f.applyAsLong(front, x);
	}
	// O(1) amortized
	void pop() {
		if(back.isEmpty()) {
			long tmp = e;
			while(!frontVal.isEmpty()) {
				tmp = f.applyAsLong(frontVal.removeLast(), tmp);
				back.addLast(tmp);
			}
			front = e;
		}
		back.removeLast();
	}
}