public class Vector2D implements Iterator<Integer> {

    int i, j;
    List<List<Integer>> vec2d;
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        this.i = 0;
        this.j = 0;
    }

    @Override
    public Integer next() {
        int res = vec2d.get(i).get(j);
        if(j+1 < vec2d.get(i).size())   j++;
        else{
            i++;
            j = 0;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        while(i < vec2d.size() && j == vec2d.get(i).size()){
            j = 0;
            i++;
        }
        return i < vec2d.size() && j < vec2d.get(i).size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */