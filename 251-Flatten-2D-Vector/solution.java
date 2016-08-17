public class Vector2D implements Iterator<Integer> {

    Iterator out, in;
    public Vector2D(List<List<Integer>> vec2d) {
        this.out = vec2d.iterator();
        if(this.out.hasNext()){
            this.in = ((List<Integer>)this.out.next()).iterator();
        }
        else{
            this.in = null;
        }
    }

    @Override
    public Integer next() {
        return (Integer)in.next();
    }

    @Override
    public boolean hasNext() {
        while(out.hasNext() && !in.hasNext())
            in = ((List<Integer>)out.next()).iterator();
        return in != null && in.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */