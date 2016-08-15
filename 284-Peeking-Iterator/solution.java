// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer buff;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	    this.buff = null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(buff == null)    buff = iterator.next();
        return buff;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(buff != null){
	        int tmp = buff;
	        buff = null;
	        return tmp;
	    }
	    return iterator.next();
	}

	@Override
	public boolean hasNext() {
	    return buff != null || iterator.hasNext();
	}
}