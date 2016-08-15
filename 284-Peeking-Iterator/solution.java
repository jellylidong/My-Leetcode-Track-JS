// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    Queue<Integer> buff;
    Iterator<Integer> iterator;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.buff = new LinkedList<>();
	    this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(buff.isEmpty() && iterator.hasNext())
            buff.offer(iterator.next());
        return buff.peek();
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(!buff.isEmpty()) return buff.poll();
	    else return iterator.next();
	}

	@Override
	public boolean hasNext() {
	    return !buff.isEmpty() || iterator.hasNext();
	}
}