class Matrix implements Comparable {
	private int r,c,dim;
	public int id;
	public Matrix(int _r, int _c) {
		r=_r;
		c=_c;
		dim=r*c;
	}
	public boolean tmatrix(){ return false; }
	public int complexity(){ return dim(); }
	public int r(){ return r; }
	public int c(){ return c; }
	public int dim(){ return dim; }
	public String toString(){ return "A"+id; }
	public String display(){ return toString()+"="+complexity(); }
	public int compareTo(Object m){ return complexity()-((Matrix)m).complexity(); }
}